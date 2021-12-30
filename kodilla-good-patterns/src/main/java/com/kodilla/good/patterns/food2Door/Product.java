package com.kodilla.good.patterns.food2Door;

public class Product {
    int productSerialNo;
    int quantity;
    String productType;

    public Product(int productSerialNo, int quantity, String productType) {
        this.productSerialNo = productSerialNo;
        this.quantity = quantity;
        this.productType = productType;
    }

    public int getProductSerialNo() {
        return productSerialNo;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getProductType() {
        return productType;
    }
}
