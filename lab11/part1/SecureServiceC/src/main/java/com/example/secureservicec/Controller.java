package com.example.secureservicec;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/phone")
    public String getPhone(){
        return "641-1223-3323";
    }
}
