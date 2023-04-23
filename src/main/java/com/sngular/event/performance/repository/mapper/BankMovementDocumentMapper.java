package com.sngular.event.performance.repository.mapper;

import com.sngular.event.performance.model.BankMovementEntity;
import com.sngular.event.performance.repository.document.BankMovementDocument;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface BankMovementDocumentMapper {

    @Mapping(source = "id", target = "movementId")
    BankMovementDocument map(BankMovementEntity bankAccountEntity);

    @Mapping(source = "movementId", target = "id")
    BankMovementEntity map(BankMovementDocument bankMovementDocument);
}
