package kafka;

import java.util.HashMap;
import java.util.Map;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class SpeedCalculator {

    @KafkaListener(topics = {"toFastTopic"})
    public void overspeed(@Payload SpeedRecord speedRecord){
        Faker faker = new Faker();
        String name = faker.name().fullName();
        if (speedRecord.getSpeed() > 71 && speedRecord.getSpeed() < 78) {
            System.out.printf("%s is overspeeded with car number %s and speed is %d, the fine amount is $%d \n", name, speedRecord.getLicencePlate(),  speedRecord.getSpeed(), 25);
        } else if (speedRecord.getSpeed() >= 78 && speedRecord.getSpeed() <= 82) {
            System.out.printf("%s is overspeeded with car number %s and speed is %d, the fine amount is $%d \n", name, speedRecord.getLicencePlate(),  speedRecord.getSpeed(), 45);
        } else if (speedRecord.getSpeed() > 82 && speedRecord.getSpeed() < 90) {
            System.out.printf("%s is overspeeded with car number %s and speed is %d, the fine amount is $%d \n", name, speedRecord.getLicencePlate(),  speedRecord.getSpeed(), 80);
        } else {
            System.out.printf("%s is overspeeded with car number %s and speed is %d, the fine amount is $%d \n", name, speedRecord.getLicencePlate(),  speedRecord.getSpeed(), 125);
        }
    }
}