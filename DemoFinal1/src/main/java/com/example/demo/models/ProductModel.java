package com.example.demo.models;

public class ProductModel {
    private int productId;
    private String productName;


    public ProductModel() {
    }

    public ProductModel(int productId, String productName) {
        this.productId = productId;
        this.productName = productName;
    }


    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }


}
