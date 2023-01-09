package edu.swa.lab1.bookapplication.controller;

import edu.swa.lab1.bookapplication.data.Book;
import edu.swa.lab1.bookapplication.domain.Customer;
import edu.swa.lab1.bookapplication.service.BookApplicationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookApplicationController {
    @Autowired
    BookApplicationServices services;

    @GetMapping("/books")
    public List<Book> getAllbooks() {
        return services.getAllBooks();
    }

    @GetMapping("/books/{isbn}")
    public Book getBook(@PathVariable String isbn) {
        return services.getBook(isbn);
    }

    @PostMapping("/books")
    public void addBook(@RequestBody Book book) {
        services.addBook(book);
    }
    @PostMapping("/books/checkin/{isbn}")
    public void checkIn(@PathVariable String isbn, @RequestBody Customer customer) {
        System.out.println(customer);
        services.checkIn(isbn, customer);
    }

    @PostMapping("/books/checkout/{isbn}")
    public void checkOut(@PathVariable String isbn, @RequestBody Customer customer) {

        services.checkout(isbn, customer);
    }
    @DeleteMapping("/books/{isbn}")
    public void deleteBook(@PathVariable String isbn) {
        services.deleteBook(isbn);
    }
}
