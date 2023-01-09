package edu.swa.lab1.bookapplication.data;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class BookDataMemoryPersistant implements BookRepository{

    Map<String, Book> cache = new HashMap<>();

    @Override
    public void addBook(Book book) {
        cache.put(book.getIsbn(), book);
    }

    @Override
    public void deleteBook(String isbn) {
        cache.remove(isbn);
    }

    @Override
    public Book getBook(String isbn) {
        return cache.get(isbn);
    }

    @Override
    public List<Book> getAllBooks() {
        return new ArrayList<>(cache.values());
    }
}
