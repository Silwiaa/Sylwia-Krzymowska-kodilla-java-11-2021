package com.kodilla.good.patterns.flights;

import com.kodilla.good.patterns.flights.airports.Airport;
import com.kodilla.good.patterns.flights.airports.RZE;

import java.util.*;

public class FlightsSearchRetriever {
    public Map<String, String> retrieve() {
        Map<String, String> searchedCitiesList = new HashMap<>();
        String from = "from";
        String to = "to";
        String airport = new RZE().getName();

        searchedCitiesList.put(from, airport);
        searchedCitiesList.put(to, airport);

        return searchedCitiesList;
    }
}
