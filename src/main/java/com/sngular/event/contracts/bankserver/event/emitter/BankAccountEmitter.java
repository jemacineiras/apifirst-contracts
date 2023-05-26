package com.sngular.event.contracts.bankserver.event.emitter;

import com.sngular.event.contracts.bankserver.event.mapper.BankAccountEventMapper;
import com.sngular.event.contracts.bankserver.model.BankAccountEntity;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

@Component
public class BankAccountEmitter {

  private final StreamBridgeProducer producer;
  private final Counter accountCounter;

  private final BankAccountEventMapper bankAccountEventMapper;

  protected BankAccountEmitter(final BankAccountEventMapper bankAccountEventMapper, final MeterRegistry registry, final StreamBridgeProducer producer) {
    this.bankAccountEventMapper = bankAccountEventMapper;
    this.accountCounter  = Counter.builder("bank.account.emitted").description("Counter for bank accounts emitted").register(registry);
    this.producer = producer;
  }

  public void accountEmitter(BankAccountEntity bankAccountEntity) {
    producer.accountEmitter(bankAccountEventMapper.map(bankAccountEntity));
    accountCounter.increment();
  }

}
