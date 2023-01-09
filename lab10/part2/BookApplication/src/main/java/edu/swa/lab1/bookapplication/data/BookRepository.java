package edu.swa.lab1.bookapplication.data;

import java.util.List;

public interface BookRepository {
    void addBook(Book book);
    void deleteBook(String isbn);
    Book getBook(String isbn);
    List<Book> getAllBooks();
}
