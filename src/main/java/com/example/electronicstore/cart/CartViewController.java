package com.example.electronicstore.cart;

import com.example.electronicstore.products.Product;
import com.example.electronicstore.products.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
public class CartViewController {

    ProductService productService;
    CartService cartService;


    public CartViewController(ProductService productService, CartService cartService) {

        this.productService = productService;
        this.cartService = cartService;
    }

    @PostMapping("/cart/add/{productId}")
    public String addToCart(@PathVariable("productId") int productId) {
        Optional<Product> optionalProduct = productService.findById(productId);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            Cart cartItem = new Cart();
            cartItem.setProduct(product);
            cartItem.setDeliveryDate(LocalDateTime.now().plusDays(7));
            cartService.saveCartItem(cartItem);
        } else {
            return "product-list";
        }

        return "redirect:/cart";
    }

    @GetMapping("/cart")
    public String viewCartItems(Model model) {
        try {
            List<Cart> cartItems = cartService.findAll();
            model.addAttribute("cartItems", cartItems);
        } catch (Exception e) {
            Logger.getAnonymousLogger().log(Level.SEVERE, "Something went wrong in viewCartItems : " + e);
        }
        return "cart-items";
    }

}
