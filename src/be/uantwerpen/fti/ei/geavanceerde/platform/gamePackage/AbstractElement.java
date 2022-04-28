package be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage;

import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components.MovementComponent;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components.PositionComponent;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.enteties.AbstractInput;

public abstract class AbstractElement implements Drawable {
    private final PositionComponent positionComponent;
    private final MovementComponent movementComponent;
    private AbstractInput.Inputs input;

    public AbstractElement(int x, int y , int width, int height){
        this.positionComponent = new PositionComponent(x,y,height,width);
        this.movementComponent = new MovementComponent();
    }


    public PositionComponent getPosition(){
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
