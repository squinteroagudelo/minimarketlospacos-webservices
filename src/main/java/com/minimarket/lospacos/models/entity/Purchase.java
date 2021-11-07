package com.minimarket.lospacos.models.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "compra")
public class Purchase {
    @Id
    @Column(name = "pedido_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "total_compra")
    private double totalPurchase;
    
    @Column(name = "total_descuento")
    private double totalDiscount;
    
    @Column(name = "cantidad_productos")
    private int quantityProducts;
    
    @Column(name = "fecha_compra")
    private LocalDate datePurchase;
    
    @Column(name = "hora_compra")
    private LocalTime timePurchase;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "producto_id")
    private Product productId;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User userId;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the totalPurchase
     */
    public double getTotalPurchase() {
        return totalPurchase;
    }

    /**
     * @param totalPurchase the totalPurchase to set
     */
    public void setTotalPurchase(double totalPurchase) {
        this.totalPurchase = totalPurchase;
    }

    /**
     * @return the totalDiscount
     */
    public double getTotalDiscount() {
        return totalDiscount;
    }

    /**
     * @param totalDiscount the totalDiscount to set
     */
    public void setTotalDiscount(double totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    /**
     * @return the quantityProducts
     */
    public int getQuantityProducts() {
        return quantityProducts;
    }

    /**
     * @param quantityProducts the quantityProducts to set
     */
    public void setQuantityProducts(int quantityProducts) {
        this.quantityProducts = quantityProducts;
    }

    /**
     * @return the datePurchase
     */
    public LocalDate getDatePurchase() {
        return datePurchase;
    }

    /**
     * @param datePurchase the datePurchase to set
     */
    public void setDatePurchase(LocalDate datePurchase) {
        this.datePurchase = datePurchase;
    }

    /**
     * @return the timePurchase
     */
    public LocalTime getTimePurchase() {
        return timePurchase;
    }

    /**
     * @param timePurchase the timePurchase to set
     */
    public void setTimePurchase(LocalTime timePurchase) {
        this.timePurchase = timePurchase;
    }

    /**
     * @return the productId
     */
    public Product getProductId() {
        return productId;
    }

    /**
     * @param productId the productId to set
     */
    public void setProductId(Product productId) {
        this.productId = productId;
    }

    /**
     * @return the userId
     */
    public User getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(User userId) {
        this.userId = userId;
    }

    
}
