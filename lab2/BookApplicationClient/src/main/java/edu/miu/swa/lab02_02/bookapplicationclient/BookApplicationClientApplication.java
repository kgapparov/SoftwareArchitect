package edu.miu.swa.lab02_02.bookapplicationclient;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.client.RestOperations;


@SpringBootApplication
@Slf4j
public class BookApplicationClientApplication implements CommandLineRunner {

    @Autowired
    RestOperations operations;

    public static void main(String[] args) {
        SpringApplication.run(BookApplicationClientApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        String serveString = "http://localhost:8080/api/v1/books";

        operations.postForLocation(serveString, Book.builder().isbn("112542-DCK").title("Dawn after night").build());
        operations.postForLocation(serveString, Book.builder().isbn("112325-DFE").title("Testing Art").build());
        operations.put(serveString+"/{isbn}", Book.builder().isbn("112542-DCK").title("Dawn after night II").build(), "112542-DCK");

        Book book = operations.getForObject(serveString + "/{isbn}", Book.class, "112542-DCK");

        assert book != null;
        log.info(book.toString());

        Books books = operations.getForObject(serveString, Books.class);

        assert books != null;
        log.info(books.getBooks().toString());
    }
}
