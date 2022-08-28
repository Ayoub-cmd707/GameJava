package be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Systems;

import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components.BonusComponent;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components.CollisionComponent;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components.LevelComponent;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components.PositioningComponent;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Game;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.utilities.Maps;

public class Bonus {
    private final CollisionComponent collisionComponent;
    private final PositioningComponent positioningComponent;
    private final BonusComponent bonusComponent;
    private LevelComponent levelComponent;

    public Bonus(CollisionComponent collisionComponent, PositioningComponent positioningComponent, BonusComponent bonusComponent, LevelComponent levelComponent) {
        this.collisionComponent = collisionComponent;
        this.positioningComponent = positioningComponent;
        this.bonusComponent = bonusComponent;
        this.levelComponent = levelComponent;

    }
    private void coinBonusSystem(){
        //System.out.println("ik ben in bonusSyteem");
        if (bonusComponent != null) {
            /*int row = y / 64;
            int col1 = (x + (int)(30 *1.0)) / 64;
            int col2 = (x) / 64;
            System.out.println("test: " + map[row][col1]);
            if (map[row][col1] == -2) {
                bonusComponent.setBonusCoins(bonusComponent.getBonusCoins() + 1);
                map[row][col1] = 0;
                System.out.println("point activated " + bonusComponent.getBonusCoins());
            }
            if (map[row][col2] == -2) {
                bonusComponent.setBonusCoins(bonusComponent.getBonusCoins() + 1);
                map[row][col2] = 0;
                System.out.println("point activated " + bonusComponent.getBonusCoins());
            }*/
            float xIndex = positioningComponent.x / Game.tileSize;
            float yIndex = positioningComponent.y / Game.tileSize;

            if(!CollisionDetection.coins(positioningComponent.x,positioningComponent.y,1,1,Maps.maps[levelComponent.getLevel()])){
                bonusComponent.setBonusCoins(bonusComponent.getBonusCoins() + 1);
                System.out.println("point activated " + bonusComponent.getBonusCoins());


                Maps.maps[levelComponent.getLevel()][(int)yIndex + 1 ][(int)xIndex] = 0;

            }
        }
    }

    public void coincheck(){
        //System.out.println("ik ben active in check");
        //System.out.println("x pos = "+positioningComponent.x);
        coinBonusSystem();
    }
}
