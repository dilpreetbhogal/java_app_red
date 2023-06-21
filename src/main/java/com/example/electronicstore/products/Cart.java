package com.example.electronicstore.products;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="shoppingcart")
@Entity
public class Cart {


    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    public int id;
    public String name;
    public int price;
    public int quantity;
}
