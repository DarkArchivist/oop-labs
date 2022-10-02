package car;

import base.Vehicle;

public class Car extends Vehicle {
    private final String vin;

    public Car(String vin, double maxCarSpeed, double price, FuelTank fuelTank) {
        super(maxCarSpeed, price, fuelTank);
        this.vin = vin;
    }

    public String getVin() {
        return vin;
    }

    @Override
    public String toString() {
        return "Car{" +
                "vin='" + vin + '\'' +
                ", currentCarSpeed=" + currentSpeed +
                ", maxCarSpeed=" + maxSpeed +
                ", price=" + price +
                ", odoMeter=" + odoMeter +
                ", fuelTank=" + fuelTank +
                '}';
    }
}
