package com.example.electronicstore.sale;

import org.springframework.data.jpa.repository.JpaRepository;

public class SaleRepository {

    public Sale save(Sale sale) {
    }

    public interface SaleRepository extends JpaRepository<Sale, Long> {

    }

}
