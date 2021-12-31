package com.kodilla.good.patterns.flights.airports;

import com.kodilla.good.patterns.flights.Flight;

import java.util.ArrayList;
import java.util.List;

public class GDN implements Airport {
    private String name;
    private List<Flight> destinationsList = new ArrayList<>();

    public GDN() {
        this.name = "Gdansk - Rebiechewo";
        fillDestinationList();
    }

    private void fillDestinationList() {
        Flight flight1 = new Flight(getName(), "Warszawa - Okecie", "WAW");
        Flight flight2 = new Flight(getName(),"Krakow - Balice", "KRK");
        Flight flight3 = new Flight(getName(),"Rzeszow - Jasionka", "RZE");

        destinationsList.add(flight1);
        destinationsList.add(flight2);
        destinationsList.add(flight3);
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

