package com.aston.testtask.bank.domain.mapper;

import com.aston.testtask.bank.domain.dto.BankCreateUpdateDto;
import com.aston.testtask.bank.domain.dto.BankDto;
import com.aston.testtask.bank.domain.entity.Bank;
import org.mapstruct.*;

import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

/**
 * @author nafis
 * @since 05.09.2023
 */
@Mapper(componentModel = "spring")
public interface BankMapper {

    @Mapping(target = "id", ignore = true)
    Bank fromCreateUpdateDto(BankCreateUpdateDto bankCreateUpdateDto);

    BankDto toDto(Bank bank);

    @BeanMapping(nullValuePropertyMappingStrategy = IGNORE)
    Bank merge(@MappingTarget Bank target, Bank source);
}
