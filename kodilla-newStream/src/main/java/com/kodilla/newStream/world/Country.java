package com.kodilla.newStream.world;

import java.math.BigDecimal;

public class Country {
    private final String nameOfCountry;
    private final BigDecimal peopleQuantity;

    public Country(final String nameOfCountry, final BigDecimal peopleQuantity) {
        this.nameOfCountry = nameOfCountry;
        this.peopleQuantity = peopleQuantity;
    }

    public String getNameOfCountry() {
        return nameOfCountry;
    }

    public BigDecimal getPeopleQuantity() {
            return peopleQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country = (Country) o;

        return getNameOfCountry() != null ? getNameOfCountry().equals(country.getNameOfCountry()) : country.getNameOfCountry() == null;
    }
}
