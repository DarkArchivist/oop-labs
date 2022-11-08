package config;

import autoservice.Autoservice;
import autoservice.employees.Dispatcher;
import autoservice.employees.Mechanic;

import common.bank.BankAccount;
import common.employee.EmployeeImpl;
import common.employee.Review;

import dealership.Dealership;
import dealership.car.Car;
import dealership.car.CarStatus;
import dealership.car.TestDrive;
import dealership.employees.Administrator;
import dealership.employees.Buyer;
import dealership.employees.Seller;


import static config.Constants.rand;
import static config.Generator.*;

import java.util.*;

public class Config {
    private final Autoservice autoservice = new Autoservice("8",
            "9-5",
            13,
            generateBankAccount(0, 100000, "Autoservice"));
    private final Dealership dealership = new Dealership("8",
            "9-5",
            13,
            generateBankAccount(150000, 1000000, "Dealership"),
            new ArrayList<>(),
            new ArrayList<>());


    public void init() throws InterruptedException {
        Dispatcher dispatcher = new Dispatcher("firstName", "lastName", 20, 10);
        autoservice.hireEmployee(dispatcher);

        // GENERATE mechanics
        for (int i = 0; i < 5; i++) {
            Mechanic mechanic = generateMechanic();
            autoservice.hireEmployee(mechanic);
        }

        // GENERATE Cars
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            Car mockCar = generateCar();
            cars.add(mockCar);
        }
        dealership.setCars(cars);

        // admin
        Administrator admin = new Administrator("Cornel", "Nastas", 20, 20, dealership);
        // seller
        Seller seller = new Seller("Employee", "Seller", 20, 15, dealership);

        boolean flag = true;
        Scanner sc = new Scanner(System.in);


