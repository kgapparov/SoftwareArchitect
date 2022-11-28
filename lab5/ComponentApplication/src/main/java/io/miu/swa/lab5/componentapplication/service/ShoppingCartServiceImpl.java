package io.miu.swa.lab5.componentapplication.service;

import io.miu.swa.lab5.componentapplication.data.ShoppingCartDAO;
import io.miu.swa.lab5.componentapplication.domain.product.dto.ProductDTO;
import io.miu.swa.lab5.componentapplication.domain.shoppingcart.shoppingcart.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl implements ShoppingCardService{
    @Autowired
    ShoppingCartDAO repository;

    @Override
    public void addShoppingCard(String id, int quantity, ProductDTO productDTO) {
        ShoppingCart shoppingCart = repository.findById(id).orElse(null);
         if (shoppingCart == null) {
             shoppingCart = new ShoppingCart();
         }
         shoppingCart.addToCart(quantity, productDTO);
         repository.save(shoppingCart);
    }

    @Override
    public Page<ShoppingCart> getShoppingCarts(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
