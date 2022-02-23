package com.kodilla.patterns2.decorator.pizza;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PizzaOrderTestSuite {

    @Test
    public void testBasicPizzaOrderGetCost() {

        // Given
        PizzaOrder theOrder = new BasicPizzaOrder();

        // When
        BigDecimal calculatedCost = theOrder.getCost();

        // Then
        assertEquals(new BigDecimal(15), calculatedCost);
    }

    @Test
    public void testBasicPizzaOrderGetIngredients() {

        // Given
        PizzaOrder theOrder = new BasicPizzaOrder();

        // When
        String ingredients = theOrder.getIngredients();

        // Then
        assertEquals("Order pizza: tomato sauce, cheese", ingredients);
    }

    @Test
    public void testNapoliRestaurantGetCost() {

        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new NapoliRestaurantOrderDecorator(theOrder);

        //When
        BigDecimal theCost = theOrder.getCost();

        //Then
        assertEquals(new BigDecimal(25), theCost);
    }

    @Test
    public void testNapoliRestaurantGetIngredients() {

        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new NapoliRestaurantOrderDecorator(theOrder);

        //When
        String ingredients = theOrder.getIngredients();

        //Then
        assertEquals("Order pizza: tomato sauce, cheese by Napoli Restaurant", ingredients);
    }

    @Test
    public void testRusticRestaurantWithExtraCheeseGetCost() {

        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new RusticRestaurantOrderDecorator(theOrder);
        theOrder = new ExtraCheese(theOrder);

        //When
        BigDecimal theCost = theOrder.getCost();

        //Then
        assertEquals(new BigDecimal(32), theCost);
    }

    @Test
    public void testRusticRestaurantWithExtraCheeseGetIngredients() {

        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new RusticRestaurantOrderDecorator(theOrder);
        theOrder = new ExtraCheese(theOrder);

        //When
        String ingredients = theOrder.getIngredients();

        //Then
        assertEquals("Order pizza: tomato sauce, cheese by Rustic Restaurant + extra cheese", ingredients);
    }

    @Test
    public void testLoyaltyCardNapoliRestaurantWithExtraCheeseGetCost() {

        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new NapoliRestaurantOrderDecorator(theOrder);
        theOrder = new ExtraCheese(theOrder);
        theOrder = new LoyaltyCard(theOrder);

        //When
        BigDecimal theCost = theOrder.getCost();

        //Then
        assertEquals(new BigDecimal(27), theCost);
    }
}
