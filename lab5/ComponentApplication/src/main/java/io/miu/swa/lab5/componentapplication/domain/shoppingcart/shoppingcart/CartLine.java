package io.miu.swa.lab5.componentapplication.domain.shoppingcart.shoppingcart;

import io.miu.swa.lab5.componentapplication.domain.product.dto.ProductDTO;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CartLine {
    private Integer quantity;

    private ProductDTO product;

    public CartLine(Integer quantity, ProductDTO product) {
        this.quantity = quantity;
        this.product = product;
    }

    public CartLine addToCart(int quantity, ProductDTO productDTO) {
        return new CartLine(quantity, product);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public ProductDTO getProduct() {
        return product;
    }
}
