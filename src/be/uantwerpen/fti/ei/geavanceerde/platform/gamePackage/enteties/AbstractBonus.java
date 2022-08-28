package be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.enteties;

import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components.BonusComponent;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Drawable;

public abstract class AbstractBonus implements Drawable {
    private BonusComponent bonusComponent;

    public AbstractBonus(BonusComponent bonusComponent){
        this.bonusComponent = bonusComponent;
    }

    public int GetPoints(){
        return bonusComponent.getBonusCoins();
    }
}
