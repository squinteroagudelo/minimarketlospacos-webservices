package com.minimarket.lospacos.models.repository;

import com.minimarket.lospacos.models.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    
}
