package com.sngular.event.performance.repository.document;

import java.time.LocalDateTime;

import com.sngular.event.performance.model.BankMovementType;
import lombok.Builder;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Value
@Builder(toBuilder = true)
@Document(collection = "movements")
public class BankMovementDocument {

    @Id
    String id;

    String movementId;

    String accountNumber;

    BankMovementType movement;

    String amount;

    LocalDateTime movementDate;

    LocalDateTime appliedDate;
}
