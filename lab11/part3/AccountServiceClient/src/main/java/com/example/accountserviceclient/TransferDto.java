package com.example.accountserviceclient;


public class TransferDto {
    private String accountNumber;
    private String entryNumber;
    private Double amount;

    public TransferDto(String accountNumber, String entryNumber, Double amount) {
        this.accountNumber = accountNumber;
        this.entryNumber = entryNumber;
        this.amount = amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getEntryNumber() {
        return entryNumber;
    }

    public Double getAmount() {
        return amount;
    }
}

