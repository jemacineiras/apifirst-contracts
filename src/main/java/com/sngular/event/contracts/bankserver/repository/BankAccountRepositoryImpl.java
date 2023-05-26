package com.sngular.event.contracts.bankserver.repository;

import java.time.LocalDateTime;
import java.util.stream.Stream;

import com.sngular.event.contracts.bankserver.model.BankAccountEntity;
import com.sngular.event.contracts.bankserver.repository.crud.BankAccountCrudRepository;
import com.sngular.event.contracts.bankserver.repository.mapper.BankAccountDocumentMapper;
import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BankAccountRepositoryImpl implements BankAccountRepository {

    private final BankAccountCrudRepository bankAccountCrudRepository;

    private final BankAccountDocumentMapper documentMapper;

    @Override
    public BankAccountEntity findByAccountNumber(String accountNumber) {
        return documentMapper.map(bankAccountCrudRepository.findByAccountNumber(accountNumber));
    }

    @Override
    public Stream<BankAccountEntity> findAll() {
        return bankAccountCrudRepository.findAll().stream().map(documentMapper::map);
    }

    @Override
    @Timed("bank_account_updated")
    public BankAccountEntity save(BankAccountEntity updatedBankAccount) {
        return documentMapper.map(bankAccountCrudRepository.save(documentMapper.map(updatedBankAccount.toBuilder().lastUpdateDate(
            LocalDateTime.now()).build())));
    }
}
