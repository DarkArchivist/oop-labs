package towers;

import mechanics.DamageType;

public class StunTowerEntity extends BaseTowerEntity {
    public StunTowerEntity(long stunDuration, long stunCooldown, long damage) {
        super("Stun tower", "Stuns enemies in given range", 25, 0, 4, 2, 2);
        this.stunDuration = stunDuration;
        this.stunCooldown = stunCooldown;
        this.damage = damage;
    }

    private final long stunDuration;
    private final long stunCooldown;

    private boolean isStunAvailable = true;
    private final long damage;
    private final DamageType damageType = DamageType.MAGIC;

    void stun() {
        if (!isStunAvailable) {
            return;
        }
        isStunAvailable = false;
        this.timer.schedule(wrap(() -> isStunAvailable = true), stunCooldown); // TODO Damage overtime
    }

    // GETTERS
    public long getStunDuration() {
        return stunDuration;
    }

    public long getStunCooldown() {
        return stunCooldown;
    }

    public boolean isStunAvailable() {
        return isStunAvailable;
    }

    public long getDamage() {
        return damage;
    }

    public DamageType getDamageType() {
        return damageType;
    }
}
