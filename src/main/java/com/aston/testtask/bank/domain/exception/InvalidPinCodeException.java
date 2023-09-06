package com.aston.testtask.bank.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author nafis
 * @since 06.09.2023
 */
@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
public class InvalidPinCodeException extends RuntimeException {

    public InvalidPinCodeException() {
        super("Invalid PIN code");
    }
}
