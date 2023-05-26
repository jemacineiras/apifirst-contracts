package com.sngular.event.contracts.bankserver.event.listener;

import java.util.function.Function;

import com.sngular.event.contracts.bankserver.event.mapper.BankAccountEventMapper;
import com.sngular.event.contracts.bankserver.event.mapper.BankMovementEventMapper;
import com.sngular.event.contracts.bankserver.event.model.schemas.BankAccountEvent;
import com.sngular.event.contracts.bankserver.event.model.schemas.BankMovementEvent;
import com.sngular.event.contracts.bankserver.service.BankProcessService;
import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BankMovementProcessor {

    private final BankProcessService bankProcessService;

    private final BankAccountEventMapper bankAccountEventMapper;

    private final BankMovementEventMapper bankMovementEventMapper;

    @Bean
    @Timed(value = "bank.movement.processed", description = "Time to process the movement")
    public Function<BankMovementEvent, BankAccountEvent> processData() {
        return movement -> bankAccountEventMapper.map(bankProcessService.process(bankMovementEventMapper.map(movement)));
    }

}
