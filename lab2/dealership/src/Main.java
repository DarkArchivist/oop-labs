import autoservice.model.Autoservice;
import dealership.model.Dealership;
import util.View;

import java.util.ArrayList;

import static util.Generator.generateBankAccount;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Autoservice autoservice = new Autoservice("8",
                "9-5",
                13,
                generateBankAccount(0, 100000, "Autoservice"));

        Dealership dealership = new Dealership("8",
                "9-5",
                13,
                generateBankAccount(150000, 1000000, "Dealership"),
                new ArrayList<>(),
                new ArrayList<>());

        View view = new View(dealership, autoservice);
        view.init();
    }
}
