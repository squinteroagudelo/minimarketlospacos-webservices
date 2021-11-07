package com.minimarket.lospacos.service.impl;

import com.minimarket.lospacos.models.entity.Product;
import com.minimarket.lospacos.models.repository.ProductRepository;
import com.minimarket.lospacos.service.iface.ProductService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    
    @Override
    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(products::add);
        return products;
    }    

    @Override
    public void create(Product product) {
        productRepository.save(product);
    }

    @Override
    public void update(int id, Product product) {
        Optional<Product> existsProduct = productRepository.findById(id);
        if (existsProduct.isPresent()) {
            existsProduct.get().setName(product.getName());
            existsProduct.get().setDescription(product.getDescription());
            existsProduct.get().setImage(product.getImage());
            existsProduct.get().setPrice(product.getPrice());
            existsProduct.get().setQuantity(product.getQuantity());
            productRepository.save(existsProduct.get());
        }
    }

    @Override
    public void delete(int id) {
        Optional<Product> existsProduct = productRepository.findById(id);
        if (existsProduct.isPresent()) {
            productRepository.delete(existsProduct.get());
        }
    }
}
