package com.example.electronicstore.products;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
public class ProductViewController {

    private final WebClient webClient;
    private final String apiUrl = "http://localhost:8080/api";

    public ProductViewController(WebClient webClient) {
        this.webClient = webClient;
    }

    @GetMapping("/products")
    public String viewProducts(Model model) {
        String productsUrl = apiUrl + "/findallproducts";
        ResponseEntity<String> response = webClient.get()
                .uri(productsUrl)
                .retrieve()
                .toEntity(String.class)
                .block();
        if (response.getStatusCode() == HttpStatus.OK) {
            String productListJson = response.getBody();
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                List<Product> productList = objectMapper.readValue(productListJson, new TypeReference<List<Product>>() {});
                model.addAttribute("products", productList);
            } catch (IOException e) {
                Logger.getAnonymousLogger().log(Level.SEVERE, "Something went wrong in viewProducts: " + e);
            }
        }
        return "product-list";
    }

}
