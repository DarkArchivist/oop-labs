package dealership.employees;

import common.employee.EmployeeImpl;
import dealership.car.Car;
import dealership.Dealership;

import java.util.Optional;


public class Administrator extends EmployeeImpl {

    private final Dealership dealership;

    public Administrator(String firstName, String lastName, int age, double salaryRate, Dealership dealership) {
        super(firstName, lastName, age, salaryRate);
        this.dealership = dealership;
    }


    public void openDealership() {
        this.dealership.open();
    }

    public void closeDealership() {
        this.dealership.close();
    }

    public Optional<Car> getCar(String vin) {
        var result = this.dealership.findCar(vin);
        if (result.isEmpty()) {
            throw new RuntimeException("No car with such vin code");
        }
        return result;
    }

    public void addCar(Car car) {
        this.dealership.addCar(car);
    }

    public void removeCar(String vin) {
        var car = this.dealership.findCar(vin);
        if (car.isEmpty()) {
            System.out.println("No car with such vin");
        }
        car.ifPresent(this.dealership::removeCar);

    }

    public Dealership getDealership() {
        return dealership;
    }

    @Override
    public String toString() {
        return "Administrator{" +
                "dealership=" + dealership +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
