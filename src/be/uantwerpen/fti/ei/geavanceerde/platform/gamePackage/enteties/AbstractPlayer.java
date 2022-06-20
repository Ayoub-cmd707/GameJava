package be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.enteties;

import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components.MovementComponent;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components.PositioningComponent;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Drawable;

public abstract class AbstractPlayer implements Drawable {

    private final PositioningComponent positionComponent;
    private final MovementComponent movementComponent;
    private AbstractInput.Inputs input;

    public AbstractPlayer(int x, int y , int width, int height){
        this.positionComponent = new PositioningComponent(x,y,height,width);
        this.movementComponent = new MovementComponent();
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
