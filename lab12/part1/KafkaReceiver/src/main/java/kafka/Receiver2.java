package kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class Receiver2 {

    @KafkaListener(topics={"topicA"}, groupId = "grp2")
    public void recive2(@Payload String message) {
        System.out.println("Receiver2 recieved message = " + message);
    }
}