        while (flag) {
            System.out.println("1 - Customer tries to buy a car");
            System.out.println("2 - Dealership bank");
            System.out.println("3 - Sellers rating, reviews");

            int option = sc.nextInt();

            switch (option) {
                case 1 -> {
                    while (true) {
                        if (dealership.getCars().isEmpty()) {
                            System.out.println("Dealership has no available cars");
                            break;
                        }
                        int bonus = 0;

                        String description = "";
                        double stars;

                        // customer
                        Buyer buyer = generateCustomer();
                        System.out.printf("-------- Customer %s %s enters store --------%n", buyer.getFirstName(), buyer.getLastName());

                        // car
                        Car testCar = dealership
                                .getCars()
                                .get(rand.nextInt(0, dealership.getCars().size() - 1));

                        System.out.printf("----- Customer chooses car %s%n -----", testCar);

                        System.out.printf("----- Customer takes car for a test drive -----%n");

                        TestDrive testDrive = buyer.testDrive(testCar, seller, 10, new Date());

                        Constants.timer.schedule(Constants.wrap(() -> {
                            buyer.finishTestDrive(testDrive);
                            System.out.printf("----- Test drive finished -----%n%n%n");
                        }), 4000);

                        Thread.sleep(4000);

                        // add bonus for positive roll
                        bonus += 0.5;

                        // checks for price range
                        if (buyer.getBankAccount().getAmount() > testCar.getPrice() / 2) {
                            bonus += 2;
                        }

                        // roll the dice for an unlucky event
                        int unluckyEvent = rand.nextInt(10);

                        if (unluckyEvent == 1) {
                            System.out.println("----- Car needs service, broke down during test drive! -----");
                            testCar.setStatus(CarStatus.SERVICE);

                            List<EmployeeImpl> mechanics = autoservice.getEmployees()
                                    .stream()
                                    .filter(employee -> employee.getClass().getName().equals("autoservice.employees.Mechanic"))
                                    .toList();

                            boolean res = false;
                            Mechanic mech = null;

                            for (EmployeeImpl mechanic : mechanics) {
                                res = dispatcher.assignCar(testCar, (Mechanic) mechanic);
                                if (res) {
                                    System.out.printf("----- Car is being taken care of by %s %s-----%n%n",
                                            mechanic.getFirstName(), mechanic.getLastName());
                                    mech = (Mechanic) mechanic;
                                    break;
                                }
                            }

                            if (mech == null) {
                                System.out.println("----- There are no available mechanics -------%n%n%n");

                                Thread.sleep(4000);
                                continue;
                            }

                            int price = rand.nextInt(1000, 5000);
                            mech.repairCar(10);
                            if (price > 1000 && price < 2000) {
                                System.out.println("Good mechanic !");
                                dealership.getBankAccount().transfer(autoservice.getBankAccount(), price);
                            } else if (price > 2000 && price < 3000) {
                                System.out.println("Cheeky mechanic ?!");
                                dealership.getBankAccount().transfer(autoservice.getBankAccount(), price);
                            } else {
                                System.out.println("(Dealership) How come ? Are you out of your mind ?");
                                System.out.println("(Mechanic) Lets see again.");
                                int newPrice = rand.nextInt(1000, 3000);
                                if (newPrice > 1000 && newPrice < 2000) {
                                    System.out.println("Good mechanic !");
                                    dealership.getBankAccount().transfer(autoservice.getBankAccount(), price);
                                } else if (newPrice > 2000 && newPrice < 3000) {
                                    System.out.println("Cheeky mechanic ?!");
                                    dealership.getBankAccount().transfer(autoservice.getBankAccount(), price);
                                }
                            }

                            description = "He gave me a car with a defect, what could happen in the worst case scenario ???";
                            System.out.printf("----- u1=%s -----%n", description);

                            stars = 1;

                            seller.receiveReview(new Review(description, stars));
                            continue;
                        }

                        int satisfaction = rand.nextInt(10) + bonus;
                        if (satisfaction > 0 && satisfaction < 5) {
                            switch (rand.nextInt(4)) {
                                case 1 -> {
                                    description = "Terrible person";
                                    System.out.printf("----- u1=%s -----%n", description);

                                    stars = 1;
                                }
                                case 2 -> {
                                    description = "Doesn't know what he is supposed to do";
                                    System.out.printf("----- u1=%s -----%n", description);

                                    stars = 2;
                                }
                                case 3 -> {
                                    description = "He didn't adhere to my specifications";
                                    System.out.printf("----- u1=%s -----%n", description);

                                    stars = 3;
                                }
                                default -> {
                                    description = "I'd rather not talk";
                                    System.out.printf("----- u1=%s -----%n", description);

                                    stars = 4;
                                }
                            }

                            Review review = new Review(description, stars);
                            seller.receiveReview(review);
                            continue;
                        }

                        switch (rand.nextInt(4, 10) + bonus) {
                            case 5 -> {
                                description = "Could use some lessons.";
                                System.out.printf("----- u1=%s -----%n", description);

                                stars = 5;
                            }
                            case 6 -> {
                                description = "I wish he'd listen more.";
                                System.out.printf("----- u1=%s -----%n", description);

                                stars = 6;
                            }
                            case 7 -> {
                                description = "Made me wait a whole lot before actually talking business.";
                                System.out.printf("----- u1=%s -----%n", description);
                                stars = 7;

                                if (buyer.getBankAccount().getAmount() > testCar.getPrice()) {
                                    buyer.buyCar(dealership.getCars().get(0), dealership.getBankAccount());
                                    seller.sell(dealership.getCars().get(0));
                                }

                            }
                            case 8 -> {
                                description = "Overall pleasant experience.";
                                System.out.printf("----- u1=%s -----%n", description);
                                stars = 8;

                                if (buyer.getBankAccount().getAmount() > testCar.getPrice()) {
                                    buyer.buyCar(dealership.getCars().get(0), dealership.getBankAccount());
                                    seller.sell(dealership.getCars().get(0));
                                }


                            }
                            case 9 -> {
                                description = "Nice suggestions, could be a bit more understanding.";
                                System.out.printf("----- %s -----%n", description);
                                stars = 9;

                                if (buyer.getBankAccount().getAmount() > testCar.getPrice()) {
                                    seller.sell(dealership.getCars().get(0));
                                    buyer.buyCar(dealership.getCars().get(0), dealership.getBankAccount());
                                }

                            }
                            default -> {
                                description = "Excellent experience, pleasure to work with such persons.";
                                System.out.printf("----- u1=%s -----%n", description);
                                stars = 10;

                                if (buyer.getBankAccount().getAmount() > testCar.getPrice()) {
                                    buyer.buyCar(dealership.getCars().get(0), dealership.getBankAccount());
                                    seller.sell(dealership.getCars().get(0));
                                }
                            }
                        }

                        Review review = new Review(description, stars);
                        seller.receiveReview(review);
                        Thread.sleep(5000);

                        System.out.println("Enter 10 to quit program, otherwise continue");
                        int key = sc.nextInt();
                        if (key == 10) break;
                    }

                }

                case 2 -> System.out.println(dealership.getBankAccount());
                case 3 -> {
                    System.out.println(seller.reviews);
                    System.out.println(seller.getRating());
                }
                case 4 -> {

                }
                default -> flag = false;
            }
        }
    }

}
