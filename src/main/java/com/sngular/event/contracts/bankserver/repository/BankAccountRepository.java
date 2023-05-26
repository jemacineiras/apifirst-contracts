package com.sngular.event.contracts.bankserver.repository;

import java.util.stream.Stream;

import com.sngular.event.contracts.bankserver.model.BankAccountEntity;

public interface BankAccountRepository {

    BankAccountEntity findByAccountNumber(String accountNumber);

    Stream<BankAccountEntity> findAll();

    BankAccountEntity save(BankAccountEntity updatedBankAccount);
}
