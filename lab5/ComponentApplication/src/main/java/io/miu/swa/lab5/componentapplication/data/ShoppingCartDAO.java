package io.miu.swa.lab5.componentapplication.data;

import io.miu.swa.lab5.componentapplication.domain.shoppingcart.shoppingcart.ShoppingCart;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartDAO extends PagingAndSortingRepository<ShoppingCart, String> {
}
