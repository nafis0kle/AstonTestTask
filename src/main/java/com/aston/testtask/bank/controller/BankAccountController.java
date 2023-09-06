package com.aston.testtask.bank.controller;

import com.aston.testtask.bank.domain.dto.BankAccountCreateDto;
import com.aston.testtask.bank.domain.dto.BankAccountDto;
import com.aston.testtask.bank.domain.dto.BankAccountGridDto;
import com.aston.testtask.bank.domain.mapper.BankAccountMapper;
import com.aston.testtask.bank.service.BankAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

/**
 * @author nafis
 * @since 05.09.2023
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/bank-accounts")
public class BankAccountController {

    private final BankAccountMapper bankAccountMapper;
    private final BankAccountService bankAccountService;

    @GetMapping("/{id}")
    public BankAccountDto get(@PathVariable Long id) {
        return Optional.of(id)
                .map(bankAccountService::get)
                .map(bankAccountMapper::toDto)
                .orElseThrow();
    }

    @GetMapping
    public Page<BankAccountDto> getAll(Pageable pageable) {
        return Optional.of(pageable)
                .map(bankAccountService::getAll)
                .map(it -> it.map(bankAccountMapper::toDto))
                .orElseThrow();
    }

    @GetMapping("/grid")
    public Page<BankAccountGridDto> grid(Pageable pageable) {
        return Optional.of(pageable)
                .map(bankAccountService::getAll)
                .map(it -> it.map(bankAccountMapper::toGridDto))
                .orElseThrow();
    }

    @PostMapping
    public BankAccountDto create(
            @Valid @RequestBody BankAccountCreateDto bankAccountDto,
            @RequestParam Long bankId
    ) {
        return Optional.ofNullable(bankAccountDto)
                .map(bankAccountMapper::fromBankAccountCreateDto)
                .map(toCreate -> bankAccountService.create(toCreate, bankId))
                .map(bankAccountMapper::toDto)
                .orElseThrow();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        bankAccountService.delete(id);
    }
}
