package com.sngular.event.performance.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.stream.Stream;

import com.sngular.event.performance.model.BankAccountEntity;
import com.sngular.event.performance.model.BankMovementEntity;
import com.sngular.kloadgen.demo.MovementType;
import com.sngular.event.performance.repository.BankAccountRepository;
import com.sngular.event.performance.repository.BankMovementRepository;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BankProcessServiceImpl implements BankProcessService {

    private final Counter processedCounter;

    private final BankAccountRepository bankAccountRepository;

    private final BankMovementRepository bankMovementRepository;

    protected BankProcessServiceImpl(final BankAccountRepository bankAccountRepository, final BankMovementRepository bankMovementRepository, final MeterRegistry metricRegistry) {
        this.bankAccountRepository = bankAccountRepository;
        this.bankMovementRepository = bankMovementRepository;
        processedCounter = Counter.builder("bank.account.processed").description("Number of bank accounts processed").register(metricRegistry);
    }

    @Override
    public BankMovementEntity save(BankMovementEntity bankMovementEntity) {
        return bankMovementRepository.save(bankMovementEntity);
    }

    @Override
    public BankAccountEntity save(BankAccountEntity bankAccountEntity) {
        var oldAccount = bankAccountRepository.findByAccountNumber(bankAccountEntity.getAccountNumber());
        if (Objects.nonNull(oldAccount)) {
            var updatedAccount = oldAccount.toBuilder().amount(bankAccountEntity.getAmount()).build();
            return bankAccountRepository.save(updatedAccount);
        } else {
            return  bankAccountRepository.save(bankAccountEntity);
        }
    }

    @Override
    public BankAccountEntity process(BankMovementEntity bankMovementEntity) {
        BankAccountEntity accountEntity = null;
        try {
            var bankAccount = bankAccountRepository.findByAccountNumber(bankMovementEntity.getAccountNumber());
            var updatedBankAccount = bankAccount.toBuilder().modifyAmount(calculateMovement(bankMovementEntity, bankMovementEntity.getAmount())).lastUpdateDate(LocalDateTime.now()).build();
            var appliedMovement = bankMovementEntity.toBuilder().appliedDate(LocalDateTime.now()).build();
            bankMovementRepository.update(appliedMovement);
            processedCounter.increment();
            accountEntity = bankAccountRepository.save(updatedBankAccount);
        }
        catch (NullPointerException e) {

            log.info("Movement´s account number {} does not exist in our database.", bankMovementEntity.getAccountNumber());
        }
        return accountEntity;
    }

    private BigDecimal calculateMovement(BankMovementEntity bankMovementEntity, BigDecimal amount) {

        return MovementType.WITHDRAW.equals(bankMovementEntity.getMovement()) ?
            amount.multiply(BigDecimal.valueOf(-1)) :
            amount;
    }


    @Override
    public Stream<BankAccountEntity> getAllAccounts() {
        return bankAccountRepository.findAll();
    }
}
