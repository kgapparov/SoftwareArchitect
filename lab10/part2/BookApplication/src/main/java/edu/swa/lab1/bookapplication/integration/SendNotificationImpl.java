package edu.swa.lab1.bookapplication.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SendNotificationImpl implements SendNotification{
    @Autowired
    KafkaTemplate<String ,String> kafkaTemplate;

    @Override
    public void sendNotification(String massage) {
        kafkaTemplate.send("myFirstTopic", massage);
    }
}
