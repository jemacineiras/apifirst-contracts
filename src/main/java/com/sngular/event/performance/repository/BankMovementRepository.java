package com.sngular.event.performance.repository;

import com.sngular.event.performance.model.BankMovementEntity;

public interface BankMovementRepository {

    BankMovementEntity save(BankMovementEntity bankMovementEntity);

    BankMovementEntity update(BankMovementEntity appliedMovement);
}
