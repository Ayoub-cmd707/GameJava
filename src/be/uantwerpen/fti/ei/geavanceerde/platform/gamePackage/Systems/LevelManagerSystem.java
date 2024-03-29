package be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Systems;

import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components.LevelComponent;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components.PositioningComponent;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.utilities.Maps;
/**
 * LevelManagerSystem
 * @author Ayoub Aouraghe
 * */
public class LevelManagerSystem {
    private PositioningComponent positioningComponent;
    private LevelComponent levelComponent;

    /**
     * LevelManagerSystem
     * @param levelComponent
     * @param positioningComponent
     */
    public LevelManagerSystem(LevelComponent levelComponent,PositioningComponent positioningComponent) {
        this.levelComponent = levelComponent;
        this.positioningComponent = positioningComponent;
    }

    /**
     * updateLevel function
     * updates the level
     */
    public void updateLevel(){
        if(!CollisionDetection.CheckPoint(positioningComponent.x,positioningComponent.y, 64, 64, Maps.maps[levelComponent.getLevel()])){
            //System.out.println("ik ben in updatelevel");
            levelComponent.setLevel(1);
            positioningComponent.x =70;
            positioningComponent.y =50;

        }

    }
}
