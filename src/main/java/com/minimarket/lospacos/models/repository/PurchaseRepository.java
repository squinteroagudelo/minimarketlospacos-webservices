package com.minimarket.lospacos.models.repository;

import com.minimarket.lospacos.models.entity.Purchase;
import org.springframework.data.repository.CrudRepository;

public interface PurchaseRepository extends CrudRepository<Purchase, Integer> {
    
}
