package edu.swa.lab1.bookapplication.domain;

import edu.swa.lab1.bookapplication.data.Book;
import edu.swa.lab1.bookapplication.data.BookRepository;
import edu.swa.lab1.bookapplication.service.BookApplicationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class BookDomainServiceImpl implements BookDomainService{

    @Autowired
    private BookApplicationServices bookApplicationServices;

    @Override
    public void checkIn(String isbn, Customer customer) {
        Book book = bookApplicationServices.getBook(isbn);

        if (book != null) {
            System.out.println(customer.getName() + " is checked in the book " + book);
        } else
            System.out.println("The book is looking for with isbn " + isbn + " not exists at library");
    }

    @Override
    public void checkout(String isbn, Customer customer) {
        Book book = bookApplicationServices.getBook(isbn);

        if (book != null) {
            System.out.println(customer.getName() + " is checked out the book " + book);
        } else
            System.out.println("The book is looking for with isbn " + isbn + " not exists at library");
    }
}
