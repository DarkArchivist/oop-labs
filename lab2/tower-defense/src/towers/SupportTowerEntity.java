package towers;

import mechanics.SupportTowerType;

public class SupportTowerEntity extends BaseTowerEntity {
    public SupportTowerEntity(SupportTowerType towerType, int utilsPerMinute) {
        super("Support tower", "Generates resources", 40, 0, 4, 2, 2);
        SupportTowerEntity.towerType = towerType;
        SupportTowerEntity.utilsPerMinute = utilsPerMinute;
    }

    private static SupportTowerType towerType;
    private static int totalUtils = 0; // can be lumber, gold, resources
    private static int utilsPerMinute;

    public void generateUtils() {
        this.timer.schedule(wrap(() -> totalUtils += utilsPerMinute), 60 * 1000);
    }
}
