package com.aston.testtask.bank.service;

import com.aston.testtask.bank.domain.entity.Bank;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author nafis
 * @since 05.09.2023
 */
public interface BankService {

    Bank get(Long id);

    Page<Bank> getAll(Pageable pageable);

    Bank create(Bank bank);

    Bank update(Long id, Bank bank);

    void delete(Long id);
}
