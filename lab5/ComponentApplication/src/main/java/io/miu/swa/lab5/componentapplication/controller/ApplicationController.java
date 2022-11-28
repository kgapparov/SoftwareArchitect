package io.miu.swa.lab5.componentapplication.controller;

import io.miu.swa.lab5.componentapplication.domain.product.Product;
import io.miu.swa.lab5.componentapplication.domain.product.dto.ProductDTO;
import io.miu.swa.lab5.componentapplication.domain.product.dto.ProductDTOAdapter;
import io.miu.swa.lab5.componentapplication.service.ProductService;
import io.miu.swa.lab5.componentapplication.service.ShoppingCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ApplicationController {
    @Autowired
    ProductService productService;

    @Autowired
    ShoppingCardService shoppingCardService;

    @Autowired
    ProductDTOAdapter adapter;

    @PostMapping("/products")
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }

    @GetMapping("/products/{id}")
    public ProductDTO getProduct(@PathVariable String id) {
       return  adapter.getProductDTOFromProduct(productService.getProduct(id));
    }

    @GetMapping("/products")
    public Page<ProductDTO> getAllProduct(Pageable pageable) {
        return productService.getALlProduct(pageable);
    }

    @PostMapping("/shoppingcarts")
    public void add(@RequestParam String id, @RequestParam int quantity, @RequestBody ProductDTO product) {
        shoppingCardService.addShoppingCard(id, quantity, product);
    }

    @GetMapping("/shoppingcarts")
    public @ResponseBody ResponseEntity<?> getAll(Pageable pageable) {
        return ResponseEntity.ok(shoppingCardService.getShoppingCarts(pageable));
    }
}
