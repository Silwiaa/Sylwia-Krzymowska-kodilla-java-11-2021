package com.kodilla.newStream.world;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class World {
    private Set<Continent> continentsSet = new HashSet<>();

    public void addContinent(Continent continent) {
        continentsSet.add(continent);
    }

    public Set<Continent> getContinentSet() {
        return new HashSet<>(continentsSet);
    }

    public BigDecimal getPeopleQuantity() {
        BigDecimal worldPopulation = getContinentSet().stream()
                .flatMap(continent -> continent.getCountrySet().stream())
                .map(Country::getPeopleQuantity)
                .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));
        return worldPopulation;
    }



}
