package com.minimarket.lospacos.service.iface;

import com.minimarket.lospacos.models.entity.Product;
import java.util.List;

public interface ProductService {
    
    void create(Product product);
    
    List<Product> getAll();
    
    void update(int id, Product product);
    
    void delete(int id);
}
