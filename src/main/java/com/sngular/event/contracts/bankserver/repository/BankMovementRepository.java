package com.sngular.event.contracts.bankserver.repository;

import com.sngular.event.contracts.bankserver.model.BankMovementEntity;

public interface BankMovementRepository {

    BankMovementEntity save(BankMovementEntity bankMovementEntity);

    BankMovementEntity update(BankMovementEntity appliedMovement);
}
