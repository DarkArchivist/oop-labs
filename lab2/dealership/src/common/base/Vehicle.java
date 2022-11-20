package common.base;

import dealership.model.FuelTank;

public abstract class Vehicle {
    protected final double maxSpeed;
    protected double currentSpeed;
    protected double price;
    protected double odoMeter;
    protected FuelTank fuelTank;

    public Vehicle(double maxSpeed, double price, FuelTank fuelTank) {
        this.maxSpeed = maxSpeed;
        this.price = price;
        this.fuelTank = fuelTank;
    }

    public double getPrice() {
        return price;
    }


    @Override
    public String toString() {
        return "Vehicle{" + "maxSpeed=" + maxSpeed + ", currentSpeed=" + currentSpeed + ", price=" + price + ", odoMeter=" + odoMeter + ", fuelTank=" + fuelTank + '}';
    }
}
