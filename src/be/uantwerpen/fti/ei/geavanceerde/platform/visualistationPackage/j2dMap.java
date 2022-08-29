package be.uantwerpen.fti.ei.geavanceerde.platform.visualistationPackage;

import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.enteties.AbstractMap;

import java.awt.*;
import java.awt.image.BufferedImage;
/**
 * j2dMap
 * @author Ayoub Aouraghe
 * */
public class j2dMap extends AbstractMap {
    private GraphicsContext graphicsContext;


    private final int witdthOfTiles, heightOfTiles, sizeOfTiles;

    /**
     * j2dMap
     * @param graphicsContext
     * @param tilesMap
     * @param height
     * @param width
     * @param size
     */
    public j2dMap(GraphicsContext graphicsContext, int[][][] tilesMap, int height, int width, int size) {
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
        Graphics2D graphics2D = graphicsContext.getG2d();
        BufferedImage img  = GetSpriteSheet("src/resources/Tile1.png");
        BufferedImage img2  = GetSpriteSheet("src/resources/Tile2.png");
        BufferedImage img3  = GetSpriteSheet("src/resources/Tile3.png");
        BufferedImage img4 = GetSpriteSheet("src/resources/Check.png");
        BufferedImage img5  = GetSpriteSheet("src/resources/spikes.png");
        BufferedImage img6 = GetSpriteSheet("src/resources/star.png");
        BufferedImage img7 = GetSpriteSheet("src/resources/nice_enemy.png");

        for(int y=0; y<heightOfTiles; y++){
            for(int x =0; x<witdthOfTiles; x++){

                int number = getSpriteIndex(getLevelComponent().getLevel(), x,y);


                if (number != 0) {

                    if (number == 1)
                        graphics2D.drawImage(img, (x * sizeOfTiles) - graphicsContext.getCamX(), (y * sizeOfTiles) - graphicsContext.getCamY(), sizeOfTiles, sizeOfTiles, null);

                    if (number == 2)
                        graphics2D.drawImage(img2, (x * sizeOfTiles) - graphicsContext.getCamX(), (y * sizeOfTiles) - graphicsContext.getCamY(), sizeOfTiles, sizeOfTiles, null);

                    if (number == 3)
                        graphics2D.drawImage(img3, (x * sizeOfTiles) - graphicsContext.getCamX(), (y * sizeOfTiles) - graphicsContext.getCamY(), sizeOfTiles, sizeOfTiles, null);

                    if (number == 4)
                        graphics2D.drawImage(img4, (x * sizeOfTiles) - graphicsContext.getCamX(), (y * sizeOfTiles) - graphicsContext.getCamY(), sizeOfTiles, sizeOfTiles, null);
                    if (number == 5) {
                        graphics2D.drawImage(img5, (x * sizeOfTiles) - graphicsContext.getCamX(), (y * sizeOfTiles) - graphicsContext.getCamY(), sizeOfTiles, sizeOfTiles, null);
                        graphics2D.setColor(Color.RED);
                        graphics2D.drawRect((int) (x * sizeOfTiles)- graphicsContext.getCamX(), (int) (y * sizeOfTiles) - graphicsContext.getCamY(), sizeOfTiles, sizeOfTiles);
                    }
                    if (number == 6)
                        graphics2D.drawImage(img6, (x * sizeOfTiles) - graphicsContext.getCamX() + 16, (y * sizeOfTiles) - graphicsContext.getCamY() +32, 32, 32, null);
                    if (number == 7)
                        graphics2D.drawImage(img7,(x * sizeOfTiles) - graphicsContext.getCamX() +80, (y * sizeOfTiles) - graphicsContext.getCamY() , -80, 50, null);

                }

            }
        }
    }
}
