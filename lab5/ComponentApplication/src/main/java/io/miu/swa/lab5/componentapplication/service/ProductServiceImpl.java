package io.miu.swa.lab5.componentapplication.service;

import io.miu.swa.lab5.componentapplication.data.ProductDAO;
import io.miu.swa.lab5.componentapplication.domain.product.Product;
import io.miu.swa.lab5.componentapplication.domain.product.dto.ProductDTO;
import io.miu.swa.lab5.componentapplication.domain.product.dto.ProductDTOAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductDAO dataAccess;

    @Autowired
    ProductDTOAdapter adapter;

    @Override
    public Product getProduct(String id) {
        return dataAccess.findById(id).orElse(null);
    }

    @Override
    public Product addProduct(Product product) {
        return dataAccess.save(product);
    }

    @Override
    public Page<ProductDTO> getALlProduct(Pageable pageable) {
        Page<Product> products =  dataAccess.findAll(pageable);
        return products.map(adapter::getProductDTOFromProduct);
    }
}
