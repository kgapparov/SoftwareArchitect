package io.miu.swa.lab5.componentapplication.data;

import io.miu.swa.lab5.componentapplication.domain.product.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDAO extends PagingAndSortingRepository<Product, String> {
}
