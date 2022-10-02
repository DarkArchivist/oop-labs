package car;

public class Car {
    private final String vin;

    private double currentCarSpeed;
    private double maxCarSpeed;
    private double price;
    private double odoMeter;
    private FuelTank fuelTank;

    public Car(String vin, double maxCarSpeed, double price, FuelTank fuelTank) {
        this.vin = vin;
        this.maxCarSpeed = maxCarSpeed;
        this.price = price;
        this.fuelTank = fuelTank;
    }

    public void start() {
        this.currentCarSpeed = 1;
    }

    public void stop() {
        this.currentCarSpeed = 0;
    }

    public void accelerate(double speed, double distance) {

    }

    public void decelerate(double speed, double distance) {

    }

    public String getVin() {
        return vin;
    }

    public double getCurrentCarSpeed() {
        return currentCarSpeed;
    }

    public void setCurrentCarSpeed(double currentCarSpeed) {
        this.currentCarSpeed = currentCarSpeed;
    }

    public double getMaxCarSpeed() {
        return maxCarSpeed;
    }

    public void setMaxCarSpeed(double maxCarSpeed) {
        this.maxCarSpeed = maxCarSpeed;
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
        return "Car{" +
                "vin='" + vin + '\'' +
                ", currentCarSpeed=" + currentCarSpeed +
                ", maxCarSpeed=" + maxCarSpeed +
                ", price=" + price +
                ", odoMeter=" + odoMeter +
                ", fuelTank=" + fuelTank +
                '}';
    }
}
