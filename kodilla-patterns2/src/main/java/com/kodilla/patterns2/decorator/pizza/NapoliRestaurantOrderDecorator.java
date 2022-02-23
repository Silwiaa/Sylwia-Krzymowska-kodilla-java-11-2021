package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class NapoliRestaurantOrderDecorator extends AbstractPizzaOrderDecorator {

    protected NapoliRestaurantOrderDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        // hardcoded stub cost = 30
        return super.getCost().add(new BigDecimal(10));
    }

    @Override
    public String getIngredients() {
        return super.getIngredients() + " by Napoli Restaurant";
    }

    @Override
    public String getDeliveryTime() {
        return "max 60 min";
    }

}
