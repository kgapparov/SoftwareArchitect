package io.miu.swa.lab5.componentapplication.domain.product;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Review {
    private String title;
    private String description;
    private Double score;
}
