package com.example.savingaccountservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    SavingAccountService service;

    @GetMapping("/deposit")
    public ResponseEntity<?> deposit(@RequestParam String accountNumber,
                                     @RequestParam Double amount,
                                     @RequestParam String entryNumber){
        try {
            service.deposit( entryNumber, accountNumber, amount);
            return ResponseEntity.ok().build();
        } catch (ArithmeticException e) {
            return ResponseEntity.badRequest().body("Insufficient amount");
        }
    }
}
