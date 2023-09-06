package com.aston.testtask.bank.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;
import static lombok.AccessLevel.PRIVATE;

/**
 * @author nafis
 * @since 05.09.2023
 */
@Entity
@Getter
@Setter
@Table(
        name = "banks",
        uniqueConstraints = @UniqueConstraint(columnNames = {"name"})
)
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Setter(PRIVATE)
    @OneToMany(mappedBy = "bank",
            orphanRemoval = true,
            cascade = {PERSIST, MERGE, DETACH, REFRESH})
    private List<BankAccount> bankAccounts = new ArrayList<>();
}
