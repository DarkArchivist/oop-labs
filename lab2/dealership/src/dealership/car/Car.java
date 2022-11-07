package dealership.car;

import common.base.Vehicle;

public class Car extends Vehicle {
    private final String vin;
    public CarStatus status = CarStatus.ACTIVE;

    public Car(String vin, double maxCarSpeed, double price, FuelTank fuelTank) {
        super(maxCarSpeed, price, fuelTank);
        this.vin = vin;
    }

    public String getVin() {
        return vin;
    }

    public CarStatus getStatus() {
        return status;
    }

    public void setStatus(CarStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return
                "vin='" + vin + '\'' +
                ",\n status=" + status +
                ",\n price=" + price +
                ",\n fuelTank=" + fuelTank +
                '}';
    }
}
