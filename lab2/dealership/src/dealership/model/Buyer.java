package dealership.model;

import common.bank.BankAccount;
import common.employee.Review;
import common.order.Order;
import common.base.Person;

import java.util.Date;


public class Buyer extends Person {
    private final BankAccount bankAccount;
    private Order order;

    public Buyer(String firstName, String lastName, int age, BankAccount bankAccount) {
        super(firstName, lastName, age);
        this.bankAccount = bankAccount;
    }

    public TestDrive testDrive(Car car, Seller seller, double duration, Date date) {
        return new TestDrive(date, duration, this, seller, car);
    }

    public void finishTestDrive(TestDrive testDrive) {
            testDrive.finishTestDrive(testDrive);
    }

    public void giveReview(Seller seller, Review review) {
            seller.receiveReview(review);
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void buyCar(Car car, BankAccount dealershipBankAccount) {
        bankAccount.transfer(dealershipBankAccount, car.getPrice());
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "bankAccount=" + bankAccount +
                ", order=" + order +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
