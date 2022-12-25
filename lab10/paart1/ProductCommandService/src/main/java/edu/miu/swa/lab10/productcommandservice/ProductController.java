package edu.miu.swa.lab10.productcommandservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    ProductCommandService service;

    @DeleteMapping("/products/{id}")
    public void delete(@PathVariable String id) {
        service.delteProduct(id);
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) {
        return service.addProduct(product);
    }

    @PatchMapping("/products")
    public Product updateProduct(@RequestBody Product product) {
        return service.update(product);
    }

}
