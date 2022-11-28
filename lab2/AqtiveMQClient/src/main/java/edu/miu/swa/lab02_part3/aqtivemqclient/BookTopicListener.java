package edu.miu.swa.lab02_part3.aqtivemqclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.io.IOError;


@Component
@Slf4j
public class BookTopicListener {

    @JmsListener(destination = "bookTopic")
    public void recieveMessage(final String bookAsString){
        ObjectMapper mapper = new ObjectMapper();
        try {
            Book book = mapper.convertValue(bookAsString, Book.class);
            log.info(book.toString());
        }catch (IOError error) {
            log.error("Error on mapping input data, error : {} ",error.getMessage());
        }
    }
}
