package com.sngular.event.performance.emitter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.sngular.event.performance.listener.mapper.BankAccountEventMapper;
import com.sngular.kloadgen.demo.BankAccountEvent;
import com.sngular.event.performance.service.BankProcessService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

@Component
public class BankAccountEmitter implements IAccountEmitter {

  private final Counter accountCounter;

  private final BankProcessService bankProcessService;

  private final BankAccountEventMapper bankAccountEventMapper;

  private List<BankAccountEvent> inMemoryCache = new ArrayList<>();

  protected BankAccountEmitter(final BankProcessService bankProcessService, final BankAccountEventMapper bankAccountEventMapper, final MeterRegistry registry) {
    this.bankProcessService = bankProcessService;
    this.bankAccountEventMapper = bankAccountEventMapper;
    accountCounter  = Counter.builder("bank.account.emitted").description("Counter for bank accounts emitted").register(registry);
  }

  @Override
  public BankAccountEvent accountEmitter() {
    if (inMemoryCache.isEmpty()) {
      inMemoryCache.addAll(bankProcessService.getAllAccounts().map(bankAccountEventMapper::map).collect(Collectors.toList()));
    }
    accountCounter.increment();
    return inMemoryCache.remove(0);
  }
}
