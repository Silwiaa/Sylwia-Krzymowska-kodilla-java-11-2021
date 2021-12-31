package com.kodilla.good.patterns.flights;

public class Flight {
    private String departureCode;
    private String arrivalAirport;
    private String airportCode;

    public Flight(String departureCode, String arrivalAirport, String airportCode) {
        this.departureCode = departureCode;
        this.arrivalAirport = arrivalAirport;
        this.airportCode = airportCode;
    }
    public String getDepartureCode() {
        return departureCode;
    }
    public String getArrivalAirport() {
        return arrivalAirport;
    }
    public String getAirportCode() {
        return airportCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flight flight = (Flight) o;

        if (!getDepartureCode().equals(flight.getDepartureCode())) return false;
        if (!getArrivalAirport().equals(flight.getArrivalAirport())) return false;
        return getAirportCode().equals(flight.getAirportCode());
    }

    @Override
    public int hashCode() {
        int result = getDepartureCode().hashCode();
        result = 31 * result + getArrivalAirport().hashCode();
        result = 31 * result + getAirportCode().hashCode();
        return result;
    }
}
