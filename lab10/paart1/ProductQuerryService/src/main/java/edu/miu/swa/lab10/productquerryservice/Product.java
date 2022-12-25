package edu.miu.swa.lab10.productquerryservice;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Product {
    private String productNumber;
    private String name;
    private Double price;
}
