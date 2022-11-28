package edu.miu.swa.lab02.lab02_bookapplication.controllers;

import edu.miu.swa.lab02.lab02_bookapplication.entity.Book;
import edu.miu.swa.lab02.lab02_bookapplication.exceptions.CustomErrorType;
import edu.miu.swa.lab02.lab02_bookapplication.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BookController {

    @Autowired
    BookService service;

    @GetMapping()
    ResponseEntity hello() {
        return ResponseEntity.ok("Hello world");
    }

    @GetMapping("/books")
    ResponseEntity<?> getAllBooks(){
        List<Book> raw_books = service.getAllBooks();
        Books books = new Books(raw_books);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/books/{isbn}")
    ResponseEntity<?> getBookByISBN(@PathVariable String isbn){
        Book book = service.getBook(isbn);
        if (book == null) {
            return new ResponseEntity<>(new CustomErrorType(String.format("The book with isbn {} not exists", isbn)), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(book, HttpStatus.OK);
    }
    @PutMapping("/books/{isbn}")
    ResponseEntity<?> updateBookByISBN(@PathVariable String isbn) {
        Book book = service.getBook(isbn);
        if (book == null) {
            return new ResponseEntity<>(new CustomErrorType(String.format("The book with isbn {} not exists", isbn)), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(service.updateBook(book), HttpStatus.ACCEPTED);
    }

    @PostMapping("/books")
    ResponseEntity<?> addBook(@RequestBody Book book) {
        service.addBook(book);
        return new ResponseEntity<>(book, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/books/{isbn}")
    Book deleteBookByISBN(@PathVariable String isbn) {
        return service.deleteBook(isbn);
    }
}
