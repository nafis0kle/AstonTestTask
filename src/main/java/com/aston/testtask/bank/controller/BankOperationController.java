package com.aston.testtask.bank.controller;

import com.aston.testtask.bank.domain.dto.BankAccountDto;
import com.aston.testtask.bank.domain.dto.ChangeBalanceDto;
import com.aston.testtask.bank.domain.dto.TransferFundsDto;
import com.aston.testtask.bank.domain.mapper.BankAccountMapper;
import com.aston.testtask.bank.service.BankOperationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author nafis
 * @since 06.09.2023
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("bank-operations")
public class BankOperationController {

    private final BankAccountMapper bankAccountMapper;
    private final BankOperationService bankOperationService;

    @PatchMapping("/deposit")
    public BankAccountDto deposit(@RequestBody ChangeBalanceDto changeBalanceDto) {
        return Optional.of(changeBalanceDto)
                .map(bankOperationService::deposit)
                .map(bankAccountMapper::toDto)
                .orElseThrow();
    }

    @PatchMapping("/withdraw")
    public BankAccountDto withdraw(@RequestBody ChangeBalanceDto changeBalanceDto) {
        return Optional.of(changeBalanceDto)
                .map(bankOperationService::withdraw)
                .map(bankAccountMapper::toDto)
                .orElseThrow();
    }

    @PatchMapping("/transfer")
    public BankAccountDto transfer(@RequestBody TransferFundsDto transferFundsDto) {
        return Optional.of(transferFundsDto)
                .map(bankOperationService::transfer)
                .map(bankAccountMapper::toDto)
                .orElseThrow();
    }
}
