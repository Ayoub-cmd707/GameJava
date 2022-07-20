package be.uantwerpen.fti.ei.geavanceerde.platform.visualistationPackage;

import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components.CollisionComponent;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components.PositioningComponent;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.enteties.AbstractEnemy;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class j2dEnemy extends AbstractEnemy {
    private final GraphicsContext graphicsContext;
    private BufferedImage[] animation;
    private int aniTick, aniRunningIndex,aniIdleIndex, aniSpeed = 3;


    public j2dEnemy(GraphicsContext grCtx,int x, int y, int width, int height) throws IOException {
        super(x, y, width, height);
        this.graphicsContext = grCtx;
        loadSprite();
    }

    private void update(){
        aniTick++;
        if (aniTick>= aniSpeed){
            aniTick = 0;
            aniRunningIndex++;
            aniIdleIndex++;

            if (aniRunningIndex >= animation.length){
                aniRunningIndex =0;
            }
        }
    }

    private void loadSprite() throws IOException {

        animation = new BufferedImage[22];
        BufferedImage image = ImageIO.read(new File("src/resources/skeleIdle.png"));
        for (int i = 0; i < animation.length; i++) {
            animation[i] = image.getSubimage(i,0, 524,494);
        }



    }

    @Override
    public void visualize() {
        Graphics2D graphics2D = graphicsContext.getG2d();
        update();

        graphics2D.drawImage(animation[aniRunningIndex],(int) getPositionComponent().x ,(int) getPositionComponent().y,64,64,null);
    }
}
