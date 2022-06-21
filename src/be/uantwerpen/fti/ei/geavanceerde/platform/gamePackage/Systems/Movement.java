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

        if (movementComponent.isJump()){
            jump();
            movementComponent.setJump(false);


        }
        if(movementComponent.isLeft()){
            if(!CollisionDetection.Move(positionComponent.x -5 , positionComponent.y , 64,64, Maps.map1)){
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
            movementComponent.setJump(false);
        positionComponent.x = positionComponent.getX();
        movementComponent.setxSpeed(4);
    }


            //System.out.println("x waarde "+ positionComponent.x );
        if(!movementComponent.isInAir()){
            if(!CollisionDetection.IsEntityOnFloor((int)positionComponent.x,(int)positionComponent.y,(int)positionComponent.hitboxWidth,(int)positionComponent.hitboxHeight)){
                movementComponent.setInAir(true);
            }
        }

        if(movementComponent.isInAir()){
//            System.out.println("is in air " + movementComponent.isInAir());
//            System.out.println("ik ben in de lucht");
//            System.out.println("airspeed = " + MovementComponent.airSpeed);
            if(CollisionDetection.Move(positionComponent.x, (positionComponent.y + MovementComponent.airSpeed), 64, 64, Maps.map1)){
//                System.out.println("voor y = "+positionComponent.y);
                positionComponent.y += MovementComponent.airSpeed;
                MovementComponent.airSpeed += movementComponent.getGravity();
//                System.out.println("na y = "+positionComponent.y);
//                System.out.println("airspeed = "+MovementComponent.airSpeed);

            }
            else {
                positionComponent.y = CollisionDetection.GetEntityYPosUnderRoofOrAboveFloor((int)positionComponent.x,(int)positionComponent.y,(int)positionComponent.hitboxWidth, (int)positionComponent.hitboxHeight, (int) MovementComponent.airSpeed);
                if (MovementComponent.airSpeed >0 ){
                    System.out.println("airspeed is groterdan bij vallen");
                    movementComponent.setInAir(false);
                    MovementComponent.airSpeed = 0;
                }else{
                    System.out.println("airspeed is 0.5f");
                    MovementComponent.airSpeed = 0.5f;
                }

            }
        }
        System.out.println("airspeed = "+MovementComponent.airSpeed );
        movementComponent.setMoving(true);


    }


    public void jump(){
        if(movementComponent.isInAir()){return;}
        movementComponent.setInAir(true);

        MovementComponent.airSpeed  = movementComponent.getJumpSpeed();
        positionComponent.y = CollisionDetection.GetEntityYPosUnderRoofOrAboveFloor((int)positionComponent.x,(int)positionComponent.y,(int)positionComponent.hitboxWidth, (int)positionComponent.hitboxHeight, (int) MovementComponent.airSpeed);

    }






    public void update() { updateMovement(); }
}

