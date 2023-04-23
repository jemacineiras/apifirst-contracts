package com.sngular.event.performance.repository.mapper;

import com.sngular.event.performance.model.BankAccountEntity;
import com.sngular.event.performance.repository.document.BankAccountDocument;
import org.mapstruct.Mapper;

@Mapper
public interface BankAccountDocumentMapper {

    BankAccountDocument map(BankAccountEntity bankAccountEntity);

    BankAccountEntity map(BankAccountDocument bankAccountEntity);
}
