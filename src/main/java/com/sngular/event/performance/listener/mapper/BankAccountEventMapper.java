package com.sngular.event.performance.listener.mapper;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.ByteBuffer;

import com.sngular.event.performance.model.BankAccountEntity;
import com.sngular.event.performance.model.BankAccountEvent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
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
}
