package com.sngular.event.contracts.bankserver.service;

import java.util.stream.Stream;

import com.sngular.event.contracts.bankserver.model.BankAccountEntity;
import com.sngular.event.contracts.bankserver.model.BankMovementEntity;

public interface BankProcessService {

    BankMovementEntity save(BankMovementEntity bankMovementEntity);

    BankAccountEntity save(BankAccountEntity bankAccountEntity);

    Stream<BankAccountEntity> getAllAccounts();

    BankAccountEntity process(BankMovementEntity bankMovementEntity);
}
