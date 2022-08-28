package be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Systems;

import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components.CollisionComponent;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components.LevelComponent;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components.MovementComponent;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components.PositioningComponent;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.utilities.Maps;

import java.util.Map;

public class Movement {
    private PositioningComponent positionComponent;
    private MovementComponent movementComponent;
    private LevelComponent levelComponent;
    public Movement(MovementComponent movementComponent, PositioningComponent positionComponent, LevelComponent levelComponent){
        this.movementComponent = movementComponent;
        this.positionComponent = positionComponent;
        this.levelComponent = levelComponent;
        movementComponent.setInAir(true);
        movementComponent.setxSpeed(4);
    }

    private void updateMovement(){
        movementComponent.setMoving(false);

        if (movementComponent.isJump()){
            jump();

            movementComponent.setJump(false);
        }
//        if(movementComponent.isLeft()){
//            if(!CollisionDetection.Move(positionComponent.x -5 , positionComponent.y , 64,64, Maps.map1)){
//                movementComponent.setLeft(false);
//                System.out.println("collsioion van links !Uasb");
//                positionComponent.x = positionComponent.getX();
//                movementComponent.setxSpeed(0);
//            }
//
//
//            positionComponent.x -= movementComponent.getxSpeed();
//            positionComponent.setX(positionComponent.x);
//        }else if(movementComponent.isRight()){
//        if(!CollisionDetection.Move(positionComponent.x, positionComponent.y, 64,64, Maps.map1)){
//            movementComponent.setRight(false);
//            movementComponent.setxSpeed(0);
//            System.out.println("collsioion van rechts !Uasb");
//            positionComponent.x = positionComponent.getX();
//        }
//
//            positionComponent.x +=movementComponent.getxSpeed();;
//            positionComponent.setX(positionComponent.x);
//
//
//        }else {
//            movementComponent.setLeft(false);
//            movementComponent.setRight(false);
//            movementComponent.setJump(false);
//            positionComponent.x = positionComponent.getX();
//            movementComponent.setxSpeed(4);
//        }


        if(!movementComponent.isInAir()){
            if(!CollisionDetection.IsEntityOnFloor((int)positionComponent.x,(int)positionComponent.y,(int)positionComponent.hitboxWidth,(int)positionComponent.hitboxHeight)){
                movementComponent.setInAir(true);
            }
        }

        if(movementComponent.isInAir()){
            if(CollisionDetection.Move(positionComponent.x, (positionComponent.y + MovementComponent.airSpeed), 64, 64, Maps.maps[levelComponent.getLevel()])){;
                positionComponent.y += MovementComponent.airSpeed;
                MovementComponent.airSpeed += movementComponent.getGravity();
                updateXPos(movementComponent.getxSpeed(),64,64);
            }
            else {
                positionComponent.y = CollisionDetection.GetEntityYPosUnderRoofOrAboveFloor((int)positionComponent.x,(int)positionComponent.y,(int)positionComponent.hitboxWidth, (int)positionComponent.hitboxHeight, (int) MovementComponent.airSpeed);
                if (MovementComponent.airSpeed >0 ){
                    movementComponent.setInAir(false);
                    MovementComponent.airSpeed = 0;
                }else{
                    MovementComponent.airSpeed = 0.5f;
                }
                updateXPos(movementComponent.getxSpeed(),64,64);
            }
        }
        updateXPos(movementComponent.getxSpeed(),64,64);
        movementComponent.setMoving(true);


    }
    private void updateXPos(float xSpeed, int width, int height){
        if(CollisionDetection.Move(positionComponent.x+xSpeed,positionComponent.y, (int) positionComponent.hitboxWidth, (int) positionComponent.hitboxHeight, Maps.maps[levelComponent.getLevel()])){
            if(movementComponent.isLeft())
                positionComponent.x -= xSpeed;
            else if(movementComponent.isRight())
                positionComponent.x += xSpeed;
        }
        else{positionComponent.x = CollisionDetection.GetEntityPosNextToWall((int)positionComponent.x,(int)positionComponent.y, width, height, xSpeed);}
    }

    public void jump(){
        if(movementComponent.isInAir()){return;}
        movementComponent.setInAir(true);

        MovementComponent.airSpeed  = movementComponent.getJumpSpeed();
        positionComponent.y = CollisionDetection.GetEntityYPosUnderRoofOrAboveFloor((int)positionComponent.x,(int)positionComponent.y,(int)positionComponent.hitboxWidth, (int)positionComponent.hitboxHeight, (int) MovementComponent.airSpeed);

    }






    public void update() { updateMovement(); }
}

