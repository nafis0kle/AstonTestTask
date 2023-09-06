package com.aston.testtask.bank.domain.mapper;

import com.aston.testtask.bank.domain.dto.BankAccountCreateDto;
import com.aston.testtask.bank.domain.dto.BankAccountDto;
import com.aston.testtask.bank.domain.dto.BankAccountGridDto;
import com.aston.testtask.bank.domain.dto.BankDto;
import com.aston.testtask.bank.domain.entity.Bank;
import com.aston.testtask.bank.domain.entity.BankAccount;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-06T14:20:12+0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.2.1.jar, environment: Java 11.0.13 (Oracle Corporation)"
)
@Component
public class BankAccountMapperImpl implements BankAccountMapper {

    @Override
    public BankAccount fromBankAccountCreateDto(BankAccountCreateDto bankAccountCreateDto) {
        if ( bankAccountCreateDto == null ) {
            return null;
        }

        BankAccount bankAccount = new BankAccount();

        bankAccount.setUserName( bankAccountCreateDto.getUserName() );
        bankAccount.setPinCode( bankAccountCreateDto.getPinCode() );

        return bankAccount;
    }

    @Override
    public BankAccountDto toDto(BankAccount bankAccount) {
        if ( bankAccount == null ) {
            return null;
        }

        BankAccountDto.BankAccountDtoBuilder bankAccountDto = BankAccountDto.builder();

        bankAccountDto.id( bankAccount.getId() );
        bankAccountDto.userName( bankAccount.getUserName() );
        bankAccountDto.pinCode( bankAccount.getPinCode() );
        bankAccountDto.number( bankAccount.getNumber() );
        bankAccountDto.balance( bankAccount.getBalance() );
        bankAccountDto.bank( bankToBankDto( bankAccount.getBank() ) );

        return bankAccountDto.build();
    }

    @Override
    public BankAccountGridDto toGridDto(BankAccount bankAccount) {
        if ( bankAccount == null ) {
            return null;
        }

        BankAccountGridDto.BankAccountGridDtoBuilder bankAccountGridDto = BankAccountGridDto.builder();

        bankAccountGridDto.id( bankAccount.getId() );
        bankAccountGridDto.userName( bankAccount.getUserName() );
        if ( bankAccount.getBalance() != null ) {
            bankAccountGridDto.balance( bankAccount.getBalance().toString() );
        }

        return bankAccountGridDto.build();
    }

    protected BankDto bankToBankDto(Bank bank) {
        if ( bank == null ) {
            return null;
        }

        BankDto.BankDtoBuilder bankDto = BankDto.builder();

        bankDto.id( bank.getId() );
        bankDto.name( bank.getName() );

        return bankDto.build();
    }
}
