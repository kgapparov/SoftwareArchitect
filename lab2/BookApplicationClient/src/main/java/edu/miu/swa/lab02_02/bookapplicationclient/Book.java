package edu.miu.swa.lab02_02.bookapplicationclient;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Book {
    private String isbn;
    private String author;
    private String title;
    private Double price;
}
