package be.uantwerpen.fti.ei.geavanceerde.platform.visualistationPackage;

import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components.ProjectileComponent;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Systems.ProjectileSystem;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.enteties.AbstractProjectiles;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class j2dProjectile extends AbstractProjectiles {

    private final GraphicsContext graphicsContext;
    private String bullet= "src/resources/bullet.png";

    /**
     * j2dProjectile
     * @param graphicsContext
     * @param projectileComponent
     */
    public j2dProjectile(GraphicsContext graphicsContext, ProjectileComponent projectileComponent){
        super(projectileComponent);
        this.graphicsContext = graphicsContext;
    }

    /**
     * visualize function
     */
    @Override
    public void visualize() {

        Graphics2D graphics2D = graphicsContext.getG2d();
        BufferedImage bullets = GetSpriteSheet(bullet);
        if (getProjectileComponent().isActive()) {
            graphics2D.drawImage(bullets, ((int) (getX() - getR()) + 50) - graphicsContext.getCamX(), ((int) (getY() - getR()) + 15) - graphicsContext.getCamY(),20,20, null);
        }
    }


}
