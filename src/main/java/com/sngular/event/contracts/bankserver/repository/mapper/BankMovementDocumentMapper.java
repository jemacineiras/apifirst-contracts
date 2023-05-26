package com.sngular.event.contracts.bankserver.repository.mapper;

import com.sngular.event.contracts.bankserver.model.BankMovementEntity;
import com.sngular.event.contracts.bankserver.repository.document.BankMovementDocument;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BankMovementDocumentMapper {

    @Mapping(source = "id", target = "movementId")
    BankMovementDocument map(BankMovementEntity bankAccountEntity);

    @Mapping(source = "movementId", target = "id")
    BankMovementEntity map(BankMovementDocument bankMovementDocument);
}
