package common.base;

import dealership.car.FuelTank;

public abstract class Vehicle extends BaseEntity {
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

    public void start() {
        this.currentSpeed = 1;
    }

    public void stop() {
        this.currentSpeed = 0;
    }

    public void accelerate(double speed, double distance) {

    }

    public void decelerate(double speed, double distance) {

    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getOdoMeter() {
        return odoMeter;
    }

    public void setOdoMeter(double odoMeter) {
        this.odoMeter = odoMeter;
    }

    public FuelTank getFuelTank() {
        return fuelTank;
    }

    public void setFuelTank(FuelTank fuelTank) {
        this.fuelTank = fuelTank;
    }

    @Override
    public String toString() {
        return "Vehicle{" + "maxSpeed=" + maxSpeed + ", currentSpeed=" + currentSpeed + ", price=" + price + ", odoMeter=" + odoMeter + ", fuelTank=" + fuelTank + '}';
    }
}
