package autoservice.controller;

import autoservice.model.Autoservice;
import common.bank.BankAccount;
import common.employee.EmployeeImpl;

import java.util.List;

public class AutoserviceController {
    private final Autoservice autoservice;

    public AutoserviceController(Autoservice autoservice) {
        this.autoservice = autoservice;
    }

    public void hireEmployee(EmployeeImpl employee) {
        this.autoservice.hireEmployee(employee);
    }

    public List<EmployeeImpl> getEmployees() {
        return this.autoservice.getEmployees();
    }

    public void setEmployees(List<EmployeeImpl> employees) {
        this.autoservice.setEmployees(employees);
    }

    public BankAccount getBankAccount() {
        return this.autoservice.getBankAccount();
    }

}
