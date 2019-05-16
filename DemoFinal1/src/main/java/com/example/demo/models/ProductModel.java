package com.example.demo.models;

public class ProductModel {
    private String productName;

    public ProductModel(String productName) {
        this.productName = productName;
    }

    public ProductModel() {
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
