package com.example.electronicstore.repository;

import com.example.electronicstore.products.Laptop;
import com.example.electronicstore.products.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaptopRepository extends JpaRepository< Laptop, Integer> {
}
