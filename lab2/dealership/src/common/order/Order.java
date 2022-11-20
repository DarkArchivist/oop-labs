package common.order;

import dealership.model.Car;

public class Order {
    protected final Car car;

    public Order(Car car) {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }
}
