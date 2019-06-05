package main.java.airlines.models;

public class Airplane extends Aircraft {

    private double staffCharges;
    private double fuelPerKilometer;
    private double reservoirSize;

    public Airplane(int id, AirplaneClass _class, double staffCharges, double fuelPerKilometer, double reservoirSize) {
        this.setId(id);
        this.set_class(_class);
        this.setStaffCharges(staffCharges);
        this.setFuelPerKilometer(fuelPerKilometer);
        this.setReservoirSize(reservoirSize);
    }

    public boolean isCompatible(double trackLength, double flightLength) {
        if (this.get_class().getMinTrackLength() <= trackLength) {
            if ((flightLength * this.getFuelPerKilometer()) <= this.getReservoirSize()) {
                return true;
            }
        }
        return false;
    }

    public double getCharges(double flightLength, double fuelPrice) {
        return (this.getStaffCharges() + ((this.getFuelPerKilometer() * flightLength) * fuelPrice));
    }

    public double getStaffCharges() {
        return staffCharges;
    }

    public void setStaffCharges(double staffCharges) {
        this.staffCharges = staffCharges;
    }

    public double getFuelPerKilometer() {
        return fuelPerKilometer;
    }

    public void setFuelPerKilometer(double fuelPerKilometer) {
        this.fuelPerKilometer = fuelPerKilometer;
    }

    public double getReservoirSize() {
        return reservoirSize;
    }

    public void setReservoirSize(double reservoirSize) {
        this.reservoirSize = reservoirSize;
    }
}
