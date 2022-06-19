package be.uantwerpen.fti.ei.geavanceerde.platform.visualistationPackage;

import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.enteties.AbstractMap;

import java.awt.*;
import java.awt.image.BufferedImage;

public class j2dMap extends AbstractMap {
    private GraphicsContext graphicsContext;


    private final int witdthOfTiles, heightOfTiles, sizeOfTiles;

    public j2dMap(GraphicsContext graphicsContext, int[][] tilesMap, int height, int width, int size) {
        super(tilesMap, height, width, size);
        this.witdthOfTiles = width;
        this.heightOfTiles = height;
        this.sizeOfTiles = size;
        this.graphicsContext = graphicsContext;

    }




    @Override
    public void visualize() {
        Graphics2D g2d = graphicsContext.getG2d();
        BufferedImage img;
        for(int x=0; x<heightOfTiles; x++){
            for(int y =0; y<witdthOfTiles; y++){
                int number = getSpriteIndex(y,x);
                switch (number) {
                    case 1 -> {
                        img = GetSpriteSheet("src/resources/Tile1.png");
                        g2d.drawImage(img, (y * sizeOfTiles) - graphicsContext.getCamX(), (x * sizeOfTiles) - graphicsContext.getCamY(), sizeOfTiles, sizeOfTiles, null);
                    }
                    case 2 -> {
                        img = GetSpriteSheet("src/resources/Tile2.png");
                        g2d.drawImage(img, (y * sizeOfTiles) - graphicsContext.getCamX(), (x * sizeOfTiles) - graphicsContext.getCamY(), sizeOfTiles, sizeOfTiles, null);
                    }
                    case 3 -> {
                        img = GetSpriteSheet("src/resources/Tile3.png");
                        g2d.drawImage(img, (y * sizeOfTiles) - graphicsContext.getCamX(), (x * sizeOfTiles) - graphicsContext.getCamY(), sizeOfTiles, sizeOfTiles, null);
                    }
                }
            }
        }
    }
}
