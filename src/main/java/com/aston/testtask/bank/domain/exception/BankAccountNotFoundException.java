package com.aston.testtask.bank.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author nafis
 * @since 06.09.2023
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class BankAccountNotFoundException extends RuntimeException {

    public BankAccountNotFoundException(Long id) {
        super("Bank account with id=" + id + " not found");
    }
}
