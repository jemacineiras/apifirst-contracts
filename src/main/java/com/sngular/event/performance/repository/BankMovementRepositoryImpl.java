package com.sngular.event.performance.repository;

import com.sngular.event.performance.model.BankMovementEntity;
import com.sngular.event.performance.repository.crud.BankMovementCrudRepository;
import com.sngular.event.performance.repository.mapper.BankMovementDocumentMapper;
import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BankMovementRepositoryImpl implements BankMovementRepository {

  private final BankMovementCrudRepository movementCrudRepository;

  private final BankMovementDocumentMapper documentMapper;

  @Override
  @Timed("bank_movement_saved")
  public BankMovementEntity save(BankMovementEntity bankMovementEntity) {
    return documentMapper.map(movementCrudRepository.save(documentMapper.map(bankMovementEntity)));
  }

  @Override
  @Timed("bank_movement_updated")
  public BankMovementEntity update(BankMovementEntity appliedMovement) {
    var movement = movementCrudRepository.findByMovementId(appliedMovement.getId());
    return documentMapper.map(movementCrudRepository.save(movement.toBuilder().appliedDate(appliedMovement.getAppliedDate()).build()));
  }
}
