package be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components;

/**
 * ProjectileComponent
 * @author Ayoub Aouraghe
 * */

public class ProjectileComponent {

    private String type;
    private double x;
    private double y;
    private boolean isActive = true;
    private int hitboxWidth;
    private int hitboxHeight;
    private int r;
    private double dx;
    private double dy;
    private double rad;
    private double speed;
    private int screenWidth;
    private int screenHeight;
    private double angle;

    /**
     * ProjectileComponent
     * @param type
     * @param x
     * @param y
     * @param hitboxWidth
     * @param hitboxHeight
     * @param angle
     * @param speed
     * @param screenWidth
     * @param screenHeight
     * @param r
     */
    public ProjectileComponent(String type,double x,double y,int hitboxWidth,int hitboxHeight,double angle,double speed, int screenWidth, int screenHeight,int r) {

        this.type = type;
        this.x = x;
        this.y = y;
        this.hitboxWidth = hitboxWidth;
        this.hitboxHeight = hitboxHeight;
        this.r = r;
        this.angle = angle;
        this.rad = Math.toRadians(angle);
        this.dx = -Math.sin(rad);
        this.dy = Math.cos(rad);
        this.speed = speed;
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;

    }

    public double getX() {return x;}
    public void setX(double x) {this.x = x;}
    public double getY() {return y;}
    public void setY(double y) {this.y = y;}
    public boolean isActive() {return isActive;}
    public void setActive(boolean active) {isActive = active;}
    public double getDx() {return dx;}
    public double getDy() {return dy;}
    public void setDy(double dy) {this.dy = dy;}
    public double getSpeed() {return speed;}
    public int getScreenWidth() {return screenWidth;}
    public int getScreenHeight() {return screenHeight;}
    public int getR() {return r;}
    public double getAngle() {return angle;}
}
