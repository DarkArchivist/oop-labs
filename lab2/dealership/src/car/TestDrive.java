package car;

import persons.Buyer;
import persons.Seller;

import java.util.Date;

public class TestDrive {

    private Date date;

    private double duration;

    private Buyer buyer;

    private Seller seller;

    private Car car;

    public TestDrive(Date date, double duration, Buyer buyer, Seller seller, Car car) {
        this.date = date;
        this.duration = duration;
        this.buyer = buyer;
        this.seller = seller;
        this.car = car;
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
