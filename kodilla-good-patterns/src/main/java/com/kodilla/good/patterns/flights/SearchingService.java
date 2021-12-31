package com.kodilla.good.patterns.flights;

import com.kodilla.good.patterns.flights.airports.Airport;

import java.util.Map;

public interface SearchingService {
    boolean search(Map<String, String> searchedCitiesList);
}
