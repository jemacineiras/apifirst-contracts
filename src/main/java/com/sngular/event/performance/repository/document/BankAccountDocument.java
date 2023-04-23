package com.sngular.event.performance.repository.document;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Value
@Builder
@Document(collection = "accounts")
public class BankAccountDocument {

    @Id
    String id;

    String name;

    String accountNumber;

    String amount;


    LocalDateTime lastUpdateDate;

    LocalDateTime creationDate;
}
