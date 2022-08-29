package be.uantwerpen.fti.ei.geavanceerde.platform.visualistationPackage;

import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components.HealthComponent;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.enteties.AbstractHealth;

import java.awt.*;
import java.awt.image.BufferedImage;
/**
 * j2dHealthBar
 * @author Ayoub Aouraghe
 * */
public class j2dHealthBar extends AbstractHealth {
    private final GraphicsContext graphicsC;
    private final BufferedImage health;
    private final Font font;

    /**
     * j2dHealthBar
     * @param graphicsContext
     * @param healthComponent
     */
    public j2dHealthBar(GraphicsContext graphicsContext,HealthComponent healthComponent) {
        super(healthComponent);
        this.graphicsC = graphicsContext;
        font = new Font("Courier New",1,(int)(20));
        String coinImagePath = "src/resources/heart.png";
        health = this.graphicsC.loadImages(coinImagePath,(int)(30),(int)(30), false);

    }

    /**
     * visualize
     */
    @Override
    public void visualize() {
        Graphics2D graphics2D = graphicsC.getG2d();
        graphics2D.setFont(font);
        graphics2D.setColor(Color.BLACK);
        graphics2D.drawString(":",(int)((graphicsC.getFrame().getWidth()/6)),(int)(30));
        String s = String.valueOf(GetHealth());
        graphics2D.drawString(s,(int)((graphicsC.getFrame().getWidth()/5.5)),(int)(30));
        graphics2D.drawImage(health,(int)((graphicsC.getFrame().getWidth()/7)),(int)(10), null);

    }
}
