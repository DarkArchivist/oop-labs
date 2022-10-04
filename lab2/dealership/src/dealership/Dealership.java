package dealership;

import java.util.List;

public class Dealership {

    private String workingHours;
    private String schedule;
    private int breakHour;

    public boolean isOpen = false;
    private List<String> contact;

    private List<String> cars;

    public Dealership(String workingHours, String schedule, int breakHour, List<String> contact, List<String> cars) {
        this.workingHours = workingHours;
        this.schedule = schedule;
        this.breakHour = breakHour;

        this.contact = contact;
        this.cars = cars;
    }

    public void open() {
        this.isOpen = true;
    }

    public void close() {
        this.isOpen = false;
    }

    public void addCar(String car) {
        cars.add(car);
    }

    public void removeCar(String car) {
        if (!cars.contains(car)) {
            System.out.println("Car doesn't exist");
            return;
        }
        cars.remove(car);
    }

    public String getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(String workingHours) {
        this.workingHours = workingHours;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public int getBreakHour() {
        return breakHour;
    }

    public void setBreakHour(int breakHour) {
        this.breakHour = breakHour;
    }


    public List<String> getContact() {
        return contact;
    }

    public void setContact(List<String> contact) {
        this.contact = contact;
    }

//    private String getCars() {
//       StringBuilder sb = new StringBuilder();
//        sb.append("[");
//        for (Car car : cars) {
//            sb.append(car.toString()).append(",\n");
//        }
//
//        sb.append("]");
//        return sb.toString();
//    }

    public void setCars(List<String> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "Dealership{" +
                "workingHours='" + workingHours + '\'' +
                ", schedule='" + schedule + '\'' +
                ", breakHour=" + breakHour +
                ", isOpen=" + isOpen +
                ", contact=" + contact +
                ", cars=" + cars +
                '}';
    }
}

