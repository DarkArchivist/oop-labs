package persons;

import bank.BankAccount;
import car.Car;
import car.TestDrive;
import order.Order;

import java.util.Date;


public class Buyer {
    private final String firstName;
    private final String lastName;
    private final int age;
    private final BankAccount bankAccount;
    private Order order;

    public Buyer(String firstName, String lastName, int age, BankAccount bankAccount) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.bankAccount = bankAccount;
    }

    public void testDrive(Car car, Seller seller, double duration, Date date) {
        TestDrive testDrive = new TestDrive(date, duration, this, seller, car);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
