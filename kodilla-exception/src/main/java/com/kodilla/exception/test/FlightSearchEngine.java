package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightSearchEngine {
    public void findFilght(Flight flight) throws RouteNotFoundException {
        Map<String, Boolean> airportsMap = new HashMap<>();
        airportsMap.put("Chopin", false);
        airportsMap.put("Balice", false);
        airportsMap.put("Pyrzowice", true);

        String arrives = flight.getArrivalAirport();

        if (airportsMap.containsKey(arrives)) {
            Boolean ifAvaiable = airportsMap.get(arrives);
            if (ifAvaiable != true) {
                System.out.println("The airport " + arrives + " exist, but is not avaiable for the moment");
            } else {
                System.out.println("Have a nice flight to " + arrives);
            }
        } else {
                throw new RouteNotFoundException("The airport " + arrives + " doesn't exist");
        }
    }
}

