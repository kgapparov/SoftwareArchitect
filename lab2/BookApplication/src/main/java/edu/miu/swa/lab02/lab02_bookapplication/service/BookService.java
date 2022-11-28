package edu.miu.swa.lab02.lab02_bookapplication.service;

import edu.miu.swa.lab02.lab02_bookapplication.entity.Book;

import java.util.List;

public interface BookService {
    Book addBook(Book book);
    Book updateBook(Book book);
    Book deleteBook(String isbn);
    Book getBook(String isbn);
    List<Book> getAllBooks();
}
