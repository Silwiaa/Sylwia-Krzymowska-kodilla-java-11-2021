package com.kodilla.good.patterns.flights.airports;

import com.kodilla.good.patterns.flights.Flight;

import java.util.ArrayList;
import java.util.List;

public class KRK implements Airport {
    private String name;
    private List<Flight> destinationsList = new ArrayList<>();

    public KRK() {
        this.name = "Krakow Balice";
        fillDestinationList();
    }

    private void fillDestinationList() {
        Flight flight1 = new Flight(getName(),"Poznan - Lawica", "POZ");
        Flight flight2 = new Flight(getName(),"Wroclaw", "WRO");
        Flight flight3 = new Flight(getName(),"Warszawa - Okecie", "WAW");
        Flight flight4 = new Flight(getName(),"Lodz - Lublinek", "LCJ");
        Flight flight5 = new Flight(getName(),"Katowice - Pyrzowice", "KAT");

        destinationsList.add(flight1);
        destinationsList.add(flight2);
        destinationsList.add(flight3);
        destinationsList.add(flight4);
        destinationsList.add(flight5);
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
