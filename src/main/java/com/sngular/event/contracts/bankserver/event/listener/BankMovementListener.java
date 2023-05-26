package com.sngular.event.contracts.bankserver.event.listener;

import com.sngular.event.contracts.bankserver.event.mapper.BankMovementEventMapper;
import com.sngular.event.contracts.bankserver.event.model.schemas.BankMovementEvent;
import com.sngular.event.contracts.bankserver.service.BankProcessService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
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
    log.info(movement.toString());
  }
}
