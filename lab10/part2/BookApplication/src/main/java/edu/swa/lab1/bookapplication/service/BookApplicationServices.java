package edu.swa.lab1.bookapplication.service;

import edu.swa.lab1.bookapplication.data.Book;
import edu.swa.lab1.bookapplication.domain.Customer;

import java.util.List;

public interface BookApplicationServices {
    void addBook(Book book);
    void deleteBook(String isbn);
    Book getBook(String isbn);
    List<Book> getAllBooks();
    void checkIn(String isbn, Customer customer);
    void checkout(String isbn, Customer customer);
}
