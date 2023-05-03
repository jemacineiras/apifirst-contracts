package com.sngular.event.performance.repository;

import com.sngular.event.performance.repository.crud.BankAccountCrudRepository;
import com.sngular.event.performance.repository.mapper.BankAccountDocumentMapper;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@AllArgsConstructor
@ExtendWith(SpringExtension.class)
class BankAccountRepositoryTest {

  @MockBean
  private BankAccountCrudRepository bankAccountCrudRepository;

  private BankAccountRepository bankAccountRepository;

  @Test
  void findByAccountNumber() {
  }

  @Test
  void findAll() {
  }

  @Test
  void save() {
  }

  @TestConfiguration
  public static class BankAccountRepositoryTestConfiguration {

    @Bean
    public BankAccountDocumentMapper bankAccountDocumentMapper() {
      return Mappers.getMapper(BankAccountDocumentMapper.class);
    }
  }
}