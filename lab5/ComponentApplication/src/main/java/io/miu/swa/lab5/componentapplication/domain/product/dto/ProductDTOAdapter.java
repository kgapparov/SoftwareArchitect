package io.miu.swa.lab5.componentapplication.domain.product.dto;

import io.miu.swa.lab5.componentapplication.data.ProductDAO;
import io.miu.swa.lab5.componentapplication.domain.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductDTOAdapter {

    @Autowired
    ProductDAO repository;

    public Product getProductFromProductDTO(ProductDTO productDTO) {
        return repository.findById(productDTO.getProductNumber()).orElse(null);
    }
    public ProductDTO getProductDTOFromProduct(Product product) {
        return new ProductDTO(product.getProductNumber(), product.getDescription(), product.getPrice());
    }
}
