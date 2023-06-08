package com.example.electronicstore.products;


import jakarta.persistence.*;

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

    public Product() {}

    public Product(int id, String productName, String productDescription, int price) {
        this.id = id;
        this.productName = productName;
        this.productDescription = productDescription;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
