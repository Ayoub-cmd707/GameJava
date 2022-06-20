package be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Systems;

import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components.CollisionComponent;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components.MovementComponent;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components.PositioningComponent;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.utilities.Maps;

public class Movement {
    private PositioningComponent positionComponent;
    private MovementComponent movementComponent;
    public Movement(MovementComponent movementComponent, PositioningComponent positionComponent){
        this.movementComponent = movementComponent;
        this.positionComponent = positionComponent;
    }

    private void updateMovement(){
        movementComponent.setMoving(false);


        if(movementComponent.isLeft()){
            if(!CollisionDetection.Move(positionComponent.x -4 , positionComponent.y , 64,64, Maps.map1)){
                movementComponent.setLeft(false);
                System.out.println("collsioion van links !Uasb");
                positionComponent.x = positionComponent.getX();
                movementComponent.setxSpeed(0);
            }


            positionComponent.x -= movementComponent.getxSpeed();
            positionComponent.setX(positionComponent.x);


        }else if(movementComponent.isRight()){
            if(!CollisionDetection.Move(positionComponent.x, positionComponent.y, 64,64, Maps.map1)){
                movementComponent.setRight(false);
                movementComponent.setxSpeed(0);
                System.out.println("collsioion van rechts !Uasb");
                positionComponent.x = positionComponent.getX();
            }

            positionComponent.x +=movementComponent.getxSpeed();;
            positionComponent.setX(positionComponent.x);


        }else {
            movementComponent.setLeft(false);
            movementComponent.setRight(false);
            positionComponent.x = positionComponent.getX();
            movementComponent.setxSpeed(3);
        }

        //System.out.println("x waarde "+ positionComponent.x );
        movementComponent.setMoving(true);
    }





    public void update() { updateMovement(); }
}

