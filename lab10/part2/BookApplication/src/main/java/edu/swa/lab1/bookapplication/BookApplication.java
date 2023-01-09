package edu.swa.lab1.bookapplication;

import edu.swa.lab1.bookapplication.data.Book;
import edu.swa.lab1.bookapplication.domain.Customer;
import edu.swa.lab1.bookapplication.service.BookApplicationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookApplication  implements CommandLineRunner {
    @Autowired
    private BookApplicationServices services;

    public static void main(String[] args) {
        SpringApplication.run(BookApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        Customer customer = new Customer();
        customer.setLName("Alan");
        customer.setLName("Ibraimov");

        services.addBook(new Book("isbn-001-5526", "Heroes", 23.10));
        services.addBook(new Book("isbn-001-5126", "The Skys", 53.10));
        services.addBook(new Book("isbn-001-5326", "Pdas asdf", 63.10));

        System.out.println(services.getAllBooks());
    }
}
