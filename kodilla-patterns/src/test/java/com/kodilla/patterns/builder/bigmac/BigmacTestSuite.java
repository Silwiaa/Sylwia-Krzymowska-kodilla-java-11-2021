package com.kodilla.patterns.builder.bigmac;

import com.kodilla.patterns.builder.pizza.Pizza;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BigmacTestSuite {
    @Test
    void testBigMacNew() {
        //Given
        BigMac bigMac = new BigMac.BigMacBuilder()
                .bun("No sesame bun")
                .burgers(2)
                .sauce("Standard")
                .ingredient("Shredded Lettuce")
                .ingredient("American Cheese")
                .ingredient("Pickle Slices")
                .ingredient("Onions")
                .build();
        System.out.println(bigMac);
        //When
        int howManyIngredients = bigMac.getIngredients().size();

        //Then
        assertEquals(4, howManyIngredients);
    }
}
