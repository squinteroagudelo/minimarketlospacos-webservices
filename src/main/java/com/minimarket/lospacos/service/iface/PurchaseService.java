package com.minimarket.lospacos.service.iface;

import com.minimarket.lospacos.models.entity.Purchase;
import java.util.List;

public interface PurchaseService {
    
    void create(Purchase purchase);
    
    List<Purchase> getAll();
    
    void update(int id, Purchase purchase);
    
    void delete(int id);
}
