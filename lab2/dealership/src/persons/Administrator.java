package persons;

import base.Person;
import car.Car;
import dealership.Dealership;


public class Administrator extends Person {

    private final Dealership dealership;

    public Administrator(String firstName, String lastName, int age, Dealership dealership) {
        super(firstName, lastName, age);
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

    public Dealership getDealership() {
        return dealership;
    }
}
