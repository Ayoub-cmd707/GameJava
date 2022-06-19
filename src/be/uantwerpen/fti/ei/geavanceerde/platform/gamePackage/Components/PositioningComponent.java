package be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components;

public class PositioningComponent {

    public float x;
    public float y;
    public float hitboxWidth;
    public float hitboxHeight;

    public PositioningComponent(int x, int y, int hitboxH, int hitboxW){
        this.x = x;
        this.y = y;
        this.hitboxHeight = hitboxH;
        this.hitboxWidth = hitboxW;
    }
}
