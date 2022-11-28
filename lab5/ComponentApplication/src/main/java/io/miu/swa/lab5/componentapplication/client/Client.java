package io.miu.swa.lab5.componentapplication.client;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@Component
public class Client {
    @Bean
    RestOperations restTemplate(){
        return new RestTemplate();
    }
}
