package towers;

import types.DamageType;

public class AttackTowerEntity extends BaseTowerEntity {

    private static DamageType damageType;
    private static double damage;
    public AttackTowerEntity(DamageType damageType, double damage) {
        super("Attack", "Attacking tower...", 15, 0, 2, 2, 2);
        AttackTowerEntity.damageType = damageType;
        AttackTowerEntity.damage = damage;
    }
    // TODO : Add behaviour ( for eg. passive abilities, auto-casted spells probably)
}
