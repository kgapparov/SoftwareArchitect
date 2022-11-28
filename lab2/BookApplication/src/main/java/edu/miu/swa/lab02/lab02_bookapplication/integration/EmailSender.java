package edu.miu.swa.lab02.lab02_bookapplication.integration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EmailSender{
    public void sendEmail(String message, String mailAddress){
        log.info("Send message {} to address {}", message, mailAddress);
    }
}
