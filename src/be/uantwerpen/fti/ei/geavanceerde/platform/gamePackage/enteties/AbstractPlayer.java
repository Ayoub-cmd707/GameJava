package be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.enteties;

import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components.CollisionComponent;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components.LevelComponent;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components.MovementComponent;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components.PositioningComponent;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Drawable;

public abstract class AbstractPlayer implements Drawable {

    private final PositioningComponent positionComponent;
    private final MovementComponent movementComponent;
    private final CollisionComponent collisionComponent;
    private final LevelComponent levelComponent;
    private AbstractInput.Inputs input;

    public AbstractPlayer(int x, int y , int width, int height){
        positionComponent = new PositioningComponent(x,y,height,width);
        movementComponent = new MovementComponent();
        collisionComponent = new CollisionComponent(x,y,width,height);
        levelComponent = LevelComponent.getInstance();
    }


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

    public void setDirection(AbstractInput.Inputs input) {
        this.input = input;
    }


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
