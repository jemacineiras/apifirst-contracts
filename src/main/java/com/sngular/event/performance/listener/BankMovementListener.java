package com.sngular.event.performance.listener;

import com.sngular.event.performance.listener.mapper.BankMovementEventMapper;
import com.sngular.event.performance.model.BankMovementEvent;
import com.sngular.event.performance.service.BankProcessService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

@Component
public class BankMovementListener implements IStoreMovement {

  private final Counter movementCounter;

  private final BankProcessService bankProcessService;

  private final BankMovementEventMapper bankMovementEventMapper;

  protected BankMovementListener(final BankProcessService bankProcessService, final BankMovementEventMapper bankMovementEventMapper, final MeterRegistry registry) {
    this.bankProcessService = bankProcessService;
    this.bankMovementEventMapper = bankMovementEventMapper;
    movementCounter = Counter.builder("bank.movement").description("Counter for bank movements").register(registry);
  }

  @Override
  public void storeMovement(final BankMovementEvent movement) {
    bankProcessService.save(bankMovementEventMapper.map(movement));
    movementCounter.increment();
  }
}
