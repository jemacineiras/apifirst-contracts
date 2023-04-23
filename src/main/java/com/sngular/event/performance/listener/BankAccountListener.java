package com.sngular.event.performance.listener;

import com.sngular.event.performance.listener.mapper.BankAccountEventMapper;
import com.sngular.event.performance.model.BankAccountEvent;
import com.sngular.event.performance.service.BankProcessService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

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
  }

}
