package com.example.accountserviceclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    AccountEntryRepository repository;

    @PostMapping("/transfer")
    public ResponseEntity<?> transfer(@RequestBody TransferDto transferDto){
        boolean tx1 = false, tx2 = false;
        tx1 = repository.savingDeposit(transferDto.getAccountNumber(), transferDto.getEntryNumber(), transferDto.getAmount());
        tx2 = repository.checkingDeposit(transferDto.getAccountNumber(), transferDto.getEntryNumber(), -1 * transferDto.getAmount());
        if (tx1 && tx2) {
            return ResponseEntity.ok().build();
        } else
            return ResponseEntity.badRequest().body("Insufficiant amount money");
    }
}
