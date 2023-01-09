package com.example.savingaccountservice;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Builder
@Slf4j
public class AccountEntry {
    private String entryNumber;
    private String accountNumber;
    private Double balance;

    public void deposit(Double amount) throws ArithmeticException {
        if (balance + amount < 0) {
            throw new ArithmeticException("Insufficient balance");
        }
        this.balance += amount;
        log.info("Transaction with amount {} was performed on account = {}", amount, this.accountNumber);
    }
}
