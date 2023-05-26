package com.sngular.event.contracts.bankserver.event.mapper;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.ByteBuffer;

import com.sngular.event.contracts.bankserver.event.model.schemas.BankMovementEvent;
import com.sngular.event.contracts.bankserver.model.BankMovementEntity;
import com.sngular.event.contracts.bankserver.model.MovementType;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BankMovementEventMapper {

    BankMovementEntity map(BankMovementEvent bankMovementEvent);

    BankMovementEvent map(BankMovementEntity bankMovementEntity);

    default BigDecimal map(ByteBuffer decimal) {
        return new BigDecimal(new BigInteger(decimal.array()), 1);
    }

    default ByteBuffer map(BigDecimal decimal) {
        return ByteBuffer.wrap(decimal.unscaledValue().toByteArray());
    }

    default MovementType map(String movementType) {
        return MovementType.valueOf(movementType);
    }

    default String map(MovementType movementType) {
        return movementType.name();
    }
}
