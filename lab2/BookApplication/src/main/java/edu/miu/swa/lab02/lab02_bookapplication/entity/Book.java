package edu.miu.swa.lab02.lab02_bookapplication.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@ToString
public class Book {
    private String isbn;
    private String author;
    private String title;
    private Double price;
}
