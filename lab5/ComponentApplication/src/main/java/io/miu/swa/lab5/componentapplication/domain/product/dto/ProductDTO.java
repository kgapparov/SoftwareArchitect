package io.miu.swa.lab5.componentapplication.domain.product.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@ToString
public class ProductDTO {
    private String productNumber;
    private String description;
    private Double price;
}
