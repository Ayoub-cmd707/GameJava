package be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Systems;

import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components.BonusComponent;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components.CollisionComponent;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components.LevelComponent;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components.PositioningComponent;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Game;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.utilities.Maps;
/**
 * Bonus
 * @author Ayoub Aouraghe
 * */
public class Bonus {
    private final CollisionComponent collisionComponent;
    private final PositioningComponent positioningComponent;
    private final BonusComponent bonusComponent;
    private final LevelComponent levelComponent;

    /**
     * Bonus
     * @param collisionComponent
     * @param positioningComponent
     * @param bonusComponent
     * @param levelComponent
     */
    public Bonus(CollisionComponent collisionComponent, PositioningComponent positioningComponent, BonusComponent bonusComponent, LevelComponent levelComponent) {
        this.collisionComponent = collisionComponent;
        this.positioningComponent = positioningComponent;
        this.bonusComponent = bonusComponent;
        this.levelComponent = levelComponent;

    }

    /**
     * coinBonusSystem function
     * checks for collision with the coins and remove the coin from the level table
     */
    private void coinBonusSystem(){

        if (bonusComponent != null) {

            float xIndex = positioningComponent.x / Game.tileSize;
            float yIndex = positioningComponent.y / Game.tileSize;

            if(!CollisionDetection.coins(positioningComponent.x,positioningComponent.y,(int) positioningComponent.hitboxWidth, (int) positioningComponent.hitboxHeight,Maps.maps[levelComponent.getLevel()])){
                Maps.maps[levelComponent.getLevel()][(int)yIndex + 1 ][(int)xIndex] = 0;
                bonusComponent.setBonusCoins(bonusComponent.getBonusCoins() + 1);
                //System.out.println("point activated " + bonusComponent.getBonusCoins());
            }
        }
    }

    /**
     * coincheck function
     * make the coinBonusSystem function available in other classes
     */
    public void coincheck(){
        coinBonusSystem();
    }
}
