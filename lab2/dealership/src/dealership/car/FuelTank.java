package dealership.car;

import common.base.BaseEntity;

public class FuelTank extends BaseEntity {
    private final double volume;
    private double level;

    public FuelTank(double volume, double level) {
        this.volume = volume;
        this.level = level;
    }

    public void consume(double liters) {
        level -= liters;
    }

    public void fill(double liters) {
        if (level + liters > volume) {
            throw new RuntimeException("Overflow");
        }
        level += liters;
    }

    public double getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return "{" +
                "volume=" + volume +
                ", level=" + level +
                '}';
    }
}
