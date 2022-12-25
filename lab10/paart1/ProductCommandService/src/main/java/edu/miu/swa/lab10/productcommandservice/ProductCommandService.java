package edu.miu.swa.lab10.productcommandservice;

import com.mongodb.MongoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductCommandService {
    @Autowired
    ProductRepository repository;

    @Autowired
    KafkaTemplate<String, Product> template;

    public Product addProduct(Product product) {
        Product product1 = repository.insert(product);
        template.send("addProduct", product1);
        return product1;
    }

    public void delteProduct(String id) throws MongoException {
            Optional<Product> product = repository.findById(id);
            product.ifPresent(repository::delete);
            template.send("deleteProduct", product.orElse(null));
    }

    public Product update(Product product) {
        Product product1 =  repository.save(product);
        template.send("updateProduct", product1);
        return product1;
    }
}
