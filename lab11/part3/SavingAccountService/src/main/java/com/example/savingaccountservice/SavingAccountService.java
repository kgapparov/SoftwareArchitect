package com.example.savingaccountservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SavingAccountService {
    @Autowired
    AccountEntryRepository repository;

    public void deposit(String entryNumber, String accountNumber, Double amount) throws ArithmeticException {
        AccountEntry accountEntry = repository.getByID(entryNumber);
        if (accountEntry  == null)
            accountEntry = AccountEntry.builder().entryNumber(entryNumber).balance(0.0).accountNumber(accountNumber).build();
        accountEntry.deposit(amount);
    }

}
