import bank.BankAccount;
import car.Car;
import car.FuelTank;
import dealership.Dealership;
import persons.Administrator;
import persons.Buyer;
import persons.Seller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankAccount dealershipBankAccount = new BankAccount("dealership", 0, 100000, "maib", "Pushkin");
        List<String> dealershipContacts = new ArrayList<>();
        dealershipContacts.add("078510000");

        // mock car
        FuelTank fuelTank = new FuelTank(100, 30);
        Car mockCar = new Car("WMWZP3C58FT708366", 160, 5000);



        // cars
        List<String> dealershipCars = new ArrayList<>();
        dealershipCars.add("mockCar");
        dealershipCars.add("mockCar1");
        dealershipCars.add("mockCar2");

        // dealership
        Dealership dealership = new Dealership("8", "9-5", 13, dealershipContacts, dealershipCars);
        // dealership admin
        Administrator admin = new Administrator("Cornel", "Nastas", "dealership");
        // seller
        Seller seller = new Seller("Employee", "Seller", "dealership");

        // customer
        BankAccount buyerBankAccount = new BankAccount("Customer", 10000, 100000, "maib", "Pushkin");
        Buyer buyer = new Buyer("Customer", "Buyer", 20, 5000);


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
                    System.out.println("Enter car name");
                    String s = sc.next();
                    dealership.addCar(s);
                }
                case 3 -> {
                    System.out.println("Enter car name");
                    String s = sc.next();
                    dealership.removeCar(s);
                }
                default -> flag = false;
            }
        }
    }
}