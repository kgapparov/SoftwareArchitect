package com.example.kafkaconsumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
    @KafkaListener(topics = "myFirstTopic")
    public void consumerGetMessages(String message) {
        System.out.println(message);
    }
}
