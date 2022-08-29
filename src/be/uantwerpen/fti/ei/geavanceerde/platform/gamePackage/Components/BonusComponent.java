package be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components;

/**
 * BonusComponent
 * @author Ayoub Aouraghe
 * */

public class BonusComponent {
    private int bonusCoins;
    private boolean bonusActivation;

    /**
     * BonusComponent
     */
    public BonusComponent() {
        bonusCoins = 0;
        bonusActivation = false;
    }


    /**
     * getters and setters
     */
    public int getBonusCoins() {
        return bonusCoins;
    }

    public void setBonusCoins(int bonusDiamants) {
        this.bonusCoins = bonusDiamants;
    }


}
