package edu.miu.swa.lab02_02.bookapplicationclient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Books {
    private Collection<Book> books;
}
