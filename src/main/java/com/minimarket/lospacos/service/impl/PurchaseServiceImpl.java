package com.minimarket.lospacos.service.impl;

import com.minimarket.lospacos.models.entity.Product;
import com.minimarket.lospacos.models.entity.Purchase;
import com.minimarket.lospacos.models.entity.User;
import com.minimarket.lospacos.models.repository.ProductRepository;
import com.minimarket.lospacos.models.repository.PurchaseRepository;
import com.minimarket.lospacos.models.repository.UserRepository;
import com.minimarket.lospacos.service.iface.PurchaseService;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseServiceImpl implements PurchaseService {
    
    @Autowired
    private PurchaseRepository purchaseRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;
    
    @Override
    public List<Purchase> getAll() {
        List<Purchase> purchases = new ArrayList<>();
        purchaseRepository.findAll().forEach(purchases::add);
        return purchases;
    }    

    @Override
    public void create(Purchase purchase) {
        Optional<Product> existsProduct = productRepository
                .findById(purchase.getProductId().getId());
        Optional<User> existsUser = userRepository
                .findById(purchase.getUserId().getId());
        if (existsProduct.isPresent() && existsUser.isPresent()) {
            purchase.setDatePurchase(LocalDate.now());
            purchase.setTimePurchase(LocalTime.now());
            purchaseRepository.save(purchase);
        }
    }

    @Override
    public void update(int id, Purchase purchase) {
        Optional<Purchase> existsPurchase = purchaseRepository.findById(id);
        if (existsPurchase.isPresent()) {
            existsPurchase.get().setTotalPurchase(purchase.getTotalPurchase());
            existsPurchase.get().setTotalDiscount(purchase.getTotalDiscount());
            existsPurchase.get().setQuantityProducts(purchase.getQuantityProducts());
            Optional<Product> product = productRepository
                    .findById(purchase.getProductId().getId());
            if (product.isPresent()) {
                existsPurchase.get().setProductId(product.get());
            }
            Optional<User> user = userRepository
                    .findById(purchase.getUserId().getId());
            if (user.isPresent()) {
                existsPurchase.get().setUserId(user.get());
            }
            purchaseRepository.save(existsPurchase.get());
        }
    }

    @Override
    public void delete(int id) {
        Optional<Purchase> existsPurchase = purchaseRepository
                .findById(id);
        if (existsPurchase.isPresent()) {
            purchaseRepository.delete(existsPurchase.get());
        }
    }
}
