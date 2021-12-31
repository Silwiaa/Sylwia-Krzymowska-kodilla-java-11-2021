package com.kodilla.good.patterns.flights;

import com.kodilla.good.patterns.flights.airports.*;

import java.util.*;
import java.util.stream.Collectors;

public class FlightsSearchingService implements SearchingService{
    Map<String, List<Flight>> allFlightsHashMap = new HashMap<>();
    @Override
    public boolean search(Map<String, String> searchedCitiesList) {
        System.out.println("New search process started.");

        for (Map.Entry<String, String> entry : searchedCitiesList.entrySet()) {
            String airport = entry.getValue();

            if (entry.getKey() == "from") {
                System.out.println("Searched city: " + airport + "\n");
                System.out.println("Possible destinations from " + airport + " are: ");
                searchFrom(airport);
                System.out.println();

            } else {
                System.out.println("Direct flights to " + airport + " are possible from: ");
                List<String> airportList = searchDirectTo(airport);
                System.out.println("\n" + "A flight to " + airport + " is also possible from: ");
                searchWithTransitTo(airport, airportList);
            }
        }

        return true;
    }

    private void searchFrom(String airport) {
        allFlightsHashMap = getAllFlights();

        String arrivalAirports = allFlightsHashMap.entrySet().stream()
                .flatMap(f -> f.getValue().stream())
                .filter(f -> f.getDepartureCode().equals(airport))
                .map(f -> f.getArrivalAirport())
                .collect(Collectors.joining("," + "\n"));

        System.out.println(arrivalAirports);
    }

    private List<String> searchDirectTo(String airport) {
        allFlightsHashMap = getAllFlights();

        List<String> departureAirports = allFlightsHashMap.entrySet().stream()
                            .flatMap(f -> f.getValue().stream())
                            .filter(f -> f.getArrivalAirport().equals(airport))
                            .map(f -> f.getDepartureCode())
                            .collect(Collectors.toList());

        for (String departureAirport : departureAirports) {
            System.out.println(departureAirport + ",");
        }

        return departureAirports;
    }

    private void searchWithTransitTo(String airport, List<String> airportList) {
        for (int i = 0 ; i < airportList.size() ; i++) {
            searchDirectTo(airportList.get(i));
        }

        System.out.println();
        System.out.println("With transit at: ");
        List<String> departureAirportList = searchDirectTo(airport);
    };

    private Map<String, List<Flight>> getAllFlights() {
        BZG bzg = new BZG();
        GDN gdn = new GDN();
        IEG ieg = new IEG();
        KRK krk = new KRK();
        KTW ktw = new KTW();
        LCJ lcj = new LCJ();
        POZ poz = new POZ();
        RZE rze = new RZE();
        SZZ szz = new SZZ();
        WAW waw = new WAW();
        WMI wmi = new WMI();
        WRO wro = new WRO();

        allFlightsHashMap.put(bzg.getName(), bzg.showFlights());
        allFlightsHashMap.put(gdn.getName(), gdn.showFlights());
        allFlightsHashMap.put(ieg.getName(), ieg.showFlights());
        allFlightsHashMap.put(krk.getName(), krk.showFlights());
        allFlightsHashMap.put(ktw.getName(), ktw.showFlights());
        allFlightsHashMap.put(lcj.getName(), lcj.showFlights());
        allFlightsHashMap.put(poz.getName(), poz.showFlights());
        allFlightsHashMap.put(rze.getName(), rze.showFlights());
        allFlightsHashMap.put(szz.getName(), szz.showFlights());
        allFlightsHashMap.put(waw.getName(), waw.showFlights());
        allFlightsHashMap.put(wmi.getName(), wmi.showFlights());
        allFlightsHashMap.put(wro.getName(), wro.showFlights());

        return allFlightsHashMap;
    }
}
