package common.employee;

public class Review {
    public String description;
    public double stars;

    public Review(double stars) {
        this.stars = stars;
    }

    public Review(String description, double stars) {
        this.description = description;
        this.stars = stars;
    }

    @Override
    public String toString() {
        return "\n{" +
                "\ndescription='" + description + '\'' +
                "\n, stars=" + stars +
                '}';
    }
}
