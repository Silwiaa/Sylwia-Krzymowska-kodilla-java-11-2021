package com.kodilla.good.patterns.flights.airports;

import com.kodilla.good.patterns.flights.Flight;

import java.util.ArrayList;
import java.util.List;

public class WAW implements Airport {
    private String name;
    private List<Flight> destinationsList = new ArrayList<>();

    public WAW() {
        this.name = "Warszawa - Okecie";
        fillDestinationList();
    }

    private void fillDestinationList() {
        Flight flight1 = new Flight(getName(),"Poznan - Lawica", "POZ");
        Flight flight2 = new Flight(getName(),"Wroclaw", "WRO");
        Flight flight3 = new Flight(getName(),"Lodz - Lublinek", "LCJ");
        Flight flight4 = new Flight(getName(),"Katowice - Pyrzowice", "KAT");
        Flight flight5 = new Flight(getName(),"Krakow - Balice", "KRK");
        Flight flight6 = new Flight(getName(),"Gdansk - Rebiechowo", "GDA");
        Flight flight7 = new Flight(getName(),"Rzeszow - Jasionka", "RZE");
        Flight flight8 = new Flight(getName(),"Bydgoszcz", "BZG");
        Flight flight9 = new Flight(getName(),"Szczecin", "SZZ");

        destinationsList.add(flight1);
        destinationsList.add(flight2);
        destinationsList.add(flight3);
        destinationsList.add(flight4);
        destinationsList.add(flight5);
        destinationsList.add(flight6);
        destinationsList.add(flight7);
        destinationsList.add(flight8);
        destinationsList.add(flight9);
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
