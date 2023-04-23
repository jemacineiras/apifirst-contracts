package com.sngular.event.performance.repository.crud;

import com.sngular.event.performance.repository.document.BankAccountDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BankAccountCrudRepository extends MongoRepository<BankAccountDocument, String> {

    BankAccountDocument findByAccountNumber(String accountNumber);
}
