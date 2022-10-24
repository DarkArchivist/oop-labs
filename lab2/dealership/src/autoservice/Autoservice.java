package autoservice;

import common.bank.BankAccount;
import common.base.Building;
import common.employee.EmployeeImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Autoservice extends Building {
    private final BankAccount bankAccount;
    private List<String> contact;

    private List<EmployeeImpl> employees = new ArrayList<>();

    public Autoservice(String workingHours, String schedule, int breakHour, BankAccount bankAccount) {
        super(workingHours, schedule, breakHour);
        this.bankAccount = bankAccount;
    }

    public Autoservice(String workingHours, String schedule, int breakHour, BankAccount bankAccount, List<String> contact) {
        super(workingHours, schedule, breakHour);
        this.bankAccount = bankAccount;
        this.contact = contact;
    }

    public Autoservice(String workingHours, String schedule, int breakHour, BankAccount bankAccount, List<String> contact, List<EmployeeImpl> employees) {
        super(workingHours, schedule, breakHour);
        this.bankAccount = bankAccount;
        this.contact = contact;
        this.employees = employees;
    }

    public void hireEmployee(EmployeeImpl employee) {
        this.employees.add(employee);
    }

    public void fireEmployee(EmployeeImpl employee) {
        try {
            this.employees.remove(employee);
        } catch (RuntimeException e) {
            throw new RuntimeException("Couldn't find such employee");
        }
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public List<String> getContact() {
        return contact;
    }

    public void setContact(List<String> contact) {
        this.contact = contact;
    }

    public List<EmployeeImpl> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeImpl> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Autoservice{" +
                "contact=" + contact +
                ", employees=" + employees +
                ", workingHours='" + workingHours + '\'' +
                ", schedule='" + schedule + '\'' +
                ", breakHour=" + breakHour +
                ", isOpen=" + isOpen +
                '}';
    }
}
