package dealership.employees;

import dealership.car.CarStatus;
import common.employee.EmployeeImpl;
import dealership.car.Car;
import dealership.Dealership;

public class Seller extends EmployeeImpl {

    private final Dealership dealership;

    public Seller(String firstName, String lastName, int age, double salaryRate, Dealership dealership) {
        super(firstName, lastName, age, salaryRate);
        this.dealership = dealership;
    }


    public void sell(Car car) {
        car.status = CarStatus.SOLD;
        this.dealership.removeCar(car);
    }

    public void testDrive(Car car) {
        car.status = CarStatus.TEST_DRIVE;
    }

    public void returnCar(Car car) {
        car.status = CarStatus.ACTIVE;
    }

    @Override
    public String toString() {
        return "Seller{" +
                "dealership=" + dealership +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
