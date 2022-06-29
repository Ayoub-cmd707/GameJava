package be.uantwerpen.fti.ei.geavanceerde.platform.visualistationPackage;

import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.enteties.AbstractMap;

import java.awt.*;
import java.awt.image.BufferedImage;

public class j2dMap extends AbstractMap {
    private GraphicsContext graphicsContext;


    private final int witdthOfTiles, heightOfTiles, sizeOfTiles;

    public j2dMap(GraphicsContext graphicsContext, int[][][] tilesMap, int height, int width, int size) {
        super(tilesMap, height, width, size);
        this.witdthOfTiles = width;
        this.heightOfTiles = height;
        this.sizeOfTiles = size;
        this.graphicsContext = graphicsContext;

    }



    @Override
    public void visualize() {
        Graphics2D g2d = graphicsContext.getG2d();
        BufferedImage img  = GetSpriteSheet("src/resources/Tile1.png");
        BufferedImage img2  = GetSpriteSheet("src/resources/Tile2.png");
        BufferedImage img3  = GetSpriteSheet("src/resources/Tile3.png");
        BufferedImage img4 = GetSpriteSheet("src/resources/Check.png");
        BufferedImage img5  = GetSpriteSheet("src/resources/spikes.png");

        for(int y=0; y<heightOfTiles; y++){
            for(int x =0; x<witdthOfTiles; x++){
                //System.out.println(" ik ben in visualisze " + getLevelComponent().getLevel());
                int number = getSpriteIndex(getLevelComponent().getLevel(), x,y);
                /*switch (number) {
                    case 1 -> {
                        img = GetSpriteSheet("src/resources/Tile1.png");
                        g2d.drawImage(img, (x * sizeOfTiles) - graphicsContext.getCamX(), (y * sizeOfTiles) - graphicsContext.getCamY(), sizeOfTiles, sizeOfTiles, null);
                    }
                    case 2 -> {
                        img = GetSpriteSheet("src/resources/Tile2.png");
                        g2d.drawImage(img, (x * sizeOfTiles) - graphicsContext.getCamX(), (y * sizeOfTiles) - graphicsContext.getCamY(), sizeOfTiles, sizeOfTiles, null);
                    }
                    case 3 -> {
                        img = GetSpriteSheet("src/resources/Tile3.png");
                        g2d.drawImage(img, (x * sizeOfTiles) - graphicsContext.getCamX(), (y * sizeOfTiles) - graphicsContext.getCamY(), sizeOfTiles, sizeOfTiles, null);
                    }
                }*/

                if (number != 0) {

                    if (number == 1)
                        g2d.drawImage(img, (x * sizeOfTiles) - graphicsContext.getCamX(), (y * sizeOfTiles) - graphicsContext.getCamY(), sizeOfTiles, sizeOfTiles, null);

                    if (number == 2)
                        g2d.drawImage(img2, (x * sizeOfTiles) - graphicsContext.getCamX(), (y * sizeOfTiles) - graphicsContext.getCamY(), sizeOfTiles, sizeOfTiles, null);

                    if (number == 3)
                        g2d.drawImage(img3, (x * sizeOfTiles) - graphicsContext.getCamX(), (y * sizeOfTiles) - graphicsContext.getCamY(), sizeOfTiles, sizeOfTiles, null);

                    if (number == 4)
                        g2d.drawImage(img4, (x * sizeOfTiles) - graphicsContext.getCamX(), (y * sizeOfTiles) - graphicsContext.getCamY(), sizeOfTiles, sizeOfTiles, null);
                    if (number == 5)
                        g2d.drawImage(img5, (x * sizeOfTiles) - graphicsContext.getCamX(), (y * sizeOfTiles) - graphicsContext.getCamY(), sizeOfTiles, sizeOfTiles, null);
                }

            }
        }
    }
}
