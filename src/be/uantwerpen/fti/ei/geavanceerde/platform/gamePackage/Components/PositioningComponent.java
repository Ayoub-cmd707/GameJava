package be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components;
/**
 * PositioningComponent
 * @author Ayoub Aouraghe
 * */
public class PositioningComponent {

    public float x;
    public float y;
    public float hitboxWidth;
    public float hitboxHeight;

    /**
     * PositioningComponent
     * @param x
     * @param y
     * @param hitboxH
     * @param hitboxW
     */
    public PositioningComponent(int x, int y, int hitboxH, int hitboxW){
        this.x = x;
        this.y = y;
        this.hitboxHeight = hitboxH;
        this.hitboxWidth = hitboxW;
    }

    /**
     * getters and setters
     * @return
     */
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
}
