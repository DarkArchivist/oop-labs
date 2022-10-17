package dealership.car;

import common.base.Vehicle;

public class Car extends Vehicle {
    private final String vin;
    public CarStatus status;

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
                ", status=" + status +
                ", price=" + price +
                ", fuelTank=" + fuelTank +
                '}';
    }
}
