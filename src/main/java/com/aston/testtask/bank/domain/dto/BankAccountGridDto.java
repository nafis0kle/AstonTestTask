package com.aston.testtask.bank.domain.dto;

import lombok.*;

/**
 * @author nafis
 * @since 06.09.2023
 */
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BankAccountGridDto {

    private Long id;
    private String userName;
    private String balance;
}
