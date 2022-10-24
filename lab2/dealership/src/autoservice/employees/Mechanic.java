package autoservice.employees;

import common.employee.Employee;
import common.employee.EmployeeImpl;
import dealership.car.Car;
import dealership.car.CarStatus;

public class Mechanic extends EmployeeImpl {

    private Car currentCar;

    public Mechanic(String firstName, String lastName, int age, double salaryRate) {
        super(firstName, lastName, age, salaryRate);
    }

    public Mechanic(String firstName, String lastName, int age, double salaryRate, Car currentCar) {
        super(firstName, lastName, age, salaryRate);
        this.currentCar = currentCar;
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

        timer.schedule(Employee.wrap(() -> currentCar.setStatus(CarStatus.ACTIVE)), (long) time);
    }
}
