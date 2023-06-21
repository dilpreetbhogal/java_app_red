package com.example.electronicstore.repository;

import com.example.electronicstore.products.Cart;
import com.example.electronicstore.products.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer> {
}
