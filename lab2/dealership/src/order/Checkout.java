package order;

import bank.BankAccount;
import car.Car;
import dealership.Dealership;

public class Checkout extends Order {

    private String shippingAddress;
    private BankAccount bankAccount;

    public Checkout(String shippingAddress, BankAccount bankAccount, Car car) {
        super(car);
        this.shippingAddress = shippingAddress;
        this.bankAccount = bankAccount;
    }

    public void buy(Dealership dealership) {
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
