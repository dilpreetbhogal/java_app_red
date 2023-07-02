package com.example.electronicstore.products;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
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

    @GetMapping("/deals")
    public String productDeals(){
        List<Product> products = service.findAll();
        Random randomProduct = new Random();
        StringBuilder output = new StringBuilder();
        int size = products.size();
        int partial = size;
        List<Product> dealProducts = new ArrayList<>();
        for(int i=0; i < partial; i++) {
            dealProducts.add(products.get(randomProduct.nextInt(size)));
        }
        for(int i=0; i<dealProducts.size(); i++) {
            Product product = dealProducts.get(i);
            int price = product.getPrice();
            double newPrice = price - (price * 0.15);
            product.setPrice((int) newPrice);
            String deal = "Product Name --- " + product.getProductName() + " Current Price :  " + price + " Discount Offered : 15% ---  New Price --- " + newPrice;
                     output.append(deal);
                     output.append("\n");
        }

        return output.toString();
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

    @GetMapping("/findproduct/{id}")
    public ResponseEntity<Product> findProductById(@PathVariable(name = "id") int id) {

        Optional<Product> optionalProduct = service.findById(id);
        if (optionalProduct.isPresent()) {
            return ResponseEntity.ok(optionalProduct.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/updateproduct/{id}")
    public ResponseEntity<Product> deleteProductById(@PathVariable(name = "id") int id, @RequestBody Product updatedProduct){
        try {
            Optional<Product> optionalProduct = service.findById(id);
            if (optionalProduct.isPresent()) {
                Product product = optionalProduct.get();
                product.setProductName(updatedProduct.getProductName());
                product.setProductDescription(updatedProduct.getProductDescription());
                product.setPrice(updatedProduct.getPrice());
                service.saveProduct(product);
                return ResponseEntity.status(HttpStatus.CREATED).body(product);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            Logger.getAnonymousLogger().log(Level.SEVERE, "Something went wrong in updateProduct: " + e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
