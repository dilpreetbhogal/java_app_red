package com.example.electronicstore.products;

import com.example.electronicstore.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService{

    ProductRepository repository;

    public ProductService(ProductRepository productRepository) {
        this.repository = productRepository;
    }


    public void saveProduct(Product product) {
        repository.save(product);
    }

    public List<Product> findAll() {
        return repository.findAll();
    }
}
