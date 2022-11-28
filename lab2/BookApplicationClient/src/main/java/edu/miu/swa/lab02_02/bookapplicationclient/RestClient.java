package edu.miu.swa.lab02_02.bookapplicationclient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestClient {
    @Bean
    RestOperations getRestTemplate(){
        return new RestTemplate();
    }
}
