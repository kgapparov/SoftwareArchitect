package io.miu.swa.lab5.componentapplication;

import io.miu.swa.lab5.componentapplication.client.ClientService;
import io.miu.swa.lab5.componentapplication.domain.product.dto.ProductDTO;
import io.miu.swa.lab5.componentapplication.pagedto.ResponsePage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.client.RestOperations;



@SpringBootApplication
@Slf4j
public class ComponentApplication implements CommandLineRunner {

    @Autowired
    ClientService clientService;

    @Autowired
    RestOperations client;
    public static void main(String[] args) {
        SpringApplication.run(ComponentApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //Create products
        clientService.addProduct("1123-ddc-df", "Iphone Accessory", 2.99);
        clientService.addProduct("1123-123-df", "Iphone Accessory", 3.99);
        clientService.addProduct("1123-542-df", "Iphone Accessory", 4.99);
        clientService.addProduct("1123-sdf-df", "Iphone Accessory", 5.99);

        //get all products
        ResponsePage<ProductDTO> result = clientService.getProducts();

        //create shopping carts for each product
        result.forEach(product -> clientService.addShoppingCart("ddsf", 3, product));


        //Print results
        log.info("Products : {} ", result.getContent());
        log.info("ShoppingCarts : {}" , clientService.getShoppingCarts().getContent());
    }
}
