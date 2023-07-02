package com.example.electronicstore.cart;

import com.example.electronicstore.products.Product;
import com.example.electronicstore.products.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    CartRepository repository;

    public CartService(CartRepository cartRepository) {
        this.repository = cartRepository;
    }

    public List<Cart> findAll() {
        return repository.findAll();
    }

    public void saveCartItem(Cart cartItem) {
        repository.save(cartItem);
    }

}
