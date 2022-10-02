package persons;

import bank.BankAccount;
import base.Person;
import car.Car;
import car.TestDrive;
import order.Order;

import java.util.Date;


public class Buyer extends Person {
    private final BankAccount bankAccount;
    private Order order;

    public Buyer(String firstName, String lastName, int age, BankAccount bankAccount) {
        super(firstName, lastName, age);
        this.bankAccount = bankAccount;
    }

    public void testDrive(Car car, Seller seller, double duration, Date date) {
        TestDrive testDrive = new TestDrive(date, duration, this, seller, car);
    }


    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
