package com.aston.testtask.bank.service;

import com.aston.testtask.bank.domain.entity.BankAccount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


/**
 * @author nafis
 * @since 05.09.2023
 */
public interface BankAccountService {

    BankAccount get(Long id);

    BankAccount getByNumber(String accountNumber);

    Page<BankAccount> getAll(Pageable pageable);

    BankAccount create(BankAccount bankAccount, Long bankId);

    void delete(Long id);
}
