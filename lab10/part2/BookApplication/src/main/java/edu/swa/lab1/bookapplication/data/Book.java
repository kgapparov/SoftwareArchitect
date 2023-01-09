package edu.swa.lab1.bookapplication.data;


import java.util.Objects;

public class Book {
    private String isbn;
    private String ttitle;
    private Double price;


    public Book(String isbn, String ttitle, Double price) {
        this.isbn = isbn;
        this.ttitle = ttitle;
        this.price = price;
    }


    public String getIsbn() {
        Book book;
        Book book1;
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTtitle() {
        return ttitle;
    }

    public void setTtitle(String ttitle) {
        this.ttitle = ttitle;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(isbn, book.isbn) && Objects.equals(ttitle, book.ttitle) && Objects.equals(price, book.price);
    }


    @Override
    public int hashCode() {
        return Objects.hash(isbn, ttitle, price);
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", ttitle='" + ttitle + '\'' +
                ", price=" + price +
                '}';
    }
}
