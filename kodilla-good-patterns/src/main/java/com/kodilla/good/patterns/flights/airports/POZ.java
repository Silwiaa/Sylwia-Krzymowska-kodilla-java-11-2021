package com.kodilla.good.patterns.flights.airports;

import com.kodilla.good.patterns.flights.Flight;

import java.util.ArrayList;
import java.util.List;

public class POZ implements Airport {
    private String name;
    private List<Flight> destinationsList = new ArrayList<>();

    public POZ() {
        this.name = "Poznan - Lawica";
        fillDestinationList();
    }

    private void fillDestinationList() {
        Flight flight1 = new Flight(getName(),"Warszawa - Okecie", "WAW");
        Flight flight2 = new Flight(getName(),"Katowice - Pyrzowice", "KAT");

        destinationsList.add(flight1);
        destinationsList.add(flight2);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<Flight> showFlights(){
        return destinationsList;
    }
}
