package be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components;

public class HealthComponent {

    private boolean damageTaken;
    private int health = 3;
    public HealthComponent() {
        damageTaken = false;

    }

    public boolean isDamageTaken() {
        return damageTaken;
    }

    public void setDamageTaken(boolean damageTaken) {
        this.damageTaken = damageTaken;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
