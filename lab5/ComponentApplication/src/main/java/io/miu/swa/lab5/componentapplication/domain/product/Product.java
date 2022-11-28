package io.miu.swa.lab5.componentapplication.domain.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;


@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    @MongoId
    private String productNumber;
    private String description;
    private Double price;

    private Supplier supplier;
    private List<Review> reviews;
    private Stock stock;
}
