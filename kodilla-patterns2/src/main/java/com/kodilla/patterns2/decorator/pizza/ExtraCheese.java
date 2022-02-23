package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class ExtraCheese extends AbstractPizzaOrderDecorator {

    protected ExtraCheese(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        // hardcoded stub cost = 30
        return super.getCost().add(new BigDecimal(5));
    }

    @Override
    public String getIngredients() {
        return super.getIngredients() + " + extra cheese";
    }
}