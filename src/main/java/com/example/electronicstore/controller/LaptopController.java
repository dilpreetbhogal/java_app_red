package com.example.electronicstore.controller;


import com.example.electronicstore.products.Laptop;
import com.example.electronicstore.repository.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products/laptops")
public class LaptopController {

    @Autowired
    LaptopRepository laptopRepository;


    @PostMapping("/addlaptop")
    public ResponseEntity<Laptop> addToInventory(@RequestBody Laptop laptop) {
        this.laptopRepository.save(laptop);
        return ResponseEntity.created(null).body(laptop);
    }

    @GetMapping("/home")
    public List<Laptop> getAllItems() {
        return this.laptopRepository.findAll();
    }
}
