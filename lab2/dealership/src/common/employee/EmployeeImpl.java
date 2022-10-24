package common.employee;

import common.base.Person;

public abstract class EmployeeImpl extends Person implements Employee {
    private double workedHours;
    private double salaryRate;

    public EmployeeImpl(String firstName, String lastName, int age, double salaryRate) {
        super(firstName, lastName, age);
        this.age = age;
        this.salaryRate = salaryRate;
    }


    @Override
    public double getSalaryRate() {
        return this.salaryRate;
    }

    @Override
    public void setSalaryRate(double salaryRate) {
        this.salaryRate = salaryRate;
    }

    @Override
    public double getWorkedHours() {
        return this.workedHours;
    }

    @Override
    public void setWorkedHours(double workedHours) {
        this.workedHours = workedHours;
    }

    @Override
    public void clockIn() {
        timer.schedule(Employee.wrap(() -> this.setWorkedHours(this.workedHours += 1)), 60 * 60 * 1000);
    }

    @Override
    public double clockOut(double hours, double salaryRate) {
        if (this.workedHours <  hours) {
            throw new RuntimeException("Cannot clock out with given hours");
        }
        this.workedHours -= hours;
        return hours * salaryRate;
    }
}
