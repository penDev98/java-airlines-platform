package main.java.airlines.models;

public class AirplaneClass {
    private String className;
    private String manufacturer;
    private String model;
    private int numberOfSeats;
    private double minTrackLength;
    private double averageSpeed;

    public AirplaneClass(String className, String manufacturer, String model, int numberOfSeats, double minTrackLength, double averageSpeed) {
        this.setClassName(className);
        this.setManufacturer(manufacturer);
        this.setModel(model);
        this.setNumberOfSeats(numberOfSeats);
        this.setMinTrackLength(minTrackLength);
        this.setAverageSpeed(averageSpeed);
    }

    public String getClassName() {
        return this.className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public double getMinTrackLength() {
        return minTrackLength;
    }

    public void setMinTrackLength(double minTrackLength) {
        this.minTrackLength = minTrackLength;
    }

    public double getAverageSpeed() {
        return averageSpeed;
    }

    public void setAverageSpeed(double averageSpeed) {
        this.averageSpeed = averageSpeed;
    }
}