package common.employee;

import java.util.Timer;
import java.util.TimerTask;



public interface Employee {
    Timer timer = new Timer();

    static TimerTask wrap(Runnable r) {
        return new TimerTask() {
            @Override
            public void run() {
                r.run();
            }
        };
    }

    public String getFirstName();
    public void setFirstName(String firstName);

    public String getLastName();
    public void setLastName(String lastName);

    public double getSalaryRate();
    public void setSalaryRate(double salaryRate);

    public double getWorkedHours();
    public void setWorkedHours(double workedHours);

    public void clockIn();
    public double clockOut(double hours, double salaryRate);
}
