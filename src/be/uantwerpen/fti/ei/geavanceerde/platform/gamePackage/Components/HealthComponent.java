package be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components;

/**
 * HealthComponent
 * @author Ayoub Aouraghe
 * */
public class HealthComponent {

    private boolean damageTaken;
    private int health = 3;

    /**
     * HealthComponent
     */
    public HealthComponent() {
        damageTaken = false;

    }

    /**
     * getters and setters
     * @return
     */

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
