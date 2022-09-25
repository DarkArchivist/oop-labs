package enemies;

public class BaseNeutralEntity extends BaseEnemyEntity {
    public BaseNeutralEntity(int currentWave,
                             int freezeDuration,
                             int freezeCooldown,
                             int speedUpDuration,
                             int speedUpCooldown,
                             int speedMultiplier
    ) {
        super("Boss", 1, 1000, 5000, 0, 0, 0, 0);
        this.lumberPerHit = currentWave * 2 + 1;
        this.freezeDuration = freezeDuration;
        this.freezeCooldown = freezeCooldown;
        this.speedUpDuration = speedUpDuration;
        this.speedUpCooldown = speedUpCooldown;
        this.speedMultiplier = speedMultiplier;
    }

    private static final int goldPerHit = 20;

    private int lumberPerHit;

    private final int freezeDuration;
    private boolean isFreezeAvailable = true;
    private final int freezeCooldown;


    private final int speedMultiplier;
    private final int speedUpDuration;
    private boolean isSpeedUpAvailable = true;
    private final int speedUpCooldown;

    void freeze() {
        if (!isFreezeAvailable) {
            return;
        }

        this.setRooted(true);
        isFreezeAvailable = false;
        timer.schedule(wrap(() -> this.setRooted(false)), freezeDuration);

        timer.schedule(wrap(() -> this.isFreezeAvailable = true), freezeCooldown);
    }

    void speedUp() {
        if (!isSpeedUpAvailable) {
            return;
        }
        this.isSpeedUpAvailable = false;
        double currentSpeed = getSpeed();
        setSpeed(currentSpeed * speedMultiplier);

        timer.schedule(wrap(() -> isSpeedUpAvailable = true), speedUpCooldown);
        timer.schedule(wrap(() -> setSpeed(currentSpeed)), speedUpDuration);

    }
}
