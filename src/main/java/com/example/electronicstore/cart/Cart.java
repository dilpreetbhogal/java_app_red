package com.example.electronicstore.cart;

import com.example.electronicstore.products.Product;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="cartItems")
public class Cart {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    public int id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @Column
    public LocalDateTime deliveryDate;

    public Cart() {
    }

    public Cart(Product product, LocalDateTime deliveryDate) {
        this.product = product;
        this.deliveryDate = deliveryDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public LocalDateTime getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDateTime deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
}
