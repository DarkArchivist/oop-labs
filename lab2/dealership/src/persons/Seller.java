package persons;

import car.Car;
import dealership.Dealership;

public class Seller {
    private final String firstName;
    private final String lastName;

    private final String dealership;

    public Seller(String firstName, String lastName, String dealership) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dealership = dealership;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
