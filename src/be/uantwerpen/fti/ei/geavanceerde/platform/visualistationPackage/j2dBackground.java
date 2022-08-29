package be.uantwerpen.fti.ei.geavanceerde.platform.visualistationPackage;

import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.enteties.AbstractBackground;

import java.awt.*;
import java.awt.image.BufferedImage;
/**
 * j2dBackground
 * @author Ayoub Aouraghe
 * */
public class j2dBackground extends AbstractBackground {

    private final GraphicsContext graphicsC;
    private final BufferedImage bufferedImage;
    private Graphics2D graphics2D;
    private String image = "src/resources/tilesetOpenGameBackground.png";

    /**
     * j2dBackground
     * @param graphicsContext
     */
    public j2dBackground(GraphicsContext graphicsContext) {
        super();
        this.graphicsC = graphicsContext;

        bufferedImage = this.graphicsC.loadImages(image,this.graphicsC.getFrame().getWidth(), this.graphicsC.getFrame().getHeight(),false);

    }

    /**
     * visualize function
     */
    @Override
    public void visualize() {
        graphics2D = graphicsC.getG2d();
        graphics2D.drawImage(bufferedImage,0,0,null);


    }
}
