package com.sngular.event.contracts.bankserver.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class BankMovementEntity {

    String id;

    String accountNumber;

    MovementType movement;

    BigDecimal amount;

    LocalDateTime movementDate;

    LocalDateTime appliedDate;
}
