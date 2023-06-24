package com.example.electronicstore.sale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sales")
public class SaleController {
    @Autowired
    private SaleRepository saleRepository;

    @PostMapping
    public Sale createSale(@RequestBody Sale sale) {

        return saleRepository.save(sale);
    }

    @GetMapping("/{id}")
    public Sale getSaleById(@PathVariable Long id) {

    }

    @PutMapping("/{id}")
    public Sale updateSale(@PathVariable Long id, @RequestBody Sale updatedSale) {

    }

    @DeleteMapping("/{id}")
    public void deleteSale(@PathVariable Long id) {
    }
}

