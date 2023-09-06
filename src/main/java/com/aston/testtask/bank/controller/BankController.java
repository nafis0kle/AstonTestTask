package com.aston.testtask.bank.controller;

import com.aston.testtask.bank.domain.dto.BankCreateUpdateDto;
import com.aston.testtask.bank.domain.dto.BankDto;
import com.aston.testtask.bank.domain.mapper.BankMapper;
import com.aston.testtask.bank.service.BankService;
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
@RequestMapping("/banks")
public class BankController {

    private final BankMapper bankMapper;
    private final BankService bankService;

    @GetMapping("/{id}")
    public BankDto get(@PathVariable Long id) {
        return Optional.of(id)
                .map(bankService::get)
                .map(bankMapper::toDto)
                .orElseThrow();
    }

    @GetMapping
    public Page<BankDto> getAll(Pageable pageable) {
        return Optional.of(pageable)
                .map(bankService::getAll)
                .map(it -> it.map(bankMapper::toDto))
                .orElseThrow();
    }

    @PostMapping
    public BankDto create(@Valid @RequestBody BankCreateUpdateDto bankDto) {
        return Optional.ofNullable(bankDto)
                .map(bankMapper::fromCreateUpdateDto)
                .map(bankService::create)
                .map(bankMapper::toDto)
                .orElseThrow();
    }

    @PatchMapping("/{id}")
    public BankDto update(@PathVariable Long id,
                          @Valid @RequestBody BankCreateUpdateDto bankDto
    ) {
        return Optional.ofNullable(bankDto)
                .map(bankMapper::fromCreateUpdateDto)
                .map(it -> bankService.update(id, it))
                .map(bankMapper::toDto)
                .orElseThrow();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        bankService.delete(id);
    }
}
