package be.uantwerpen.fti.ei.geavanceerde.platform.visualistationPackage2;

import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.enteties.AbstractBackground;

import java.awt.*;
import java.awt.image.BufferedImage;
/**
 * j2dRectBackground
 * @author Ayoub Aouraghe
 * */
public class j2dRectBackground extends AbstractBackground {

    private final GraphicsContext graphicsC;
    private Graphics2D graphics2D;

    /**
     * j2dRectBackground
     * @param graphicsContext
     */
    public j2dRectBackground(GraphicsContext graphicsContext) {
        super();
        this.graphicsC = graphicsContext;

    }

    /**
     * visualize function
     */
    @Override
    public void visualize() {
        graphics2D = graphicsC.getG2d();
        graphics2D.setColor(Color.BLACK);
        graphics2D.fillRect(0,0,this.graphicsC.getFrame().getWidth(), this.graphicsC.getFrame().getHeight());


    }
}
