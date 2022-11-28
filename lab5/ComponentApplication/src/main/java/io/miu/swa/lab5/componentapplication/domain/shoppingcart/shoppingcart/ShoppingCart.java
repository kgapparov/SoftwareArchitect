package io.miu.swa.lab5.componentapplication.domain.shoppingcart.shoppingcart;

import io.miu.swa.lab5.componentapplication.domain.product.dto.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.ArrayList;
import java.util.List;

@Document
@Data
@AllArgsConstructor
public class ShoppingCart {
    @MongoId
    private String shoppingcartNumber;
    private List<CartLine> cartLineList;

    public ShoppingCart() {
        cartLineList = new ArrayList<>();
    }

    public void addToCart(int quantity,ProductDTO product ) {
       CartLine cartLine = new CartLine(quantity,product);
       cartLineList.add(cartLine);
    }

    public void removeFromCart(int index){
        this.cartLineList.remove(index);
    }

    public void changeQuantity(int quantity,ProductDTO product) {
        for (int i = 0; i < cartLineList.size(); i++) {
            if (cartLineList.get(i).getProduct().equals(product)) {
                cartLineList.set(i, new CartLine(quantity, product));
            }
        }
    }
}
