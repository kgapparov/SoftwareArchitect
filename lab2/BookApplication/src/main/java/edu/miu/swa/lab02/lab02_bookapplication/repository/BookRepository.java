package edu.miu.swa.lab02.lab02_bookapplication.repository;

import edu.miu.swa.lab02.lab02_bookapplication.entity.Book;

import java.util.List;

public interface BookRepository {
    Book addBook(Book book);
    Book updateBook(Book book);
    Book deleteBook(String isbn);
    Book getBook(String isbn);
    List<Book> getAllBooks();
}
