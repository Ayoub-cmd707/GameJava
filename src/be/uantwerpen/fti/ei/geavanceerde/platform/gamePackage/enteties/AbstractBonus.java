package be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.enteties;

import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components.BonusComponent;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Drawable;
/**
 * AbstractBonus
 * @author Ayoub Aouraghe
 * */
public abstract class AbstractBonus implements Drawable {
    private BonusComponent bonusComponent;

    /**
     * AbstractBonus
     * @param bonusComponent
     */
    public AbstractBonus(BonusComponent bonusComponent){
        this.bonusComponent = bonusComponent;
    }

    /**
     * getter
     * @return
     */
    public int GetPoints(){
        return bonusComponent.getBonusCoins();
    }
}
