package com.kodilla.newStream.world;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorldTestSuite {
    @Test
    void testGetPeopleQuantity() {

        //Given
        Continent continent1 = new Continent("Eurasia");
        continent1.addCountry(new Country("Poland", new BigDecimal("37.95")));
        continent1.addCountry(new Country("Russia", new BigDecimal("144.1")));

        Continent continent2 = new Continent("Americas");
        continent2.addCountry(new Country("USA", new BigDecimal("329.5")));
        continent2.addCountry(new Country("Brasil", new BigDecimal("212.6")));

        Continent continent3 = new Continent("Africa");
        continent3.addCountry(new Country("Ethiopia", new BigDecimal("115.0")));
        continent3.addCountry(new Country("Algeria", new BigDecimal("43.85")));

        World world = new World();
        world.addContinent(continent1);
        world.addContinent(continent2);
        world.addContinent(continent3);

        BigDecimal expectedPopulation = new BigDecimal("883.00");

        //When
        BigDecimal worldPopulation = world.getPeopleQuantity();

        //Then
        assertEquals(expectedPopulation, worldPopulation);
    }
}
