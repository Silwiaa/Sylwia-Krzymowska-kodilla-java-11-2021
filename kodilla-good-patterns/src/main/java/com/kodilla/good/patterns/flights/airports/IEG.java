package com.kodilla.good.patterns.flights.airports;

import com.kodilla.good.patterns.flights.Flight;

import java.util.ArrayList;
import java.util.List;

public class IEG implements Airport {
    private String name;
    private List<Flight> destinationsList = new ArrayList<>();

    public IEG() {
        this.name = "Zielona Gora";
        fillDestinationList();
    }

    private void fillDestinationList() {
        Flight flight1 = new Flight(getName(),"Bydgoszcz", "BZG");
        Flight flight2 = new Flight(getName(),"Szczecin", "SZZ");
        Flight flight3 = new Flight(getName(),"Warszawa - Modlin", "WMI");

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
