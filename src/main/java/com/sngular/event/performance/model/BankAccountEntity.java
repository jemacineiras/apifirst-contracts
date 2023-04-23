package com.sngular.event.performance.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class BankAccountEntity {

    String id;

    String name;

    String accountNumber;

    BigDecimal amount;


    LocalDateTime lastUpdateDate;

    LocalDateTime creationDate;

    public static class BankAccountEntityBuilder {

        private BigDecimal amount;

        public BankAccountEntityBuilder modifyAmount(BigDecimal amount) {
            this.amount = this.amount.add(amount);
            return this;
        }

    }
}