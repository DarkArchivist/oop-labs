package common.order;

import common.base.BaseEntity;
import dealership.car.Car;

public class Order extends BaseEntity {
    protected final Car car;

    public Order(Car car) {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }
}
