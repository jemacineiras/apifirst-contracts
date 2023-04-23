package com.sngular.event.performance.service;

import java.util.stream.Stream;

import com.sngular.event.performance.model.BankAccountEntity;
import com.sngular.event.performance.model.BankMovementEntity;

public interface BankProcessService {

    BankMovementEntity save(BankMovementEntity bankMovementEntity);

    BankAccountEntity save(BankAccountEntity bankAccountEntity);

    Stream<BankAccountEntity> getAllAccounts();

    BankAccountEntity process(BankMovementEntity bankMovementEntity);
}
