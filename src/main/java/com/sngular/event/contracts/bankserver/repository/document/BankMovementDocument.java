package com.sngular.event.contracts.bankserver.repository.document;

import java.time.LocalDateTime;

import com.sngular.event.contracts.bankserver.model.MovementType;
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

    MovementType movement;

    String amount;

    LocalDateTime movementDate;

    LocalDateTime appliedDate;
}
