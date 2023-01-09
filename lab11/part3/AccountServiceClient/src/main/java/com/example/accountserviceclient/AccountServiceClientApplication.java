package com.example.accountserviceclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class AccountServiceClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceClientApplication.class, args);
    }

    @Bean
    RestOperations getBean(){
        return new RestTemplate();
    }
}
