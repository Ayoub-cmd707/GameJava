package be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.enteties;

import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components.HealthComponent;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Drawable;
/**
 * AbstractHealth
 * @author Ayoub Aouraghe
 * */
public abstract class AbstractHealth implements Drawable {
    private HealthComponent healthComponent;

    /**
     * AbstractHealth
     * @param healthComponent
     */
    public AbstractHealth(HealthComponent healthComponent) {
        this.healthComponent = healthComponent;
    }

    /**
     * Getter
     * @return
     */
    public int GetHealth(){
        return healthComponent.getHealth();
    }
}
