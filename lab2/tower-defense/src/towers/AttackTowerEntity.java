package towers;

import mechanics.DamageType;

public class AttackTowerEntity extends BaseTowerEntity {
    public AttackTowerEntity(DamageType damageType, double damage, double attackSpeed, double attackRadius) {
        super("Attack", "Attacking tower...", 15, 0, 2, 2, 2);
        AttackTowerEntity.damageType = damageType;
        AttackTowerEntity.damage = damage;
        AttackTowerEntity.attackSpeed = attackSpeed;
        AttackTowerEntity.attackRadius = attackRadius;
    }

    private static DamageType damageType;
    private static double damage;
    private static double attackSpeed;
    private static double attackTime;

    private static double attackRadius;

    private boolean attackOnCooldown = false;

    void attack() {
        long r = (long) (attackSpeed / attackTime);
        long T = 1 / r;
        attackOnCooldown = true;
        this.timer.schedule(wrap(() -> attackOnCooldown = false), T);
    }
    // TODO : Add behaviour ( for eg. passive abilities, auto-casted spells probably)
}
