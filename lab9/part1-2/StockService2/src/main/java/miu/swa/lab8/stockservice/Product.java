package miu.swa.lab8.stockservice;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Product {
    private final String productNumber;
    private final Integer numberInStock;
    private final String name;
    private final Double price;
}
