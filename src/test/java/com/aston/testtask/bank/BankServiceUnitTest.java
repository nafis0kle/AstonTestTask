package com.aston.testtask.bank;

import com.aston.testtask.bank.domain.entity.Bank;
import com.aston.testtask.bank.service.impl.BankServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;
import static org.springframework.test.util.AssertionErrors.assertEquals;

/**
 * @author nafis
 * @since 06.09.2023
 */

@ExtendWith(SpringExtension.class)
public class BankServiceUnitTest {

    @Mock
    private BankServiceImpl bankService;

    private Bank bank;

    @BeforeEach
    public void setup() {
        bank = new Bank();
        bank.setId(1L);
        bank.setName("BankTest");
    }

    @Test
    public void testGetBankById() {
        when(bankService.get(1L)).thenReturn(bank);
        assertEquals("Name is equal", bankService.get(1L).getName(), "BankTest");
    }

    @Test
    public void testDeleteAllowed() {
        bankService.delete(1L);
        verify(bankService, times(1)).delete(bank.getId());
        ArgumentCaptor<Long> bankArgumentCaptor = ArgumentCaptor.forClass(Long.class);
        verify(bankService).delete(bankArgumentCaptor.capture());
        Long bankIdDeleted = bankArgumentCaptor.getValue();
        assertNotNull(bankIdDeleted);
        assertEquals("equal", 1L, bankIdDeleted);
    }
}
