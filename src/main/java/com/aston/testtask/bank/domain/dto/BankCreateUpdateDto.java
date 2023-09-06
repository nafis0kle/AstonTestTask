package com.aston.testtask.bank.domain.dto;

import lombok.*;

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
public class BankCreateUpdateDto {

    @Size(min = 3, message = "{bank.name.size}")
    private String name;
}
