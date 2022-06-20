package be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.enteties;

import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components.CollisionComponent;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components.MovementComponent;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components.PositioningComponent;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Drawable;

public abstract class AbstractPlayer implements Drawable {

    private final PositioningComponent positionComponent;
    private final MovementComponent movementComponent;
    private final CollisionComponent collisionComponent;
    private AbstractInput.Inputs input;

    public AbstractPlayer(int x, int y , int width, int height){
        this.positionComponent = new PositioningComponent(x,y,height,width);
        this.movementComponent = new MovementComponent();
        collisionComponent = new CollisionComponent(x,y,width,height);
    }


    public PositioningComponent getPosition(){
        return  positionComponent;
    }

    public MovementComponent getMovement(){
        return movementComponent;
    }

    public AbstractInput.Inputs getInput(){
        return input;
    }

    public void setDirection(AbstractInput.Inputs input) {
        this.input = input;
    }




}
