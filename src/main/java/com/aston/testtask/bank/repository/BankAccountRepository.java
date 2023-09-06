package com.aston.testtask.bank.repository;

import com.aston.testtask.bank.domain.entity.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author nafis
 * @since 05.09.2023
 */
@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {

    Optional<BankAccount> findByNumber(String number);

    Boolean existsBankAccountByBankId(Long bankId);
}
