package com.sngular.event.contracts.bankserver.repository.crud;

import com.sngular.event.contracts.bankserver.repository.document.BankMovementDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BankMovementCrudRepository extends MongoRepository<BankMovementDocument, String> {
    BankMovementDocument findByMovementId(String id);
}
