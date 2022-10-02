package order;

import car.Car;

public class Order {
    private final Car car;

    public Order(Car car) {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }
}
