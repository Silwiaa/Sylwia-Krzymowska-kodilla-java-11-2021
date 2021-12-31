package com.kodilla.good.patterns.flights;

import com.kodilla.good.patterns.flights.airports.Airport;

import java.util.Map;

public class SearchProcessor {
    SearchingService searchingService;

    public SearchProcessor(SearchingService searchingService) {
        this.searchingService = searchingService;
    }
    public void processSearch(final Map<String, String> searchedCitiesList) {
        boolean isSearched = searchingService.search(searchedCitiesList);
        if (isSearched) {
            System.out.println("Searching processed successfully.");
        } else {
            System.out.println("Searching process failed.");
        }
    }
}
