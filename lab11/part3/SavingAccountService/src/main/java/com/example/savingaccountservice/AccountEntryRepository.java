package com.example.savingaccountservice;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class AccountEntryRepository {
    private Map<String, AccountEntry> cache = new HashMap<>();

    public AccountEntry getByID(String id) {
        return cache.get(id);
    }

    public void add(AccountEntry accountEntry) {
        cache.put(accountEntry.getEntryNumber(), accountEntry);
    }
}
