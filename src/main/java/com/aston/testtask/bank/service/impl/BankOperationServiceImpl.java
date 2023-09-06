package com.aston.testtask.bank.service.impl;

import com.aston.testtask.bank.domain.dto.ChangeBalanceDto;
import com.aston.testtask.bank.domain.dto.TransferFundsDto;
import com.aston.testtask.bank.domain.entity.BankAccount;
import com.aston.testtask.bank.domain.exception.InvalidPinCodeException;
import com.aston.testtask.bank.domain.exception.NotEnoughFundsException;
import com.aston.testtask.bank.repository.BankAccountRepository;
import com.aston.testtask.bank.service.BankAccountService;
import com.aston.testtask.bank.service.BankOperationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author nafis
 * @since 06.09.2023
 */
@Service
@RequiredArgsConstructor
public class BankOperationServiceImpl implements BankOperationService {

    private final BankAccountService bankAccountService;
    private final BankAccountRepository bankAccountRepository;

    public BankAccount deposit(ChangeBalanceDto changeBalanceDto) {
        BankAccount bankAccount = bankAccountService.getByNumber(changeBalanceDto.getAccountNumber());

        checkPinCode(bankAccount, changeBalanceDto.getPinCode());

        bankAccount.setBalance(bankAccount.getBalance().add(changeBalanceDto.getAmount()));

        return bankAccountRepository.save(bankAccount);
    }

    public BankAccount withdraw(ChangeBalanceDto changeBalanceDto) {
        BankAccount bankAccount = bankAccountService.getByNumber(changeBalanceDto.getAccountNumber());

        checkPinCode(bankAccount, changeBalanceDto.getPinCode());

        BigDecimal currentBalance = bankAccount.getBalance();
        if (currentBalance.compareTo(changeBalanceDto.getAmount()) < 0) {
            throw new NotEnoughFundsException();
        }
        bankAccount.setBalance(bankAccount.getBalance().subtract(changeBalanceDto.getAmount()));

        return bankAccountRepository.save(bankAccount);
    }

    public BankAccount transfer(TransferFundsDto transferFundsDto) {
        BankAccount bankAccountFrom = bankAccountService.getByNumber(transferFundsDto.getAccountNumberFrom());
        BankAccount bankAccountTo = bankAccountService.getByNumber(transferFundsDto.getAccountNumberTo());

        checkPinCode(bankAccountFrom, transferFundsDto.getPinCode());

        BigDecimal currentBalance = bankAccountFrom.getBalance();
        if (currentBalance.compareTo(transferFundsDto.getAmount()) < 0) {
            throw new NotEnoughFundsException();
        }
        bankAccountFrom.setBalance(bankAccountFrom.getBalance().subtract(transferFundsDto.getAmount()));
        bankAccountTo.setBalance(bankAccountTo.getBalance().add(transferFundsDto.getAmount()));

        bankAccountFrom = bankAccountRepository.save(bankAccountFrom);
        bankAccountRepository.save(bankAccountTo);

        return bankAccountFrom;
    }

    private void checkPinCode(BankAccount bankAccount, Integer pinCode) {
        Integer validPinCode = bankAccount.getPinCode();
        if (!validPinCode.equals(pinCode)) {
            throw new InvalidPinCodeException();
        }
    }
}
