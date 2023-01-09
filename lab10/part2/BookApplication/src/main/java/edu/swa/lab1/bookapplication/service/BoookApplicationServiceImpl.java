package edu.swa.lab1.bookapplication.service;

import edu.swa.lab1.bookapplication.data.Book;
import edu.swa.lab1.bookapplication.data.BookRepository;
import edu.swa.lab1.bookapplication.domain.BookDomainService;
import edu.swa.lab1.bookapplication.domain.Customer;
import edu.swa.lab1.bookapplication.integration.EmailNotification;
import edu.swa.lab1.bookapplication.integration.SendNotification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoookApplicationServiceImpl implements BookApplicationServices{

    @Autowired
    BookRepository bookRepository;

    @Autowired
    BookDomainService bookDomainService;


    @Autowired
    SendNotification notifyer;

    SendNotification emailSender = new EmailNotification();

    @Override
    public void addBook(Book book) {
        bookRepository.addBook(book);
    }

    @Override
    public void deleteBook(String isbn) {
        bookRepository.deleteBook(isbn);
    }

    @Override
    public Book getBook(String isbn) {
        return bookRepository.getBook(isbn);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }

    @Override
    public void checkIn(String isbn, Customer customer) {
        bookDomainService.checkIn(isbn, customer);

        try {
            notifyer.sendNotification("The customer " + customer.getName() + " is checked in the book with ISBN " + isbn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void checkout(String isbn, Customer customer) {
        bookDomainService.checkout(isbn, customer);
        notifyer.sendNotification("The customer " + customer.getName() + " is checked out the book with ISBN " + isbn);
    }
}
