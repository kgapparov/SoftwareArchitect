package edu.miu.swa.lab02.lab02_bookapplication.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.miu.swa.lab02.lab02_bookapplication.entity.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class JMSSender {
    @Autowired
    JmsTemplate jmsTemplate;

    public void sendBook(Book book){
        ObjectMapper mapper = new ObjectMapper();

        try {
            String bookAsString = mapper.writeValueAsString(book);
            log.info("Seding out to JMS data : {} ", bookAsString);
            jmsTemplate.convertAndSend("bookTopic", bookAsString);
        } catch (JsonProcessingException e) {
            log.error("Error during converting to JSON : {}", e.getMessage());
        }
    }
}
