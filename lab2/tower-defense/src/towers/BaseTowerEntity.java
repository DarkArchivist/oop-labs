package towers;

import java.util.Timer;
import java.util.TimerTask;

public abstract class BaseTowerEntity {

    private static String name;
    private static String description;

    private static int goldCost;
    private static int lumberCost;
    private static int resourcesCost; // how many resources it takes

    private static int xUnits; // the space it takes
    private static int yUnits;

    Timer timer = new Timer();

    public BaseTowerEntity(
            String name,
            String description,
            int goldCost,
            int lumberCost,
            int resourcesCost,
            int xUnits,
            int yUnits
    ) {
        BaseTowerEntity.name = name;
        BaseTowerEntity.description = description;
        BaseTowerEntity.goldCost = goldCost;
        BaseTowerEntity.lumberCost = lumberCost;
        BaseTowerEntity.resourcesCost = resourcesCost;
        BaseTowerEntity.xUnits = xUnits;
        BaseTowerEntity.yUnits = yUnits;
    }

    static TimerTask wrap(Runnable r) {
        return new TimerTask() {
            @Override
            public void run() {
                r.run();
            }
        };
    }

    public static String getName() {
        return name;
    }

    public static String getDescription() {
        return description;
    }

    public static int getGoldCost() {
        return goldCost;
    }

    public static int getLumberCost() {
        return lumberCost;
    }

    public static int getResourcesCost() {
        return resourcesCost;
    }

    public static int getxUnits() {
        return xUnits;
    }

    public static int getyUnits() {
        return yUnits;
    }

    // TODO : Double check tower props and restructure if needed be.
}
