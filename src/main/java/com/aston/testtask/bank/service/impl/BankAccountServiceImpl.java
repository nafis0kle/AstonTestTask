package com.aston.testtask.bank.service.impl;

import com.aston.testtask.bank.domain.entity.BankAccount;
import com.aston.testtask.bank.domain.exception.BankAccountDeleteNotAllowedException;
import com.aston.testtask.bank.domain.exception.BankAccountNotFoundException;
import com.aston.testtask.bank.domain.exception.BankAccountNumberNotFoundException;
import com.aston.testtask.bank.repository.BankAccountRepository;
import com.aston.testtask.bank.repository.BankRepository;
import com.aston.testtask.bank.service.BankAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;


/**
 * @author nafis
 * @since 05.09.2023
 */
@Service
@RequiredArgsConstructor
public class BankAccountServiceImpl implements BankAccountService {

    private final BankRepository bankRepository;
    private final BankAccountRepository bankAccountRepository;

    @Override
    public BankAccount get(Long id) {
        return bankAccountRepository
                .findById(id)
                .orElseThrow(() -> new BankAccountNotFoundException(id));
    }

    public BankAccount getByNumber(String accountNumber) {
        return bankAccountRepository
                .findByNumber(accountNumber)
                .orElseThrow(() -> new BankAccountNumberNotFoundException(accountNumber));
    }

    @Override
    public Page<BankAccount> getAll(Pageable pageable) {
        return bankAccountRepository.findAll(pageable);
    }


    @Override
    public BankAccount create(BankAccount bankAccount, Long bankId) {
        bankAccount.setNumber(getUniqueAccountNumber());
        bankAccount.setBank(bankRepository.findById(bankId).orElseThrow());

        return bankAccountRepository.save(bankAccount);
    }

    @Override
    public void delete(Long id) {
        BankAccount bankAccount = bankAccountRepository
                .findById(id)
                .orElseThrow(() -> new BankAccountNotFoundException(id));

        if (!bankAccount.getBalance().equals(BigDecimal.ZERO)) {
            throw new BankAccountDeleteNotAllowedException(bankAccount.getNumber());
        }

        bankAccountRepository.delete(bankAccount);
    }

    private String getUniqueAccountNumber() {
        return String.valueOf(
                UUID.randomUUID().
                        getMostSignificantBits() & Integer.MAX_VALUE
        );
    }
}
