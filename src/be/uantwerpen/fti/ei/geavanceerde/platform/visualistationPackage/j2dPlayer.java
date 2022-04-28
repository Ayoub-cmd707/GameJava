package be.uantwerpen.fti.ei.geavanceerde.platform.visualistationPackage;

import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.enteties.AbstractPlayer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class j2dPlayer extends AbstractPlayer {

    private final GraphicsContext graphicsContext;
    private BufferedImage player;


    public j2dPlayer(GraphicsContext grCtx, int x, int y, int hitboxWidth, int hitboxHeight) throws IOException {
        super(x,y,hitboxWidth,hitboxHeight);
        loadSprite();
        this.graphicsContext = grCtx;
    }

    @Override
    public void visualize() {
        Graphics2D graphics2D = graphicsContext.getG2d();
        graphics2D.drawImage(player,10,10,64,64,null);

    }

    private void loadSprite() throws IOException {

        BufferedImage image = ImageIO.read(new File("src/resources/Idle.png"));

        player = image.getSubimage(0,0, 64,64);



    }
}
