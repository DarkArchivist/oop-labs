package persons;

import car.Car;
import dealership.Dealership;


public class Administrator {

    private final String firstName;
    private final String lastName;

    private final Dealership dealership;

    public Administrator(String firstName, String lastName, Dealership dealership) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dealership = dealership;
    }

    public void openDealership() {
        this.dealership.open();
    }

    public void closeDealership() {
        this.dealership.close();
    }

    public void addCar(Car car) {
        this.dealership.addCar(car);
    }

    public void removeCar(Car car) {
        this.dealership.removeCar(car);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Dealership getDealership() {
        return dealership;
    }
}
