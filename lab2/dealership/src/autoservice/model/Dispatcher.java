package autoservice.model;

import common.employee.EmployeeImpl;
import dealership.model.Car;

public class Dispatcher extends EmployeeImpl {
    public Dispatcher(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
    }

    public boolean assignCar(Car car, Mechanic mechanic) {
        if (mechanic.getCurrentCar() != null) {
            throw new RuntimeException("Mechanic is busy with a car!");
        }
        mechanic.setCurrentCar(car);
        return true;
    }
}
