package be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components;
/**
 * LevelComponent
 * @author Ayoub Aouraghe
 * */
public class LevelComponent {
    private int level;
    private boolean nextLevel;
    private static LevelComponent levelComponent_instance = null;

    /**
     * LevelComponent
     */
    private  LevelComponent() {
        nextLevel = false;
        level = 0;

    }

    /**
     * Singelton so i create only one levelmanager
     * @return
     */
    public static LevelComponent getInstance(){
        if(levelComponent_instance == null)
            levelComponent_instance =new LevelComponent();

        return levelComponent_instance;
    }

    /**
     * getters and setters
     * @return
     */
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }


}
