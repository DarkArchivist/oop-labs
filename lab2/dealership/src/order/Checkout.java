package order;

public class Checkout {

    private String shippingAddress;
    private double amount;
    private String car;

    public Checkout(String shippingAddress, double amount, String car) {
        this.shippingAddress = shippingAddress;
        this.amount = amount;
        this.car = car;
    }



    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

}
