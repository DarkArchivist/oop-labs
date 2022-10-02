package order;

import bank.BankAccount;
import car.Car;
import dealership.Dealership;

public class Checkout {

    private String shippingAddress;
    private BankAccount bankAccount;

    public Checkout(String shippingAddress, BankAccount bankAccount) {
        this.shippingAddress = shippingAddress;
        this.bankAccount = bankAccount;
    }

    public void buy(Car car, Dealership dealership) {
        try {
            dealership.removeCar(car);
            this.bankAccount.transfer(dealership.getBankAccount(), car.getPrice());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }
}
