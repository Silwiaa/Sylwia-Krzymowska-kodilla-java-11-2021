package com.kodilla.exception.test;

public class Application {
    public static void main(String[] args) throws RouteNotFoundException {
        //First scenario
        Flight flight = new Flight("New York", "Pyrzowice");
        FlightSearchEngine flightSearch = new FlightSearchEngine();

        try {
            flightSearch.findFilght(flight);
        } catch (RouteNotFoundException r) {
            System.out.println(r);
        }

        //Second scenario
        Flight flight2 = new Flight("New York", "Chopin");

        try {
            flightSearch.findFilght(flight2);
        } catch (RouteNotFoundException r) {
            System.out.println(r);
        }

        //Third scenario
        Flight flight3 = new Flight("Chopin", "New York");

        try {
            flightSearch.findFilght(flight3);
        } catch (RouteNotFoundException r) {
            System.out.println(r);
        }
    }
}
