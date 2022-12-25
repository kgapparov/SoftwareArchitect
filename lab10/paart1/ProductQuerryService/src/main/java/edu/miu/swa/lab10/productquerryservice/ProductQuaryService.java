package edu.miu.swa.lab10.productquerryservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ProductQuaryService {

    @Autowired
    ProductRepository repository;

    @KafkaListener(topics = "addStock", groupId = "group_id")
    public ProductDTO addProductStock(Stock stock) {
        ProductDTO productDTO = repository.findProductDTOByProductProductNumber(stock.getProductNumber());
        if (productDTO == null) {
            productDTO = new ProductDTO();
        }
        productDTO.setNumberInStock(stock.getNumberInStock());
        repository.save(productDTO);
        return productDTO;
    }

    @KafkaListener(topics = "addProduct", groupId = "group_id")
    public ProductDTO addProductByProduct(Product product) {
        ProductDTO productDTO = repository.findProductDTOByProductProductNumber(product.getProductNumber());
        if (productDTO == null) {
            productDTO = new ProductDTO();
            product = new Product(product.getProductNumber(), product.getName(), product.getPrice());
            productDTO.setNumberInStock(productDTO.getNumberInStock());
        }
        repository.save(productDTO);

        return productDTO;
    }

}
