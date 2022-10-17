package common.employee;

import common.base.BaseEntity;

public abstract class EmployeeImpl extends BaseEntity implements Employee {
    protected String firstName;
    protected String lastName;

    protected int age;

    private double workedHours;
    private double salaryRate;

    public EmployeeImpl(String firstName, String lastName, int age, double salaryRate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salaryRate = salaryRate;
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
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
