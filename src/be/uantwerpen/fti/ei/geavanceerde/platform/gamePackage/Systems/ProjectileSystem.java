package be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Systems;

import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.enteties.AbstractProjectiles;

import java.util.ArrayList;
/**
 * ProjectileSystem
 * @author Ayoub Aouraghe
 * */
public class ProjectileSystem {
    private final ArrayList<AbstractProjectiles> bullets;

    /**
     * ProjectileSystem
     * @param abstractBullets
     */
    public ProjectileSystem(ArrayList<AbstractProjectiles> abstractBullets){
        this.bullets = abstractBullets;
    }

    /**
     * update function
     */
    public void update(){
        updateBulletMovement();
    }

    /**
     * update the bullet movement
     */
    private void updateBulletMovement(){
        for(int i=0;i<bullets.size();i++) {
            if (bullets.get(i).getProjectileComponent().getAngle() > 0) {
                bullets.get(i).getProjectileComponent().setX(bullets.get(i).getProjectileComponent().getX() + (bullets.get(i).getProjectileComponent().getDx() * bullets.get(i).getProjectileComponent().getSpeed()));
                if (bullets.get(i).getProjectileComponent().getX() < -bullets.get(i).getProjectileComponent().getR() || bullets.get(i).getProjectileComponent().getX() - 1000 > bullets.get(i).getProjectileComponent().getScreenWidth() + bullets.get(i).getProjectileComponent().getR() || bullets.get(i).getProjectileComponent().getY() < -bullets.get(i).getProjectileComponent().getR() || bullets.get(i).getProjectileComponent().getY() > bullets.get(i).getProjectileComponent().getScreenHeight() + bullets.get(i).getProjectileComponent().getR()) {
                    bullets.get(i).getProjectileComponent().setActive(false);
                    bullets.remove(i);
                }
            }
            else{
                bullets.get(i).getProjectileComponent().setX(bullets.get(i).getProjectileComponent().getX() + (bullets.get(i).getProjectileComponent().getDx() * bullets.get(i).getProjectileComponent().getSpeed()));
                if (bullets.get(i).getProjectileComponent().getX() < -bullets.get(i).getProjectileComponent().getR()-100 || bullets.get(i).getProjectileComponent().getX() - 1000 > bullets.get(i).getProjectileComponent().getR() || bullets.get(i).getProjectileComponent().getY() < -bullets.get(i).getProjectileComponent().getR() || bullets.get(i).getProjectileComponent().getY() > bullets.get(i).getProjectileComponent().getScreenHeight() + bullets.get(i).getProjectileComponent().getR()) {
                    bullets.get(i).getProjectileComponent().setActive(false);
                    bullets.remove(i);
                }
            }
        }
    }
}
