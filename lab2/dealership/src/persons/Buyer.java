package persons;

import bank.BankAccount;
import car.Car;
import car.TestDrive;

import java.util.Date;


public class Buyer {
    private final String firstName;
    private final String lastName;
    private final int age;

    private double money;

    public Buyer(String firstName, String lastName, int age, double money) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.money = money;
    }

    public void buy(String car, double amount) {
        if (money < amount) {
            throw new RuntimeException("not enough funds");
        }
        money -= amount;
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

}
