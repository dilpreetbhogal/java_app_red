package com.example.electronicstore.products;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="products")
public class Product {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    public int id;

    @Column
    public String productName;
    @Column
    public String productDescription;
    @Column
    public int price;


}
