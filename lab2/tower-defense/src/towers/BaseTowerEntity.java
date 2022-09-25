package towers;

public abstract class BaseTowerEntity {

    private static String name;
    private static String description;

    private static int goldCost;
    private static int lumberCost;
    private static int resourcesCost; // how many resources it takes

    private static int xUnits; // the space it takes
    private static int yUnits;

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
    // TODO : Double check tower props and restructure if needed be.
}
