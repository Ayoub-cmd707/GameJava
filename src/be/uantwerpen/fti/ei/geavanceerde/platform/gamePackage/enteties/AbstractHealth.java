package be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.enteties;

import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components.HealthComponent;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Drawable;

public abstract class AbstractHealth implements Drawable {
    private HealthComponent healthComponent;

    public AbstractHealth(HealthComponent healthComponent) {
        this.healthComponent = healthComponent;
    }

    public int GetHealth(){
        return healthComponent.getHealth();
    }
}
