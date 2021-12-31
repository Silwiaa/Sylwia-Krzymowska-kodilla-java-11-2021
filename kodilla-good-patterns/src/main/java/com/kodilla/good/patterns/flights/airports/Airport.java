package com.kodilla.good.patterns.flights.airports;

import com.kodilla.good.patterns.flights.Flight;

import java.util.List;

public interface Airport {
    String getName();
    List<Flight> showFlights();
}
