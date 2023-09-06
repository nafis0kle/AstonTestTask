package com.aston.testtask.bank.service.impl;

import com.aston.testtask.bank.domain.entity.Bank;
import com.aston.testtask.bank.domain.exception.BankDeleteNotAllowedException;
import com.aston.testtask.bank.domain.exception.BankNotFoundException;
import com.aston.testtask.bank.domain.mapper.BankMapper;
import com.aston.testtask.bank.repository.BankAccountRepository;
import com.aston.testtask.bank.repository.BankRepository;
import com.aston.testtask.bank.service.BankService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


/**
 * @author nafis
 * @since 05.09.2023
 */
@Service
@RequiredArgsConstructor
public class BankServiceImpl implements BankService {

    private final BankMapper bankMapper;
    private final BankRepository bankRepository;
    private final BankAccountRepository bankAccountRepository;

    @Override
    public Bank get(Long id) {
        return bankRepository
                .findById(id)
                .orElseThrow(() -> new BankNotFoundException(id));
    }

    @Override
    public Page<Bank> getAll(Pageable pageable) {
        return bankRepository.findAll(pageable);
    }

    @Override
    public Bank create(Bank bank) {
        return bankRepository.save(bank);
    }

    @Override
    public Bank update(Long id, Bank bank) {
        return Optional.of(id)
                .map(bankRepository::findById)
                .get()
                .map(current -> bankMapper.merge(current, bank))
                .map(bankRepository::save)
                .orElseThrow(() -> new BankNotFoundException(id));
    }

    @Override
    public void delete(Long id) {
        Bank bank = bankRepository.findById(id).orElseThrow(() -> new BankNotFoundException(id));

        if (bankAccountRepository.existsBankAccountByBankId(id)) {
            throw new BankDeleteNotAllowedException(id);
        }

        bankRepository.delete(bank);
    }
}
