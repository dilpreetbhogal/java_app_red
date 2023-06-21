package com.example.electronicstore.products;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class ProductController {

    ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping("/addproduct")
    public void addProduct(@RequestBody Product product) {
        Product newProduct = new Product(product.id, product.productName, product.productDescription, product.price);
        service.saveProduct(newProduct);
    }
    @DeleteMapping("/deleteproduct/{id}")
    public String deleteProductById(@PathVariable(name = "id") int id){
        service.deleteProductById(id);
        return "Product Deleted Successfully!!";
    }

    @GetMapping("/findallproducts")
    public String findAllProducts() {
        try {
            List<Product> products = service.findAll();
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(products);
        } catch (Exception e) {
            Logger.getAnonymousLogger().log(Level.SEVERE, "Something went wrong in findAllProducts : " + e);
        }

        return "Done!";
    }
}
