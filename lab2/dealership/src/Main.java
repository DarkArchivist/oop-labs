import common.bank.BankAccount;
import dealership.car.Car;
import dealership.car.FuelTank;
import dealership.Dealership;
import dealership.employees.Administrator;
import dealership.employees.Buyer;
import dealership.employees.Seller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankAccount dealershipBankAccount = new BankAccount("dealership", 0, 100000, "maib", "Pushkin");
        List<String> dealershipContacts = new ArrayList<>();
        dealershipContacts.add("078510000");

        // mock dealership.car
        FuelTank fuelTank = new FuelTank(100, 30);
        Car mockCar = new Car("WMWZP3C58FT708366", 160, 5000, fuelTank);

        // cars
        List<Car> dealershipCars = new ArrayList<>();
        dealershipCars.add(mockCar);

        // dealership
        Dealership dealership = new Dealership("8", "9-5", 13, dealershipBankAccount, dealershipContacts, dealershipCars);
        // dealership admin
        Administrator admin = new Administrator("Cornel", "Nastas", 20, 20, dealership);
        // seller
        Seller seller = new Seller("Employee", "Seller", 20, 15, dealership);

        // customer
        BankAccount buyerBankAccount = new BankAccount("Customer", 10000, 100000, "maib", "Pushkin");
        Buyer buyer = new Buyer("Customer", "Buyer", 20, buyerBankAccount);


        boolean flag = true;
        Scanner sc = new Scanner(System.in);


        while (flag) {
            System.out.println("1 - Dealership info");
            System.out.println("2 - Add vehicle");
            System.out.println("3 - Remove vehicle");

            int option = sc.nextInt();

            switch (option) {
                case 1 -> {
                    System.out.println(dealership);
                }
                case 2 -> {
                    System.out.print("Vin code:");
                    String vin = sc.next();

                    System.out.print("Max dealership.car speed:");
                    double maxCarSpeed = sc.nextDouble();

                    System.out.print("Price:");
                    double price = sc.nextDouble();

                    System.out.print("fuel tank volume:");
                    double volume = sc.nextDouble();

                    FuelTank fuelTank1 = new FuelTank(volume, 30);
                    Car car1 = new Car(vin, maxCarSpeed, price, fuelTank1);
                    admin.addCar(car1);
                }
                default -> flag = false;
            }
        }
    }
}