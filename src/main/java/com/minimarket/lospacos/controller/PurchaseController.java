package com.minimarket.lospacos.controller;

import com.minimarket.lospacos.models.entity.Purchase;
import com.minimarket.lospacos.service.iface.PurchaseService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/purchases")
@CrossOrigin("*")
public class PurchaseController {
    
    @Autowired
    private PurchaseService purchaseService;
    
    @GetMapping
    public List<Purchase> getAll(){
        return purchaseService.getAll();
    }
    
    @PostMapping
    public void create(@RequestBody Purchase purchase){
        purchaseService.create(purchase);
    }
    
    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Purchase purchase){
        purchaseService.update(id, purchase);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        purchaseService.delete(id);
    }
}
