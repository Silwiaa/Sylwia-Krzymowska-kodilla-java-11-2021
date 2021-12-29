package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public class OrderRequestRetriever {
    public OrderRequest retrieve() {
        User user = new User("John", "Doe");
        LocalDateTime orderDate = LocalDateTime.of(2021, 12, 29, 12, 0);
        int productSerialNo = 123456;
        int quantity = 2;
        double price = 20.00;

        return new OrderRequest(user, orderDate, productSerialNo, quantity, price);
    }
}
