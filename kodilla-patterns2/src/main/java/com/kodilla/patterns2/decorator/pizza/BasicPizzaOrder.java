package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class BasicPizzaOrder implements PizzaOrder {

    @Override
    public BigDecimal getCost() {
        return new BigDecimal(15.00);
    }

    @Override
    public String getIngredients() {
        return "Order pizza: tomato sauce, cheese";
    }

    @Override
    public String getDeliveryTime() {
        return "delivery time: ";
    }
}
