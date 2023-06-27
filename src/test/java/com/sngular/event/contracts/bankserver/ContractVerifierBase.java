package com.sngular.event.contracts.bankserver;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.sngular.event.contracts.bankserver.event.emitter.BankAccountEmitter;
import com.sngular.event.contracts.bankserver.model.BankAccountEntity;
import com.sngular.event.contracts.bankserver.model.BankMovementEntity;
import com.sngular.event.contracts.bankserver.model.MovementType;
import com.sngular.event.contracts.bankserver.service.BankProcessService;
import io.micrometer.core.instrument.Counter;
import org.junit.jupiter.api.TestInstance;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.cloud.stream.binder.test.TestChannelBinderConfiguration;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@AutoConfigureMessageVerifier
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ImportAutoConfiguration(TestChannelBinderConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class ContractVerifierBase {

  @MockBean
  private BankProcessService bankProcessService;

  @MockBean
  private Counter accountCounter;

  @Captor
  private ArgumentCaptor<BankAccountEntity> bankAccountEntityCaptor;

  @Captor
  private ArgumentCaptor<BankMovementEntity> bankMovementEntityCaptor;

  @Autowired
  private BankAccountEmitter bankAccountEmitter;

  public void accountEmitter() {
    bankAccountEmitter.accountEmitter(BankAccountEntity
                                        .builder()
                                        .id("id")
                                        .name("Jose")
                                        .accountNumber("0092")
                                        .amount(new BigDecimal("23.45"))
                                        .creationDate(LocalDateTime.now())
                                        .lastUpdateDate(LocalDateTime.now())
                                        .build());
  }

  void storeMovementValidation() {
    verify(bankProcessService).save(bankMovementEntityCaptor.capture());

    final var value = bankMovementEntityCaptor.getValue();

    assertThat(value)
      .isNotNull()
      .isInstanceOf(BankMovementEntity.class)
      .usingRecursiveComparison()
      .ignoringFields("movementDate", "appliedDate")
      .isEqualTo(BankMovementEntity.builder()
                                  .id("1")
                                  .amount(BigDecimal.valueOf(10.45))
                                  .accountNumber("00001")
                                  .movement(MovementType.DEPOSIT)
                                  .build());
  }

  void storeAccountValidation() {
    verify(bankProcessService).save(bankAccountEntityCaptor.capture());

    var value = bankAccountEntityCaptor.getValue();
    assertThat(value).isNotNull();

  }
}
