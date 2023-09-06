package com.aston.testtask.bank.domain.dto;

import lombok.*;

import java.math.BigDecimal;

/**
 * @author nafis
 * @since 06.09.2023
 */
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChangeBalanceDto {

    private Integer pinCode;
    private BigDecimal amount;
    private String accountNumber;
}
