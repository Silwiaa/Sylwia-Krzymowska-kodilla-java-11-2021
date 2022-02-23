package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class RusticRestaurantOrderDecorator extends AbstractPizzaOrderDecorator {

    protected RusticRestaurantOrderDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        // hardcoded stub cost = 30
        return super.getCost().add(new BigDecimal(12));
    }

    @Override
    public String getIngredients() {
        return super.getIngredients() + " by Rustic Restaurant";
    }

    @Override
    public String getDeliveryTime() {
        return "max 30 min";
    }
}

