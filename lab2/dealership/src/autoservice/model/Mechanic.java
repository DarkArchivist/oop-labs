package autoservice.model;

import common.employee.EmployeeImpl;

import util.Constants;

import dealership.model.Car;
import dealership.model.CarStatus;

public class Mechanic extends EmployeeImpl {

    private Car currentCar;

    public Mechanic(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
    }

    public Car getCurrentCar() {
        return currentCar;
    }

    public void setCurrentCar(Car currentCar) {
        this.currentCar = currentCar;
    }

    public void repairCar(double time) {
        double currentWorkedHours = this.getWorkedHours();
        currentWorkedHours += time;
        this.setWorkedHours(currentWorkedHours);

        Constants.timer.schedule(Constants.wrap(() -> {
            currentCar.setStatus(CarStatus.ACTIVE);
            currentCar = null;
        }), (long) time);
    }
}
