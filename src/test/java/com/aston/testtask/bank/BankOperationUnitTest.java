package com.aston.testtask.bank;

import com.aston.testtask.bank.domain.dto.ChangeBalanceDto;
import com.aston.testtask.bank.domain.entity.Bank;
import com.aston.testtask.bank.domain.entity.BankAccount;
import com.aston.testtask.bank.service.impl.BankOperationServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;

import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertEquals;

/**
 * @author nafis
 * @since 06.09.2023
 */
@ExtendWith(SpringExtension.class)
public class BankOperationUnitTest {

    @Mock
    private BankOperationServiceImpl bankOperationService;

    private BankAccount bankAccount;
    private Bank bank;

    @BeforeEach
    public void setup() {
        bank = new Bank();
        bank.setId(1L);
        bank.setName("BankTest");

        bankAccount = new BankAccount();
        bankAccount.setId(1L);
        bankAccount.setUserName("Name");
        bankAccount.setPinCode(1234);
        bankAccount.setNumber("1234123412341234");
        bankAccount.setBalance(new BigDecimal(100));
        bankAccount.setBank(bank);
    }

    @Test
    public void testDeposit() {
        ChangeBalanceDto changeBalanceDto = ChangeBalanceDto.builder()
                .accountNumber("1234123412341234")
                .pinCode(1234)
                .amount(new BigDecimal(100))
                .build();

        when(bankOperationService.deposit(changeBalanceDto)).thenReturn(bankAccount);

        assertEquals("Balance is equal", bankOperationService.deposit(changeBalanceDto).getBalance(), new BigDecimal(100));
    }
}
