package enemies;

public class BossEnemyEntity extends BaseEnemyEntity {
    public BossEnemyEntity() {
        super("Boss", 0.1, 1000, 2500, 30, 15, 1000, 25);
    }
    // TODO: Abilities

    private static final int dispelCooldown = 30 * 1000; // seconds -> milliseconds, type: strong
    private boolean isDispelAvailable = true;

    private static final int heal = 100;
    private static final int healCooldown = 60 * 1000; // seconds -> milliseconds
    private boolean isHealAvailable = true;

    public void dispel() {
        if ((this.isRooted() || this.isSlowed()) && !this.isStunned() && isDispelAvailable) {
            setRooted(false);
            this.isDispelAvailable = false;
            timer.schedule(wrap(() -> this.isDispelAvailable = true), dispelCooldown);
        }
    }

    public void heal() {
        int currentHealth = getHealth();
        if (currentHealth >= 2500) {
            return;
        }
        setHealth(currentHealth + heal);
        this.isHealAvailable = false;
        timer.schedule(wrap(() -> this.isHealAvailable = true), healCooldown);
    }
}
