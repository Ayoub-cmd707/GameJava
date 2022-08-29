package be.uantwerpen.fti.ei.geavanceerde.platform.visualistationPackage2;

import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components.ProjectileComponent;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.enteties.AbstractProjectiles;

import java.awt.*;
import java.awt.image.BufferedImage;
/**
 * j2dRectProjectile
 * @author Ayoub Aouraghe
 * */
public class j2dRectProjectile extends AbstractProjectiles {

    private final GraphicsContext graphicsContext;

    /**
     * j2dRectProjectile
     * @param graphicsContext
     * @param projectileComponent
     */
    public j2dRectProjectile(GraphicsContext graphicsContext, ProjectileComponent projectileComponent){
        super(projectileComponent);
        this.graphicsContext = graphicsContext;
    }

    /**
     * visualize function
     */
    @Override
    public void visualize() {

        Graphics2D g2d = graphicsContext.getG2d();
        g2d.setColor(Color.GREEN);
        if (getProjectileComponent().isActive()) {
            g2d.fillRect(((int) (getX() - getR()) + 50) - graphicsContext.getCamX(), ((int) (getY() - getR()) + 15) - graphicsContext.getCamY(),20,20);
        }
    }


}
