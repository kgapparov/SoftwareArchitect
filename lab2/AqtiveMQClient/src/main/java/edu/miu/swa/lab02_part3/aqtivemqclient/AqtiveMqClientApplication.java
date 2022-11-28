package edu.miu.swa.lab02_part3.aqtivemqclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class AqtiveMqClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(AqtiveMqClientApplication.class, args);
    }

}
