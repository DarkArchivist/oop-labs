package persons;



public class Administrator {

    private final String firstName;
    private final String lastName;

    private final String dealership;

    public Administrator(String firstName, String lastName, String dealership) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dealership = dealership;
    }

    public void open() {}

    public void close() {}

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDealership() {
        return dealership;
    }
}
