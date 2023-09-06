package com.aston.testtask.bank.domain.dto;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

/**
 * @author nafis
 * @since 05.09.2023
 */
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BankAccountCreateDto {

    @Size(min = 2, max = 50, message = "{bank-account.name.size}}")
    private String userName;

    @Min(value = 1000, message = "{bank-account.pin-code.digits-count}")
    @Max(value = 9999, message = "{bank-account.pin-code.digits-count}")
    private Integer pinCode;
}
