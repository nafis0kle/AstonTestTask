package com.aston.testtask.bank.domain.mapper;

import com.aston.testtask.bank.domain.dto.BankCreateUpdateDto;
import com.aston.testtask.bank.domain.dto.BankDto;
import com.aston.testtask.bank.domain.entity.Bank;
import com.aston.testtask.bank.domain.entity.BankAccount;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-06T14:20:12+0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.2.1.jar, environment: Java 11.0.13 (Oracle Corporation)"
)
@Component
public class BankMapperImpl implements BankMapper {

    @Override
    public Bank fromCreateUpdateDto(BankCreateUpdateDto bankCreateUpdateDto) {
        if ( bankCreateUpdateDto == null ) {
            return null;
        }

        Bank bank = new Bank();

        bank.setName( bankCreateUpdateDto.getName() );

        return bank;
    }

    @Override
    public BankDto toDto(Bank bank) {
        if ( bank == null ) {
            return null;
        }

        BankDto.BankDtoBuilder bankDto = BankDto.builder();

        bankDto.id( bank.getId() );
        bankDto.name( bank.getName() );

        return bankDto.build();
    }

    @Override
    public Bank merge(Bank target, Bank source) {
        if ( source == null ) {
            return target;
        }

        if ( source.getId() != null ) {
            target.setId( source.getId() );
        }
        if ( source.getName() != null ) {
            target.setName( source.getName() );
        }
        if ( target.getBankAccounts() != null ) {
            target.getBankAccounts().clear();
            List<BankAccount> list = source.getBankAccounts();
            if ( list != null ) {
                target.getBankAccounts().addAll( list );
            }
        }

        return target;
    }
}
