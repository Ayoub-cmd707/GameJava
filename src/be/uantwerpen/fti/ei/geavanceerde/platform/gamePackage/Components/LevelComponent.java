package be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components;

public class LevelComponent {
    private int level;
    private boolean nextLevel;
    public LevelComponent() {
        nextLevel = false;
        level = 0;

    }



    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isNextLevel() {
        return nextLevel;
    }

    public void setNextLevel(boolean nextLevel) {
        this.nextLevel = nextLevel;
    }
}
