package com.aston.testtask.bank.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author nafis
 * @since 06.09.2023
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class BankNotFoundException extends RuntimeException {

    public BankNotFoundException(Long id) {
        super("Bank with id=" + id + " not found");
    }
}
