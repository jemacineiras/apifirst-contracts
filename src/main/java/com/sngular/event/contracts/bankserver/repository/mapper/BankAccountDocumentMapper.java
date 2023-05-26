package com.sngular.event.contracts.bankserver.repository.mapper;

import com.sngular.event.contracts.bankserver.model.BankAccountEntity;
import com.sngular.event.contracts.bankserver.repository.document.BankAccountDocument;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BankAccountDocumentMapper {

    BankAccountDocument map(BankAccountEntity bankAccountEntity);

    @Mapping(target = "modifyAmount", ignore = true)
    BankAccountEntity map(BankAccountDocument bankAccountEntity);
}
