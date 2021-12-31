package com.kodilla.good.patterns.flights.airports;

import com.kodilla.good.patterns.flights.Flight;

import java.util.ArrayList;
import java.util.List;

public class SZZ implements Airport {
    private String name;
    private List<Flight> destinationsList = new ArrayList<>();

    public SZZ() {
        this.name = "Szczecin";
        fillDestinationList();
    }

    private void fillDestinationList() {
        Flight flight1 = new Flight(getName(),"Warszawa - Okecie", "WAW");

        destinationsList.add(flight1);
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
