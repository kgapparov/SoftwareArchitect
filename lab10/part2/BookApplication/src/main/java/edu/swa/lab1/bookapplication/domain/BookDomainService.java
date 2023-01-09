package edu.swa.lab1.bookapplication.domain;

public interface BookDomainService {
    void checkIn(String isbn, Customer customer);
    void checkout(String isbn, Customer customer);
}
