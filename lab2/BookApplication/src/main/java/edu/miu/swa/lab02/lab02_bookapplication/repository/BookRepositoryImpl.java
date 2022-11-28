package edu.miu.swa.lab02.lab02_bookapplication.repository;

import edu.miu.swa.lab02.lab02_bookapplication.entity.Book;
import edu.miu.swa.lab02.lab02_bookapplication.persistent.MemoryListPersistent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepositoryImpl implements  BookRepository{
    @Autowired
    MemoryListPersistent<Book, String> memoryListPersistent;

    @Override
    public Book addBook(Book book) {
        return memoryListPersistent.addItem(book, book.getIsbn());
    }

    @Override
    public Book updateBook(Book book) {
        return memoryListPersistent.updateItem(book, book.getIsbn());
    }

    @Override
    public Book deleteBook(String isbn) {
        return memoryListPersistent.deleteItem(isbn);
    }

    @Override
    public Book getBook(String isbn) {
        return memoryListPersistent.getItem(isbn);
    }

    @Override
    public List<Book> getAllBooks() {
        return memoryListPersistent.getAllItem();
    }
}
