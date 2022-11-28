package edu.miu.swa.lab7.stockservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Stock {
    private String stockNumber;
    private Map<String, Product> productList = new HashMap<>();

    public Product getProduct(String productNumber) {
        return productList.get(productNumber);
    }

    public Product addProduct(Product product){
        return productList.put(product.getProductNumber(), product);
    }
}
