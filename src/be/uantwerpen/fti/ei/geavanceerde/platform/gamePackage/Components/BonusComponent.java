package be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components;

public class BonusComponent {
    private int bonusDiamants;
    private boolean bonusActivation;

    public BonusComponent() {
       bonusDiamants = 0;
       bonusActivation = false;
    }

    public int getBonusDiamants() {
        return bonusDiamants;
    }

    public void setBonusDiamants(int bonusDiamants) {
        this.bonusDiamants = bonusDiamants;
    }

    public boolean isBonusActivation() {
        return bonusActivation;
    }

    public void setBonusActivation(boolean bonusActivation) {
        this.bonusActivation = bonusActivation;
    }
}
