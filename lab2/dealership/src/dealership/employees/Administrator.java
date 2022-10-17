package dealership.employees;

import common.employee.EmployeeImpl;
import dealership.car.Car;
import dealership.Dealership;


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

    public void addCar(Car car) {
        this.dealership.addCar(car);
    }

    public void removeCar(Car car) {
        this.dealership.removeCar(car);
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
