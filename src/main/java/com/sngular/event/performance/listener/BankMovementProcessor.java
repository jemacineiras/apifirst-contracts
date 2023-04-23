package com.sngular.event.performance.listener;

import java.util.function.Function;

import com.sngular.event.performance.listener.mapper.BankAccountEventMapper;
import com.sngular.event.performance.listener.mapper.BankMovementEventMapper;
import com.sngular.event.performance.model.BankAccountEvent;
import com.sngular.event.performance.model.BankMovementEvent;
import com.sngular.event.performance.service.BankProcessService;
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
