package com.example.electronicstore.controller;


import com.example.electronicstore.products.Cart;
import com.example.electronicstore.products.Laptop;
import com.example.electronicstore.repository.CartRepository;
import com.example.electronicstore.repository.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("products/laptops")
public class  LaptopController {

    @Autowired
    LaptopRepository laptopRepository;

    @Autowired
    CartRepository cartRepository;


    @PostMapping("/addlaptop")
    public ResponseEntity<Laptop> addToInventory(@RequestBody Laptop laptop) {
        this.laptopRepository.save(laptop);
        return ResponseEntity.created(null).body(laptop);
    }

    @GetMapping("/home")
    public String getAllCourses(Model model){
        model.addAttribute("laptops",this.laptopRepository.findAll());  //this name will be use in html page
        return "homeLaptop";
    }

    @RequestMapping(value ="/add/{id}")
    public String createCartItems(@PathVariable int id){
        if (this.cartRepository.existsById(id)) {
            Cart cart = this.cartRepository.findById(id).get();
            cart.setQuantity(cart.getQuantity() + 1);
            this.cartRepository.save(cart);
        } else {

            Laptop temp = this.laptopRepository.findById(id).get();
            this.cartRepository.save(
                    new Cart(temp.getId(),
                            temp.getLaptopName(),
                            temp.getPrice(),
                            1));
        }
        return "redirect:/homeLaptop";
    }


}
