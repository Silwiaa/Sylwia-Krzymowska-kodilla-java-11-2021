package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public class ProductOrderService implements OrderService {
    @Override
    public boolean order(
            final User user,
            final LocalDateTime orderDate,
            final int productSerialNo,
            final int quantity,
            final double price) {

        System.out.println(
                "Order for: " + user.getName() + " " + user.getSurname() +
                ", product serial number: " + productSerialNo +
                ", order date: " + orderDate +
                ", quantity: " + quantity +
                ", price: " + price + "PLN");
        return true;
    }
}
