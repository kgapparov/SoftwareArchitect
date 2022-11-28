package edu.miu.swa.lab02.lab02_bookapplication.controllers;

import edu.miu.swa.lab02.lab02_bookapplication.entity.Book;

import java.util.Collection;
import java.util.List;

public class Books {
    private Collection<Book> books;

    public Books(List<Book> raw_books) {
        this.books = raw_books;
    }

    public Collection<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
