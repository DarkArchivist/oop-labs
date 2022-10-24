package dealership.car;

import common.base.BaseEntity;
import dealership.employees.Buyer;
import dealership.employees.Seller;

import java.util.Date;

public class TestDrive extends BaseEntity {

    private Date date;

    private double duration;

    private Buyer buyer;

    private Seller seller;

    private final Car car;

    public TestDrive(Date date, double duration, Buyer buyer, Seller seller, Car car) {
        this.date = date;
        this.duration = duration;
        this.buyer = buyer;
        this.seller = seller;
        this.car = car;

        this.car.setStatus(CarStatus.TEST_DRIVE);
    }

    public void finishTestDrive(TestDrive testDrive) {
        testDrive.car.setStatus(CarStatus.ACTIVE);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }
}
