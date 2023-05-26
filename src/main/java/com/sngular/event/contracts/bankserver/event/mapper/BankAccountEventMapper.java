package com.sngular.event.contracts.bankserver.event.mapper;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.sngular.event.contracts.bankserver.event.model.schemas.BankAccountEvent;
import com.sngular.event.contracts.bankserver.model.BankAccountEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BankAccountEventMapper {

    @Mapping(target = "modifyAmount", ignore = true)
    BankAccountEntity map(BankAccountEvent bankAccountEvent);

    BankAccountEvent map(BankAccountEntity bankAccountEntity);

    default BigDecimal map(ByteBuffer decimal) {
        return new BigDecimal(new BigInteger(decimal.array()), 1);
    }

    default ByteBuffer map(BigDecimal decimal) {
        return ByteBuffer.wrap(decimal.unscaledValue().toByteArray());
    }

    default LocalDateTime map(String localDateTime) {
        return LocalDateTime.parse(localDateTime);
    }
    default String map(LocalDateTime localDateTime) {
        return localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
    }

}
