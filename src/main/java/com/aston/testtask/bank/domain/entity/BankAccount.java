package com.aston.testtask.bank.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author nafis
 * @since 05.09.2023
 */
@Entity
@Setter
@Getter
@Table(
        name = "bank_accounts",
        uniqueConstraints = @UniqueConstraint(columnNames = {"number"})
)
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userName;

    private Integer pinCode;

    private String number;

    private BigDecimal balance = new BigDecimal(0);

    @JoinColumn(name = "bank_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Bank bank;
}
