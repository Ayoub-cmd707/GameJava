package be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.enteties;

import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components.*;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Drawable;

import java.util.ArrayList;
/**
 * AbstractPlayer
 * @author Ayoub Aouraghe
 * */
public abstract class AbstractPlayer implements Drawable {

    private final PositioningComponent positionComponent;
    private final MovementComponent movementComponent;
    private final CollisionComponent collisionComponent;
    private final LevelComponent levelComponent;
    private final BonusComponent bonusComponent;
    private final HealthComponent healthComponent;
    private final ArrayList<ProjectileComponent> bulletsComponent;
    private AbstractInput.Inputs input;

    /**
     * AbstractPlayer
     * @param x
     * @param y
     * @param width
     * @param height
     */
    public AbstractPlayer(int x, int y , int width, int height){
        positionComponent = new PositioningComponent(x,y,height,width);
        movementComponent = new MovementComponent();
        collisionComponent = new CollisionComponent(x,y,width,height);
        levelComponent = LevelComponent.getInstance();
        bonusComponent = new BonusComponent();
        healthComponent = new HealthComponent();
        this.bulletsComponent = new ArrayList<>();
    }

    /**
     * Getters and Setters
     * @return
     */
    public PositioningComponent getPosition(){
        return  positionComponent;
    }

    public MovementComponent getMovement(){
        return movementComponent;
    }

    public CollisionComponent getCollisionComponent(){
        return collisionComponent;
    }

    public LevelComponent getLevelComponent() {
        return levelComponent;
    }

    public AbstractInput.Inputs getInput(){
        return input;
    }

    public BonusComponent getBonusComponent(){ return bonusComponent; }

    public HealthComponent getHealthComponent() {
        return healthComponent;
    }

    public void setDirection(AbstractInput.Inputs input) {
        this.input = input;
    }

    /**
     * movements function for letting the player move
     * @param inputs
     */
    public void checkMovement(AbstractInput.Inputs inputs) {

        if (movementComponent.isMoving() && inputs == AbstractInput.Inputs.LEFT) {
            movementComponent.setLeft(true);
            movementComponent.setRight(true);
        } else if (movementComponent.isMoving() && inputs == AbstractInput.Inputs.RIGHT) {
            movementComponent.setRight(true);
            movementComponent.setLeft(false);
        } else if (movementComponent.isMoving() && inputs == AbstractInput.Inputs.JUMP) {
            movementComponent.setJump(true);
        } else {
            movementComponent.setRight(false);
            movementComponent.setLeft(false);
        }
    }




}
