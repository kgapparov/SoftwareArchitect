package io.miu.swa.lab5.componentapplication.service;

import io.miu.swa.lab5.componentapplication.domain.product.Product;
import io.miu.swa.lab5.componentapplication.domain.product.dto.ProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    Product getProduct(String id);
    Product addProduct(Product product);
    Page<ProductDTO> getALlProduct(Pageable pageable);
}