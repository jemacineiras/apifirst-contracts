package com.sngular.event.performance.repository;

import java.util.stream.Stream;

import com.sngular.event.performance.model.BankAccountEntity;

public interface BankAccountRepository {

    BankAccountEntity findByAccountNumber(String accountNumber);

    Stream<BankAccountEntity> findAll();

    BankAccountEntity save(BankAccountEntity updatedBankAccount);
}
