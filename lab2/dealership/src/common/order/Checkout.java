package common.order;

import common.bank.BankAccount;
import dealership.model.Car;
import dealership.Dealership;
import dealership.model.CarStatus;

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
            car.status = CarStatus.SOLD;
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
