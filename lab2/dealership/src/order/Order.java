package order;

import base.BaseEntity;
import car.Car;

public class Order extends BaseEntity {
    protected final Car car;

    public Order(Car car) {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }
}
