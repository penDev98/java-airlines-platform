package main.java.airlines.models;

import java.util.ArrayList;
import java.util.List;

public class Airline {

    private List<Airplane> airplanes = new ArrayList<Airplane>();
    private List<Flight> flights = new ArrayList<Flight>();
    private List<AirplaneClass> classes = new ArrayList<AirplaneClass>();

    public List<Airplane> getAirplanes() {
        return airplanes;
    }

    public void addAirplane(Airplane airplane) {
        this.airplanes.add(airplane);
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void addFlight(Flight flight) {
        this.flights.add(flight);
    }

    public List<AirplaneClass> getClasses() {
        return classes;
    }

    public void addClass(AirplaneClass _class) {
        this.classes.add(_class);
    }
}
