package com.aston.testtask.bank.service;

import com.aston.testtask.bank.domain.dto.ChangeBalanceDto;
import com.aston.testtask.bank.domain.dto.TransferFundsDto;
import com.aston.testtask.bank.domain.entity.BankAccount;

/**
 * @author nafis
 * @since 06.09.2023
 */
public interface BankOperationService {

    BankAccount deposit(ChangeBalanceDto changeBalanceDto);

    BankAccount withdraw(ChangeBalanceDto changeBalanceDto);

    BankAccount transfer(TransferFundsDto transferFundsDto);

}
