package com.aston.testtask.bank.repository;

import com.aston.testtask.bank.domain.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author nafis
 * @since 05.09.2023
 */
@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {
}
