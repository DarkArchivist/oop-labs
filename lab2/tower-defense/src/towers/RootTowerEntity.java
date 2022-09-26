package towers;

import mechanics.DamageType;

public class RootTowerEntity extends BaseTowerEntity {
    public RootTowerEntity(long rootDuration, long rootCooldown, long dps) {
        super("Root tower", "Roots all enemies in given range", 10, 0, 1, 2, 2);
        this.rootDuration = rootDuration;
        this.rootCooldown = rootCooldown;
        this.dps = dps;
    }

    private final long rootDuration;
    private final long rootCooldown;

    private boolean isRootAvailable = true;
    private final DamageType damageType = DamageType.MAGIC;

    private final long dps; // damage per second whilst under root effect

    public void root() {
        if (!isRootAvailable) {
            return;
        }
        // TODO Damage logic smth along the lines: enemy.health -= dps * rootDuration
        isRootAvailable = false;
        this.timer.schedule(wrap(() -> isRootAvailable = true), rootCooldown); // TODO DPS logic
    }
}
