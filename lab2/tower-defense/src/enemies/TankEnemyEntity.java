package enemies;

public class TankEnemyEntity extends BaseEnemyEntity {

    public TankEnemyEntity(long bonusArmor) {
        super("Tank", 0.05, 150, 1500, 5, 25, 100, 10);
        this.bonusArmor = bonusArmor;
    }

    private final int raiseShieldCooldown = 25 * 1000;
    private boolean isRaiseShieldAvailable = true;
    private final double bonusArmor;

    private static final int dispelCooldown = 30 * 1000; // seconds -> milliseconds, type: basic
    private boolean isDispelAvailable = true;

    public void raiseShield() {
        if (!isRaiseShieldAvailable) {
            System.out.println("Spell not ready yet");
            return;
        }
        isRaiseShieldAvailable = false;
        double defaultArmor = getArmor();
        setArmor(defaultArmor + bonusArmor);

        timer.schedule(wrap(() -> {
            isRaiseShieldAvailable = true;
            setArmor(defaultArmor);
        }), raiseShieldCooldown);
    }

    public void dispel() {
        if (!isDispelAvailable && (this.isRooted() || this.isSlowed())) {
            System.out.println("Spell not ready yet");
            return;
        }
        isDispelAvailable = false;
        setSlowed(false);
        setRooted(false);

        timer.schedule(wrap(() -> this.isDispelAvailable = true), dispelCooldown);
    }

    public int getRaiseShieldCooldown() {
        return raiseShieldCooldown;
    }

    public boolean isRaiseShieldAvailable() {
        return isRaiseShieldAvailable;
    }

    public double getBonusArmor() {
        return bonusArmor;
    }

    public boolean isDispelAvailable() {
        return isDispelAvailable;
    }
}
