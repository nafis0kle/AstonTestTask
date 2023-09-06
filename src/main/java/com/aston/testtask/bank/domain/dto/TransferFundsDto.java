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
public class TransferFundsDto {
    private Integer pinCode;
    private BigDecimal amount;
    private String accountNumberFrom;
    private String accountNumberTo;
}
