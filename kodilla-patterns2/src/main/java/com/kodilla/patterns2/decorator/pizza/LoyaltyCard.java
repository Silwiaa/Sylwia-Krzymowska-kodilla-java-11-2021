package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LoyaltyCard extends AbstractPizzaOrderDecorator {

    protected LoyaltyCard(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        // hardcoded stub cost = 30
        return round(super.getCost().multiply(new BigDecimal(0.9)));
    }

    private BigDecimal round(BigDecimal value) {
        int precision = 0;
        return value.setScale(precision, RoundingMode.HALF_UP);
    }
}