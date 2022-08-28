package be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components;

public class BonusComponent {
    private int bonusCoins;
    private boolean bonusActivation;

    public BonusComponent() {
        bonusCoins = 0;
        bonusActivation = false;
    }

    public int getBonusCoins() {
        return bonusCoins;
    }

    public void setBonusCoins(int bonusDiamants) {
        this.bonusCoins = bonusDiamants;
    }

    public boolean isBonusActivation() {
        return bonusActivation;
    }

    public void setBonusActivation(boolean bonusActivation) {
        this.bonusActivation = bonusActivation;
    }
}
