package com.aston.testtask.bank.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author nafis
 * @since 06.09.2023
 */
@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
public class NotEnoughFundsException extends RuntimeException {

    public NotEnoughFundsException() {
        super("There are not enough funds in your account!");
    }
}
