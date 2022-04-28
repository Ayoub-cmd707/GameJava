package be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Systems;

import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components.MovementComponent;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components.PositionComponent;

public class Movement {
    private PositionComponent positionComponent;
    private MovementComponent movementComponent;
    public Movement(MovementComponent movementComponent, PositionComponent positionComponent){
        this.movementComponent = movementComponent;
        this.positionComponent = positionComponent;
    }

    private void updateMovement(){
        movementComponent.setMoving(false);
        movementComponent.setxSpeed(0);
        if(movementComponent.isJump()){jump();movementComponent.setJump(false);}
        if(movementComponent.isLeft()){
            movementComponent.setxSpeed(-(int)movementComponent.getPlayerSpeed());
            positionComponent.x+=movementComponent.getxSpeed();
        }
        if(movementComponent.isRight()){
            movementComponent.setxSpeed((int)movementComponent.getPlayerSpeed());
            positionComponent.x+=movementComponent.getxSpeed();
        }
        movementComponent.setMoving(true);
    }

    public void jump(){
        if(movementComponent.isInAir()){return;}
        movementComponent.setInAir(true);
        movementComponent.setAirSpeed(movementComponent.getJumpSpeed());
    }

    public void resetPosition(){
        positionComponent.x = 100;
        positionComponent.y = 550;
    }

    public void update() { updateMovement(); }
}

