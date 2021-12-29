package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public class OrderRequest {
    private User user;
    private LocalDateTime orderDate;
    private int productSerialNo;
    private int quantity;
    private double price;

    public OrderRequest(
            final User user,
            final LocalDateTime orderDate,
            final int productSerialNo,
            final int quantity,
            final double price) {
        this.user = user;
        this.orderDate = orderDate;
        this.productSerialNo = productSerialNo;
        this.quantity = quantity;
        this.price = price;
    }

    public User getUser() { return user; }

    public LocalDateTime getOrderDate() { return orderDate; }

    public int getProductSerialNo() { return productSerialNo; }

    public int getQuantity() { return quantity; }

    public double getPrice() { return price; }
}
