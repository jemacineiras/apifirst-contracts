package com.sngular.event.performance.listener.mapper;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.ByteBuffer;

import com.sngular.event.performance.model.BankMovementEntity;
import com.sngular.event.performance.model.BankMovementEvent;
import org.mapstruct.Mapper;

@Mapper
public interface BankMovementEventMapper {

    BankMovementEntity map(BankMovementEvent bankMovementEvent);

    BankMovementEvent map(BankMovementEntity bankMovementEntity);

    default BigDecimal map(ByteBuffer decimal) {
        return new BigDecimal(new BigInteger(decimal.array()), 1);
    }

    default ByteBuffer map(BigDecimal decimal) {
        return ByteBuffer.wrap(decimal.unscaledValue().toByteArray());
    }
}
