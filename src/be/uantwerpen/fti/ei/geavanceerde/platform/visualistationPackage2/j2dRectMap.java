package be.uantwerpen.fti.ei.geavanceerde.platform.visualistationPackage2;

import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.enteties.AbstractMap;

import java.awt.*;
import java.awt.image.BufferedImage;
/**
 * j2dRectMap
 * @author Ayoub Aouraghe
 * */
public class j2dRectMap extends AbstractMap {
    private GraphicsContext graphicsContext;


    private final int witdthOfTiles, heightOfTiles, sizeOfTiles;

    /**
     * j2dRectMap
     * @param graphicsContext
     * @param tilesMap
     * @param height
     * @param width
     * @param size
     */
    public j2dRectMap(GraphicsContext graphicsContext, int[][][] tilesMap, int height, int width, int size) {
        super(tilesMap, height, width, size);
        this.witdthOfTiles = width;
        this.heightOfTiles = height;
        this.sizeOfTiles = size;
        this.graphicsContext = graphicsContext;

    }

    /**
     * visualize function
     */

    @Override
    public void visualize() {
        Graphics2D g2d = graphicsContext.getG2d();


        for(int y=0; y<heightOfTiles; y++){
            for(int x =0; x<witdthOfTiles; x++){
                int number = getSpriteIndex(getLevelComponent().getLevel(), x,y);


                if (number != 0) {
                    g2d.setColor(Color.GRAY);
                    if (number == 1)
                        g2d.fillRect( (x * sizeOfTiles) - graphicsContext.getCamX(), (y * sizeOfTiles) - graphicsContext.getCamY(), sizeOfTiles, sizeOfTiles);

                    if (number == 2)
                        g2d.fillRect( (x * sizeOfTiles) - graphicsContext.getCamX(), (y * sizeOfTiles) - graphicsContext.getCamY(), sizeOfTiles, sizeOfTiles);

                    if (number == 3)
                        g2d.fillRect((x * sizeOfTiles) - graphicsContext.getCamX(), (y * sizeOfTiles) - graphicsContext.getCamY(), sizeOfTiles, sizeOfTiles);

                    if (number == 4)
                        g2d.fillRect( (x * sizeOfTiles) - graphicsContext.getCamX(), (y * sizeOfTiles) - graphicsContext.getCamY(), sizeOfTiles, sizeOfTiles);
                    if (number == 5) {
                        g2d.setColor(Color.white);
                        g2d.fillRect((x * sizeOfTiles) - graphicsContext.getCamX(), (y * sizeOfTiles) - graphicsContext.getCamY(), sizeOfTiles, sizeOfTiles);
                    }
                    if (number == 6)
                        g2d.fillRect( (x * sizeOfTiles) - graphicsContext.getCamX() + 16, (y * sizeOfTiles) - graphicsContext.getCamY() +32, 32, 32);
                    if (number == 7)
                        g2d.fillRect((x * sizeOfTiles) - graphicsContext.getCamX(), (y * sizeOfTiles) - graphicsContext.getCamY() , -102, 74);

                }

            }
        }
    }
}
