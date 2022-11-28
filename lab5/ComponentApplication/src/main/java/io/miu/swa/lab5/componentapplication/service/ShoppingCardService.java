package io.miu.swa.lab5.componentapplication.service;

import io.miu.swa.lab5.componentapplication.domain.product.dto.ProductDTO;
import io.miu.swa.lab5.componentapplication.domain.shoppingcart.shoppingcart.ShoppingCart;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ShoppingCardService {
    void addShoppingCard(String id, int quantity, ProductDTO productDTO);
    Page<ShoppingCart> getShoppingCarts(Pageable pageable);
}
