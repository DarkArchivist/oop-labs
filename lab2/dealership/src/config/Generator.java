package config;

import autoservice.Autoservice;
import autoservice.employees.Mechanic;
import common.bank.BankAccount;
import dealership.car.Car;
import dealership.car.FuelTank;
import dealership.employees.Buyer;

import java.util.Arrays;

import static config.Constants.*;

public final class Generator {


    public static String[] generateName() {
        String firstName = firstNames[rand.nextInt(0, firstNames.length - 1)];
        String lastName = lastNames[rand.nextInt(0, lastNames.length - 1)];

        return new String[] {
                firstName,
                lastName
        };
    }

    public static FuelTank generateFuelTank() {
        double randomVolume = rand.nextInt(50, 100);
        double randomLevel = rand.nextInt(10, 30);

        return new FuelTank(randomVolume, randomLevel);
    }

    public static Car generateCar() {
       String randomVin = vins[rand.nextInt(0, vins.length - 1)];
       double randomMaxSpeed = rand.nextInt(100, 150);
       double randomPrice = rand.nextInt(5000, 15000);

       FuelTank fuelTank = generateFuelTank();

       return new Car(randomVin,randomMaxSpeed, randomPrice, fuelTank);
    }

    public static BankAccount generateBankAccount(int amount, int limit, String owner) {
            String bank = banks[rand.nextInt(0, banks.length - 1)];
            String address = addresses[rand.nextInt(0, addresses.length - 1)];
            return new BankAccount(owner, amount, limit, bank, address);
    }

    public static Buyer generateCustomer() {
        int amount = rand.nextInt(5000, 20000);
        int age = rand.nextInt(18, 50);

        String[] customerName = generateName();
        BankAccount bankAccount = generateBankAccount(amount, 25000, Arrays.toString(customerName));

        return new Buyer(customerName[0],
                customerName[1],
                age,
                bankAccount);
    }

    public static Mechanic generateMechanic() {
        int salaryRate = rand.nextInt(10, 15);
        int age = rand.nextInt(18, 50);

        String[] customerName = generateName();

        return new Mechanic(customerName[0],
                customerName[1],
                age,
                salaryRate);
    }
}
