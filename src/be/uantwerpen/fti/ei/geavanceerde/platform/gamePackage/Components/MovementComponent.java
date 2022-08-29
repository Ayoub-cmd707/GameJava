package be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components;
/**
 * MovementComponent
 * @author Ayoub Aouraghe
 * */
public class MovementComponent {


    private  boolean inAir;
    public static float airSpeed;
    private  float gravity;
    private  float jumpSpeed;
    private  float fallSpeedAfterCollision;
    private  boolean isMoving;
    private boolean left,right,jump;
    private int xSpeed;

    /**
     * MovementComponent
     */
    public MovementComponent() {
        airSpeed = 0f;
        this.inAir = false;
        this.gravity = 1.5f;
        this.jumpSpeed = -15f;
        this.fallSpeedAfterCollision = 1f;
        this.isMoving = false;

    }


    /**
     * getters and setters
     * @return
     */
    public boolean isInAir() {return inAir;}
    public void setInAir(boolean inAir) {this.inAir = inAir;}

    public float getGravity() {return gravity;}

    public float getJumpSpeed() {return jumpSpeed;}

    public boolean isMoving() {return isMoving;}
    public void setMoving(boolean moving) {isMoving = moving;}
    public boolean isLeft() {return left;}
    public void setLeft(boolean left) {this.left = left;}
    public boolean isRight() {return right;}
    public void setRight(boolean right) {this.right = right;}
    public boolean isJump() {return jump;}
    public void setJump(boolean jump) {this.jump = jump;}
    public int getxSpeed() {return xSpeed;}
    public void setxSpeed(int xSpeed) {this.xSpeed = xSpeed;}
}
