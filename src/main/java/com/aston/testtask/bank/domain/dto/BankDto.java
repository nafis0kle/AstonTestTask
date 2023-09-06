package com.aston.testtask.bank.domain.dto;

import lombok.*;

/**
 * @author nafis
 * @since 05.09.2023
 */
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BankDto {

    private Long id;

    private String name;
}
