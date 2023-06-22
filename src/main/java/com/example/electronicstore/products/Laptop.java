package com.example.electronicstore.products;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="laptops")
public class Laptop {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    public int id;

    @Column
    public String laptopName;
    @Column
    public String laptopDescription;
    @Column
    public int price;
}
