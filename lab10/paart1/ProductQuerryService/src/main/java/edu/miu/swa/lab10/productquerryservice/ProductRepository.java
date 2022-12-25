package edu.miu.swa.lab10.productquerryservice;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<ProductDTO, String> {
    public ProductDTO findProductDTOByProductProductNumber(String productNumber);
}
