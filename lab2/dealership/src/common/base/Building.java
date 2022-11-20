package common.base;

public abstract class Building {
    protected String workingHours;
    protected String schedule;
    protected int breakHour;

    public boolean isOpen = false;

    public Building(String workingHours, String schedule, int breakHour) {
        this.workingHours = workingHours;
        this.schedule = schedule;
        this.breakHour = breakHour;
    }

    public void open() {
        this.isOpen = true;
    }

    public void close() {
        this.isOpen = false;
    }
}
