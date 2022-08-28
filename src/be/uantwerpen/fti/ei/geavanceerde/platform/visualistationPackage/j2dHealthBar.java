package be.uantwerpen.fti.ei.geavanceerde.platform.visualistationPackage;

import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components.HealthComponent;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.enteties.AbstractHealth;

import java.awt.*;
import java.awt.image.BufferedImage;

public class j2dHealthBar extends AbstractHealth {
    private final GraphicsContext graphicsC;
    private final BufferedImage health;
    private final Font font;

    public j2dHealthBar(GraphicsContext graphicsContext,HealthComponent healthComponent) {
        super(healthComponent);
        this.graphicsC = graphicsContext;
        font = new Font("Courier New",1,(int)(20));
        String coinImagePath = "src/resources/heart.png";
        health = this.graphicsC.loadImages(coinImagePath,(int)(30),(int)(30), false);

    }

    @Override
    public void visualize() {
        Graphics2D g2d = graphicsC.getG2d();
        g2d.setFont(font);
        g2d.setColor(Color.BLACK);
        g2d.drawString(":",(int)((graphicsC.getFrame().getWidth()/6)),(int)(30));
        String scr = String.valueOf(GetHealth());
        g2d.drawString(scr,(int)((graphicsC.getFrame().getWidth()/5.5)),(int)(30));
        g2d.drawImage(health,(int)((graphicsC.getFrame().getWidth()/7)),(int)(10), null);

    }
}
