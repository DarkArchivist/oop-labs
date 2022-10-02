package persons;

import base.Person;
import car.Car;
import dealership.Dealership;

public class Seller extends Person {

    private final Dealership dealership;

    public Seller(String firstName, String lastName, int age, Dealership dealership) {
        super(firstName, lastName, age);
        this.dealership = dealership;
    }

    public void sell(Car car) {
        this.dealership.removeCar(car);
    }

    public void testDrive(Car car) {

    }

}
