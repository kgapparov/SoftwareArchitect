package io.miu.swa.lab5.componentapplication.client;

import io.miu.swa.lab5.componentapplication.domain.product.Product;
import io.miu.swa.lab5.componentapplication.domain.product.dto.ProductDTO;
import io.miu.swa.lab5.componentapplication.domain.shoppingcart.shoppingcart.ShoppingCart;
import io.miu.swa.lab5.componentapplication.pagedto.ResponsePage;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.UriTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;
import org.springframework.web.util.UriBuilder;

import java.util.HashMap;
import java.util.Map;

@Service
@Data
public class ClientService {
    @Autowired
    RestOperations client;

    @Value("${productServingURI}")
    private String servingURI;

    public void addProduct(String id, String description, Double price) {
        client.postForLocation(servingURI, Product.builder()
                .productNumber(id)
                .description(description)
                .price(price)
                .build()
        );
    }

    public ResponsePage<ProductDTO> getProducts() {
        ResponseEntity<ResponsePage<ProductDTO>> restResponse =
                client.exchange(servingURI + "/products", HttpMethod.GET, null, new ParameterizedTypeReference<>() {
                });
        return restResponse.getBody();
    }

    public void addShoppingCart(String id, int quantity, ProductDTO product) {
        client.postForLocation(servingURI + "/shoppingcarts?id="+id+"&quantity="+quantity, product);
    }

    public ResponsePage<ShoppingCart> getShoppingCarts(){
        ResponseEntity<ResponsePage<ShoppingCart>> restResponse =
                client.exchange(servingURI + "/shoppingcarts", HttpMethod.GET, null, new ParameterizedTypeReference<>() {
                });
        return restResponse.getBody();
    }

}
