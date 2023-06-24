package com.example.electronicstore.repository;

import com.example.electronicstore.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public class SaleRepository {

    public Sale save(Sale sale) {
    }

    public interface SaleRepository extends JpaRepository<Sale, Long> {

    }

}
