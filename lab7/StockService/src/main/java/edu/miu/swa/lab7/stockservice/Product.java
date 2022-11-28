package edu.miu.swa.lab7.stockservice;

import lombok.AllArgsConstructor;
import lombok.Getter;


/**
 * Create value object producgt entity for stock Entity
 */
@Getter
@AllArgsConstructor
public class Product {
    private final String productNumber;
    private final Integer numberInStock;
    private final String name;
    private final Double price;
}
