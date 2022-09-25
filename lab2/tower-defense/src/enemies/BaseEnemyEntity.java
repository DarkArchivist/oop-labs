package enemies;

import mechanics.DamageType;

import java.util.Timer;
import java.util.TimerTask;

public abstract class BaseEnemyEntity {
    private static String name;
    private static double speed;

    private static int reward;
    private static int health;
    private static double armor;

    private static double resistance;
    private static int mana;
    private static int damage;

    private boolean alive = true;

    private boolean rooted = false;
    private boolean stunned = false;

    private boolean slowed = false;

//    public Direction enemyDirection;
//    private int[][] possibleLocations;
//
//    private float posX;
//    private float posY;
    Timer timer = new Timer();

    public BaseEnemyEntity(String name,
                           double speed,
                           int reward,
                           int health,
                           double armor,
                           double resistance,
                           int mana,
                           int damage
    ) {
        BaseEnemyEntity.name = name;
        BaseEnemyEntity.speed = speed;
        BaseEnemyEntity.reward = reward;
        BaseEnemyEntity.health = health;
        BaseEnemyEntity.armor = armor;
        BaseEnemyEntity.resistance = resistance;
        BaseEnemyEntity.mana = mana;
        BaseEnemyEntity.damage = damage;
//        posX = possibleLocations[0][0];
//        posY = possibleLocations[0][1];
    }

    static TimerTask wrap(Runnable r) {
        return new TimerTask() {
            @Override
            public void run() {
                r.run();
            }
        };
    }

    public void move(int x, int y) {
        /*
        Need to do game logic for instance when its x units to the wall to change the direction of the given enemy unit
         */
    }

    public void takeDamage(DamageType type, double damage) {
        switch (type) {
            case PURE -> health -= damage;
            case MAGIC -> health -= damage  * (100 - resistance) / 100;
            case PHYSICAL -> health -= damage * (100 - armor) / 100;
        }
    }

    public void root(long duration) {
        this.rooted = true;
        timer.schedule(wrap(() -> this.rooted = false), duration);
    }

    public void stun(long duration) {
        this.stunned = true;
        timer.schedule(wrap(() -> this.stunned = false), duration);
    }

    public void slow(double slowRatio, long duration) {
        double currentSpeed = speed;
        timer.schedule(wrap(() -> speed = speed * slowRatio / 100), duration);
    }

    public static String getName() {
        return name;
    }

    public static double getSpeed() {
        return speed;
    }

    public static int getReward() {
        return reward;
    }

    public static int getHealth() {
        return health;
    }

    public static int getMana() {
        return mana;
    }

    public static int getDamage() {
        return damage;
    }

    public boolean isAlive() {
        return alive;
    }

    public boolean isRooted() {
        return rooted;
    }

    public boolean isStunned() {
        return stunned;
    }

    public static double getArmor() {
        return armor;
    }

    public static double getResistance() {
        return resistance;
    }

    public void setRooted(boolean rooted) {
        this.rooted = rooted;
    }

    public void setStunned(boolean stunned) {
        this.stunned = stunned;
    }

    public static void setSpeed(double speed) {
        BaseEnemyEntity.speed = speed;
    }

    public static void setArmor(double armor) {
        BaseEnemyEntity.armor = armor;
    }

    public static void setResistance(double resistance) {
        BaseEnemyEntity.resistance = resistance;
    }

    public static void setMana(int mana) {
        BaseEnemyEntity.mana = mana;
    }

    public boolean isSlowed() {
        return slowed;
    }

    public static void setHealth(int health) {
        BaseEnemyEntity.health = health;
    }

    public void setSlowed(boolean slowed) {
        this.slowed = slowed;
    }
//    public float getPosX() {
//        return posX;
//    }
//
//    public float getPosY() {
//        return posY;
//    }
}
