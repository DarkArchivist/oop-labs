package common.employee;

import common.base.Person;

public abstract class EmployeeImpl extends Person implements Employee {
    private double workedHours;

    public EmployeeImpl(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
        this.age = age;
    }


    @Override
    public double getWorkedHours() {
        return this.workedHours;
    }

    @Override
    public void setWorkedHours(double workedHours) {
        this.workedHours = workedHours;
    }

}
