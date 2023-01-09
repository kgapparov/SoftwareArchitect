package edu.swa.lab1.bookapplication.integration;

import org.springframework.beans.factory.annotation.Autowired;

public class EmailNotification implements SendNotification{

    @Override
    public void sendNotification(String massage) {
        System.out.println("Email sended to with subject " + massage);
    }
}
