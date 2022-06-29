package be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components;

public class LevelComponent {
    private int level;
    private boolean nextLevel;
    private static LevelComponent levelComponent_instance = null;
    private  LevelComponent() {
        nextLevel = false;
        level = 0;

    }

    public static LevelComponent getInstance(){
        if(levelComponent_instance == null)
            levelComponent_instance =new LevelComponent();

        return levelComponent_instance;
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
