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
        movementComponent.setInAir(true);
    }

    private void updateMovement(){

        movementComponent.setMoving(false);


        if(movementComponent.isLeft()){
            if(!CollisionDetection.Move(positionComponent.x -1, positionComponent.y , 64,64, Maps.map1)){
                movementComponent.setLeft(false);
                positionComponent.x = positionComponent.getX();
                movementComponent.setxSpeed(0);
                movementComponent.setRight(true);
                System.out.println("ik zit in de isLeft");
            }
            positionComponent.x -= movementComponent.getxSpeed();
            positionComponent.setX(positionComponent.x);
        }else if(movementComponent.isRight()){
            if(!CollisionDetection.Move(positionComponent.x+1, positionComponent.y, 64,64, Maps.map1)){
                movementComponent.setRight(false);
                movementComponent.setxSpeed(0);
                positionComponent.x = positionComponent.getX();
                movementComponent.setLeft(true);
                System.out.println("ik zit in de isRight");
            }
            positionComponent.x +=movementComponent.getxSpeed();
            positionComponent.setX(positionComponent.x);
        }else {
            movementComponent.setLeft(false);
            movementComponent.setRight(false);
            positionComponent.x = positionComponent.getX();
            movementComponent.setxSpeed(7);
        }
        if(!movementComponent.isInAir()){
            if(!CollisionDetection.IsEntityOnFloor((int)positionComponent.x,(int)positionComponent.y,64,64,Maps.map1)){
                System.out.println("Dit is een check voor in de lucht");
                movementComponent.setInAir(true);
            }
        }

        if(movementComponent.isInAir()){
            System.out.println("is in air " + movementComponent.isInAir());
            System.out.println("ik ben in de lucht");
            System.out.println("airspeed = " + MovementComponent.airSpeed);
            if(CollisionDetection.Move(positionComponent.x, (positionComponent.y + MovementComponent.airSpeed), 64, 64, Maps.map1)){
                System.out.println("voor y = "+positionComponent.y);
                positionComponent.y += 10;
                MovementComponent.airSpeed += movementComponent.getGravity();
                System.out.println("na y = "+positionComponent.y);
                System.out.println("airspeed = "+MovementComponent.airSpeed);
                System.out.println("ik ben in de lucht");

            } else{
                System.out.println("ik ben in else van isInAir");
                positionComponent.y = CollisionDetection.GetEntityYPosUnderRoofOrAboveFloor((int) positionComponent.x, (int) positionComponent.y,64,64, MovementComponent.airSpeed);
                if(MovementComponent.airSpeed > 0){
                    movementComponent.setInAir(false);
                    MovementComponent.airSpeed = 0.5f;
                }
                else{
                    MovementComponent.airSpeed = 20.5f;
                }

            }
        }

        movementComponent.setMoving(true);
    }







    public void jump(){
        if(movementComponent.isInAir()){
            return;
        }
        movementComponent.setInAir(true);
    }

    public void update() { updateMovement(); }
}

