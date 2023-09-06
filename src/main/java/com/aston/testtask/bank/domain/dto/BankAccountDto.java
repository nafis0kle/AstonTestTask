package com.aston.testtask.bank.domain.dto;

import lombok.*;

import java.math.BigDecimal;

/**
 * @author nafis
 * @since 05.09.2023
 */
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BankAccountDto {

    private Long id;

    private String userName;

    private Integer pinCode;

    private String number;

    private BigDecimal balance;

    private BankDto bank;
}
