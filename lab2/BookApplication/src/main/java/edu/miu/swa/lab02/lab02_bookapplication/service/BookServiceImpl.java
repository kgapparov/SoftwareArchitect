package edu.miu.swa.lab02.lab02_bookapplication.service;

import edu.miu.swa.lab02.lab02_bookapplication.entity.Book;
import edu.miu.swa.lab02.lab02_bookapplication.integration.JMSSender;
import edu.miu.swa.lab02.lab02_bookapplication.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;


@Service
public class BookServiceImpl implements BookService{

   @Autowired
   BookRepository repository;

   @Autowired
   JMSSender jmsSender;

   //** Startup bookList **/
    @PostConstruct
    void fillBooks(){
        repository.addBook(Book.builder().isbn("1123-DCD").title("Oliver Twist").build());
        repository.addBook(Book.builder().isbn("1123-DCD").title("Spieker").build());
        repository.addBook(Book.builder().isbn("1423-DCD").title("Olaf Viking").build());
    }

    @Override
    public Book addBook(Book book) {
        jmsSender.sendBook(book);
        return repository.addBook(book);
    }

    @Override
    public Book updateBook(Book book) {
        jmsSender.sendBook(book);
        return repository.updateBook(book);
    }

    @Override
    public Book deleteBook(String isbn) {
        Book book = repository.getBook(isbn);
        jmsSender.sendBook(book);
        return repository.deleteBook(isbn);
    }

    @Override
    public Book getBook(String isbn) {
        return repository.getBook(isbn);
    }

    @Override
    public List<Book> getAllBooks() {
        return repository.getAllBooks();
    }
}
