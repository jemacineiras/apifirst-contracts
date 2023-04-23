package com.sngular.event.performance.repository.crud;

import com.sngular.event.performance.repository.document.BankMovementDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BankMovementCrudRepository extends MongoRepository<BankMovementDocument, String> {
    BankMovementDocument findByMovementId(String id);
}
