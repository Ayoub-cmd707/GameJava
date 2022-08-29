package be.uantwerpen.fti.ei.geavanceerde.platform.visualistationPackage2;

import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components.HealthComponent;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.enteties.AbstractHealth;

import java.awt.*;
import java.awt.image.BufferedImage;
/**
 * j2dRectHealthBar
 * @author Ayoub Aouraghe
 * */
public class j2dRectHealthBar extends AbstractHealth {
    private final GraphicsContext graphicsC;

    /**
     * j2dRectHealthBar
     * @param graphicsContext
     * @param healthComponent
     */
    public j2dRectHealthBar(GraphicsContext graphicsContext, HealthComponent healthComponent) {
        super(healthComponent);
        this.graphicsC = graphicsContext;



    }

    /**
     * visualize function
     */
    @Override
    public void visualize() {
        Graphics2D graphics2D = graphicsC.getG2d();
        graphics2D.setColor(Color.BLACK);
        graphics2D.drawString(":",(int)((graphicsC.getFrame().getWidth()/6)),(int)(30));
        String s = String.valueOf(GetHealth());
        graphics2D.drawString(s,(int)((graphicsC.getFrame().getWidth()/5.5)),(int)(30));
        graphics2D.fillRect((int)((graphicsC.getFrame().getWidth()/7)),(int)(10), 30,30);

    }
}
