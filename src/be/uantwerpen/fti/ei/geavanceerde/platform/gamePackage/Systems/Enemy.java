package be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Systems;

import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components.CollisionComponent;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components.LevelComponent;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components.ProjectileComponent;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Game;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.enteties.AbstractProjectiles;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.utilities.Maps;

import java.util.ArrayList;
/**
 * Enemy
 * @author Ayoub Aouraghe
 * */
public class Enemy {
    private final ArrayList<AbstractProjectiles> bullets;

    private final LevelComponent levelComponent;

    /**
     * Enemy
     * @param bullets
     * @param levelComponent
     */
    public Enemy(ArrayList<AbstractProjectiles> bullets,LevelComponent levelComponent) {
        this.bullets = bullets;
        this.levelComponent = levelComponent;
    }

    /**
     * enemySystemCheck
     * detection if the bullet hits the enemy
     */
    public void enemySystemCheck(){
        if (bullets != null) {
            for (int i = 0; i < bullets.size(); i++) {
                float xIndex = (float) bullets.get(i).getProjectileComponent().getX() / Game.tileSize;
                float yIndex = (float) bullets.get(i).getProjectileComponent().getX() / Game.tileSize;

                if (!CollisionDetection.enemy((int) bullets.get(i).getProjectileComponent().getX(), (int) bullets.get(i).getProjectileComponent().getX(), 20, 20, Maps.maps[levelComponent.getLevel()])) {
                    Maps.maps[levelComponent.getLevel()][(int) yIndex + 1][(int) xIndex] = 0;
                    //System.out.println("point activated " + bonusComponent.getBonusCoins());
                }
            }

        }
    }
}
