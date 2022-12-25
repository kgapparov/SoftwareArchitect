package edu.miu.swa.lab10.productcommandservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductCommandServiceApplication implements CommandLineRunner {

    @Autowired
    private ProductCommandService service;

    public static void main(String[] args) {

        SpringApplication.run(ProductCommandServiceApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        Product product = new Product(null, 1L, "Iphone", 980.0);
        System.out.println(service.addProduct(product));
    }
}
