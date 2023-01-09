package com.example.accountserviceclient;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;

@Component
public class AccountEntryRepository {
    @Autowired
    RestOperations template;

    public boolean savingDeposit(String accountNumber, String entryNumber, Double amount) {
        ResponseEntity<String> result = template.getForEntity("http://localhost:8091/deposit?accountNumber="+
                accountNumber+"&entryNumber="+entryNumber+"&amount=" + amount, String.class);
        return result.getStatusCode() == HttpStatus.OK;
    }

    public boolean checkingDeposit(String accountNumber, String entryNumber, Double amount) {
        ResponseEntity<String> result = template.getForEntity("http://localhost:8092/deposit?accountNumber="+
                accountNumber+"&entryNumber="+entryNumber+"&amount=" + amount, String.class);
        return result.getStatusCode() == HttpStatus.OK;
    }
}
