package com.sngular.event.contracts.bankserver.event.listener;

import com.sngular.event.contracts.bankserver.event.mapper.BankAccountEventMapper;
import com.sngular.event.contracts.bankserver.event.model.schemas.BankAccountEvent;
import com.sngular.event.contracts.bankserver.service.BankProcessService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class BankAccountListener implements IStoreAccount {

  private final Counter accountCounter;

  private final BankProcessService bankProcessService;

  private final BankAccountEventMapper bankAccountEventMapper;

  protected BankAccountListener(final BankProcessService bankProcessService, final BankAccountEventMapper bankAccountEventMapper, final MeterRegistry registry) {
    this.bankProcessService = bankProcessService;
    this.bankAccountEventMapper = bankAccountEventMapper;
    accountCounter = Counter.builder("bank.account.received").description("Counter for bank accounts").register(registry);
  }

  @Override
  public void storeAccount(final BankAccountEvent account) {
    bankProcessService.save(bankAccountEventMapper.map(account));
    accountCounter.increment();
    log.info(account.toString());
  }
}
