package com.kodilla.good.patterns.flights;

import java.util.Map;

public class Application {
    public static void main(String[] args) {
        FlightsSearchRetriever flightsSearchRetriever = new FlightsSearchRetriever();
        Map<String, String> searchedCitiesList = flightsSearchRetriever.retrieve();

        SearchProcessor searchProcessor = new SearchProcessor(new FlightsSearchingService());
        searchProcessor.processSearch(searchedCitiesList);
    }
}
