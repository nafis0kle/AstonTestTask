package com.aston.testtask.bank.domain.mapper;

import com.aston.testtask.bank.domain.dto.BankAccountCreateDto;
import com.aston.testtask.bank.domain.dto.BankAccountDto;
import com.aston.testtask.bank.domain.dto.BankAccountGridDto;
import com.aston.testtask.bank.domain.entity.BankAccount;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author nafis
 * @since 05.09.2023
 */
@Mapper(componentModel = "spring")
public interface BankAccountMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "number", ignore = true)
    @Mapping(target = "balance", ignore = true)
    BankAccount fromBankAccountCreateDto(BankAccountCreateDto bankAccountCreateDto);

    BankAccountDto toDto(BankAccount bankAccount);

    BankAccountGridDto toGridDto(BankAccount bankAccount);
}
