package be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Systems;

import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components.*;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Game;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.utilities.Maps;

public class Health {
    private final CollisionComponent collisionComponent;
    private final PositioningComponent positioningComponent;
    private final MovementComponent movementComponent;
    private final HealthComponent healthComponent;
    private final LevelComponent levelComponent;

    public Health(CollisionComponent collisionComponent, PositioningComponent positioningComponent, MovementComponent movementComponent, HealthComponent healthComponent, LevelComponent levelComponent) {
        this.collisionComponent = collisionComponent;
        this.positioningComponent = positioningComponent;
        this.movementComponent = movementComponent;
        this.healthComponent = healthComponent;
        this.levelComponent = levelComponent;
    }

    private void healthSystem(){
        if(healthComponent != null){


            //colision with spikes
            if(!CollisionDetection.DamageWithSpike(positioningComponent.x,positioningComponent.y ,(int)positioningComponent.hitboxWidth,(int)positioningComponent.hitboxWidth, Maps.maps[levelComponent.getLevel()])){
                healthComponent.setHealth(healthComponent.getHealth()-1);
                System.out.println("health is " + healthComponent.getHealth());

                positioningComponent.setX(70);
                positioningComponent.setY(1);
                if (healthComponent.getHealth() == 0){
                    System.out.println(1);
                    System.exit(0);
                    System.out.println(2);
                }


            }

            if(!CollisionDetection.DamageWithSpike(positioningComponent.x +32,positioningComponent.y ,(int)positioningComponent.hitboxWidth,(int)positioningComponent.hitboxWidth, Maps.maps[levelComponent.getLevel()])){
                healthComponent.setHealth(healthComponent.getHealth()-1);
                System.out.println("health is " + healthComponent.getHealth());

                positioningComponent.setX(70);
                positioningComponent.setY(1);
                if (healthComponent.getHealth() == 0){
                    System.out.println(1);
                    System.exit(0);
                    System.out.println(2);
                }


            }

        }
    }
    public void CheckForhealth(){
        healthSystem();
    }

}
