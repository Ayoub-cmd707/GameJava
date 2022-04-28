package be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components;

public class MovementComponent {
    private  float playerSpeed;
    private  boolean inAir;
    private  float airSpeed;
    private  float gravity;
    private  float jumpSpeed;
    private  float fallSpeedAfterCollision;
    private  boolean isMoving;
    private boolean left,right,jump;
    private int xSpeed;
    public MovementComponent() {
        this.playerSpeed = 2.0f;
        this.inAir = false;
        this.airSpeed = 0.5f;
        this.gravity = 5f;
        this.jumpSpeed = 1f;
        this.fallSpeedAfterCollision = 1f;
        this.isMoving = false;
    }


    public float getPlayerSpeed() {return playerSpeed;}
    public void setPlayerSpeed(float playerSpeed) {this.playerSpeed = playerSpeed;}
    public boolean isInAir() {return inAir;}
    public void setInAir(boolean inAir) {this.inAir = inAir;}
    public float getAirSpeed() {return airSpeed;}
    public void setAirSpeed(float airSpeed) {this.airSpeed = airSpeed;}
    public float getGravity() {return gravity;}
    public void setGravity(float gravity) {this.gravity = gravity;}
    public float getJumpSpeed() {return jumpSpeed;}
    public void setJumpSpeed(float jumpSpeed) {this.jumpSpeed = jumpSpeed;}
    public float getFallSpeedAfterCollision() {return fallSpeedAfterCollision;}
    public void setFallSpeedAfterCollision(float fallSpeedAfterCollision) {this.fallSpeedAfterCollision = fallSpeedAfterCollision;}
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
