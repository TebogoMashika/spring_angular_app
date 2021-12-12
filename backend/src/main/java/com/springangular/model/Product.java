package com.springangular.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "product")
public class Product {

    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String productName;
    private String productDesc;
    private int productPrice;

    public Product() {
    }

    public Product(String productName, String productDesc, int productPrice) {
        this.productName = productName;
        this.productDesc = productDesc;
        this.productPrice = productPrice;
    }

}
