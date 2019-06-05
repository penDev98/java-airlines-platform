package main.java.airlines.models;

public class Flight {
    private String departFrom;
    private String arriveTo;
    private double flightLength;
    private double trackLength;

    public Flight(String departFrom, String arriveTo, double flightLength, double trackLength) {
        this.setDepartFrom(departFrom);
        this.setArriveTo(arriveTo);
        this.setFlightLength(flightLength);
        this.setTrackLength(trackLength);
    }

    public String getDepartFrom() {
        return departFrom;
    }

    public void setDepartFrom(String departFrom) {
        this.departFrom = departFrom;
    }

    public String getArriveTo() {
        return arriveTo;
    }

    public void setArriveTo(String arriveTo) {
        this.arriveTo = arriveTo;
    }

    public double getFlightLength() {
        return flightLength;
    }

    public void setFlightLength(double flightLength) {
        this.flightLength = flightLength;
    }

    public double getTrackLength() {
        return trackLength;
    }

    public void setTrackLength(double trackLength) {
        this.trackLength = trackLength;
    }
}
