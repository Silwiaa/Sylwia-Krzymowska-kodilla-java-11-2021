package com.kodilla.newStream.world;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Continent {
    private final String continentName;
    private Set<Country> countrySet = new HashSet<>();

    public Continent(final String continentName) {
        this.continentName = continentName;
    }

    public String getContinentName() {
        return continentName;
    }

    public void addCountry(Country country) {
        countrySet.add(country);
    }

    public Set<Country> getCountrySet() {
        return new HashSet<>(countrySet);
    }


}
