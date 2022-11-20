package dealership.model;

public class FuelTank {
    private final double volume;
    private final double level;

    public FuelTank(double volume, double level) {
        this.volume = volume;
        this.level = level;
    }


    @Override
    public String toString() {
        return "{" +
                "volume=" + volume +
                ", level=" + level +
                '}';
    }
}
