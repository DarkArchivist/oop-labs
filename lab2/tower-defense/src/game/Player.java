package game;

public class Player {
    // Basic Player utilities
    private static int gold;
    private static int lumber;
    private static int lives;

    private static int resources;
    private static int maxResources;

    // CONSTANTS
    private static final int STARTING_GOLD = 100;
    private static final int STARTING_LUMBER = 0;
    private static final int STARTING_RESOURCES = 0;
    private static final int STARTING_LIVES = 100;
    private static final int STARTING_MAX_RESOURCES = 12;

    public Player() {
        gold = STARTING_GOLD;
        lumber = STARTING_LUMBER;
        lives = STARTING_LIVES;
        resources = STARTING_RESOURCES;
        maxResources = STARTING_MAX_RESOURCES;
    }

    public void reset() {
        gold = STARTING_GOLD;
        lumber = STARTING_LUMBER;
        lives = STARTING_LIVES;
        resources = STARTING_RESOURCES;
        maxResources = STARTING_MAX_RESOURCES;
    }

    public void addGold() {
        gold++;
    }

    public void removeLife(int damage) {
        lives -= damage;
    }

    public void increaseCurrentResources(int newResources) {
        if (newResources + resources > maxResources) {
            return;
        }
        resources += newResources;
    }

    public void increaseMaxResources(int newResources) {
        maxResources += newResources;
    }

    public static int getGold() {
        return gold;
    }

    public static int getLumber() {
        return lumber;
    }

    public static int getLives() {
        return lives;
    }

    public static int getResources() {
        return resources;
    }

    public static int getMaxResources() {
        return maxResources;
    }
}
