package dealership.controller;

import common.bank.BankAccount;
import dealership.model.Car;
import dealership.model.Dealership;

import java.util.List;

public class DealershipController {
    private final Dealership dealership;

    public DealershipController(Dealership dealership) {
        this.dealership = dealership;
    }

    public void removeCar(Car car) {
        this.dealership.getCars().remove(car);
    }

    public BankAccount getBankAccount() {
        return this.dealership.getBankAccount();
    }

    public List<Car> getCars() {
        return this.dealership.getCars();
    }

    public String getCarsList() {
       return this.dealership.getCarsList();
    }

    public void setCars(List<Car> cars) {
        this.dealership.setCars(cars);
    }

    public Dealership getDealership() {
        return dealership;
    }
}
