package be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Systems;

import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components.CollisionComponent;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components.LevelComponent;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components.MovementComponent;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components.PositioningComponent;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.utilities.Maps;

import java.util.Map;
/**
 * Movement
 * @author Ayoub Aouraghe
 * */
public class Movement {
    private PositioningComponent positionComponent;
    private MovementComponent movementComponent;
    private LevelComponent levelComponent;

    /**
     * Movement
     * @param movementComponent
     * @param positionComponent
     * @param levelComponent
     */
    public Movement(MovementComponent movementComponent, PositioningComponent positionComponent, LevelComponent levelComponent){
        this.movementComponent = movementComponent;
        this.positionComponent = positionComponent;
        this.levelComponent = levelComponent;
        movementComponent.setInAir(true);
        movementComponent.setxSpeed(4);
    }

    /**
     * updateMovement function
     * updates the movement
     */
    private void updateMovement(){
        movementComponent.setMoving(false);

        if (movementComponent.isJump()){
            jump();

            movementComponent.setJump(false);
        }


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

    /**
     * updateXPos function
     * update of the x-as
     * @param xSpeed
     * @param width
     * @param height
     */
    private void updateXPos(float xSpeed, int width, int height){
        if(CollisionDetection.Move(positionComponent.x+xSpeed,positionComponent.y, (int) positionComponent.hitboxWidth, (int) positionComponent.hitboxHeight, Maps.maps[levelComponent.getLevel()])){
            if(movementComponent.isLeft())
                positionComponent.x -= xSpeed;
            else if(movementComponent.isRight())
                positionComponent.x += xSpeed;
        }
        else{positionComponent.x = CollisionDetection.GetEntityPosNextToWall((int)positionComponent.x,(int)positionComponent.y, width, height, xSpeed);}
    }

    /**
     * jump function
     * jumping function
     */
    public void jump(){
        if(movementComponent.isInAir()){return;}
        movementComponent.setInAir(true);

        MovementComponent.airSpeed  = movementComponent.getJumpSpeed();
        positionComponent.y = CollisionDetection.GetEntityYPosUnderRoofOrAboveFloor((int)positionComponent.x,(int)positionComponent.y,(int)positionComponent.hitboxWidth, (int)positionComponent.hitboxHeight, (int) MovementComponent.airSpeed);

    }


    /**
     * update functions
     */
    public void update() { updateMovement(); }
}

