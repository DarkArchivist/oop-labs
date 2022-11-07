package common.employee;

import java.util.TimerTask;

public interface Employee {

    public double getSalaryRate();
    public void setSalaryRate(double salaryRate);

    public double getWorkedHours();
    public void setWorkedHours(double workedHours);

    public void clockIn();
    public double clockOut(double hours, double salaryRate);
}
