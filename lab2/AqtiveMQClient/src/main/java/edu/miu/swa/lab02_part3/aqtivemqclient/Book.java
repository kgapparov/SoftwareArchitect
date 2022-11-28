package edu.miu.swa.lab02_part3.aqtivemqclient;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private String isbn;
    private String author;
    private String title;
    private Double price;
}
