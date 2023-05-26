package com.sngular.event.contracts.bankserver.repository.crud;

import com.sngular.event.contracts.bankserver.repository.document.BankAccountDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BankAccountCrudRepository extends MongoRepository<BankAccountDocument, String> {

    BankAccountDocument findByAccountNumber(String accountNumber);
}
