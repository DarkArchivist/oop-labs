package autoservice.employees;

import common.employee.EmployeeImpl;
import dealership.car.Car;

public class Dispatcher extends EmployeeImpl {
    public Dispatcher(String firstName, String lastName, int age, double salaryRate) {
        super(firstName, lastName, age, salaryRate);
    }

    public void assignCar(Car car, Mechanic mechanic) {
        if (mechanic.getCurrentCar() == null) {
            throw new RuntimeException("Mechanic is busy with a car!");
        }
        mechanic.setCurrentCar(car);
    }
}
