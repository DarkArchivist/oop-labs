package persons;

import car.Car;
import dealership.Dealership;

public class Seller {
    private final String firstName;
    private final String lastName;

    private final Dealership dealership;

    public Seller(String firstName, String lastName, Dealership dealership) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dealership = dealership;
    }

    public void sell(Car car) {
        this.dealership.removeCar(car);
    }

    public void testDrive(Car car) {

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
