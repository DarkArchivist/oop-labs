package enemies;

public class BossEnemyEntity extends BaseEnemyEntity {
    public BossEnemyEntity() {
        super("Boss", 0.1, 1000, 2500, 30, 15, 1000, 25);
    }

    private static final int dispelCooldown = 30 * 1000; // seconds -> milliseconds, type: strong
    private boolean isDispelAvailable = true;

    private static final int heal = 100;
    private static final int healCooldown = 60 * 1000; // seconds -> milliseconds
    private boolean isHealAvailable = true;

    private static final int healthShield = 250; // applies dispel on use
    private static final int healthShieldCooldown = 60 * 1000;
    private boolean isHealthShieldAvailable = true;


    public void dispel() {
        if ((this.isStunned() || !isDispelAvailable) && (this.isRooted() || this.isSlowed())) {
            return;
        }
        setRooted(false);
        this.isDispelAvailable = false;
        timer.schedule(wrap(() -> this.isDispelAvailable = true), dispelCooldown);
    }

    public void heal() {
        int currentHealth = getHealth();
        if (!this.isHealAvailable || currentHealth >= 2500) {
            return;
        }

        setHealth(currentHealth + heal);
        this.isHealAvailable = false;
        timer.schedule(wrap(() -> this.isHealAvailable = true), healCooldown);
    }

    public void useHealthShield() {
        if (!isHealthShieldAvailable || getHealth() >= 2500) {
            return;
        }
        if (this.isRooted() || this.isSlowed()) {
            setRooted(false);
            setSlowed(false);
        }
        setHealth(getHealth() - healthShield);
        this.isHealthShieldAvailable = false;

        timer.schedule(wrap(() -> {
            if (getHealth() <= 2250) {
                setHealth(getHealth() - healthShield);
            }
            this.isHealthShieldAvailable = true;
        }), healthShieldCooldown);
    }

    public boolean isDispelAvailable() {
        return isDispelAvailable;
    }

    public boolean isHealAvailable() {
        return isHealAvailable;
    }

    public boolean isHealthShieldAvailable() {
        return isHealthShieldAvailable;
    }
}
