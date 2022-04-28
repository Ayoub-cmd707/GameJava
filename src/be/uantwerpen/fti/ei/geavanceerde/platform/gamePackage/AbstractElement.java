package be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage;

public abstract class AbstractElement implements Drawable {
    private int x;
    private int y;

    public AbstractElement(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }
    public int getY() { return y; }

    public abstract void draw();
}
