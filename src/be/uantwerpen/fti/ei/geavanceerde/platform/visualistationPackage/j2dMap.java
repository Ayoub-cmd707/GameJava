package be.uantwerpen.fti.ei.geavanceerde.platform.visualistationPackage;

import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.enteties.AbstractMap;

import java.awt.*;
import java.awt.image.BufferedImage;

public class j2dMap extends AbstractMap {
    private GraphicsContext graphicsContext;
    private BufferedImage[] levelSprite;
    private String tileStandaart = "src/resources/Tile1.png";
    private String tileUnder = "src/resources/Tile2.png";
    private String tileRock = "src/resources/Tile3.png";
    private int TILES_IN_WIDTH, TILES_IN_HEIGHT, TILES_SIZE;

    public j2dMap(GraphicsContext graphicsContext, int[][] tileArray, int TILES_IN_HEIGHT, int TILES_IN_WIDTH, int TILES_SIZE) {
        super(tileArray, TILES_IN_HEIGHT, TILES_IN_WIDTH, TILES_SIZE);
        this.TILES_IN_WIDTH = TILES_IN_WIDTH;
        this.TILES_IN_HEIGHT = TILES_IN_HEIGHT;
        this.TILES_SIZE = TILES_SIZE;
        this.graphicsContext = graphicsContext;
        //importOutsideSprites();
    }


    /*public void importOutsideSprites(){
        BufferedImage img = GetSpriteSheet(tile_spritesheet);
        levelSprite = new BufferedImage[256];
        for(int i =0;i<1;i++){
            for(int j=0;j<4;j++){
                int index = i*4 + j;
                levelSprite[index] = img.getSubimage(j*32,i*32,32,32);
            }
        }
    }*/


    @Override
    public void visualize() {
        Graphics2D g2d = graphicsContext.getG2d();
        BufferedImage img;
        for(int x=0; x<TILES_IN_HEIGHT; x++){
            for(int y =0; y<TILES_IN_WIDTH; y++){
                int number = getSpriteIndex(y,x);
                switch (number) {
                    case 1 -> {
                        img = GetSpriteSheet(tileStandaart);
                        g2d.drawImage(img, (y * TILES_SIZE) - graphicsContext.getCamX(), (x * TILES_SIZE) - graphicsContext.getCamY(), TILES_SIZE, TILES_SIZE, null);
                    }
                    case 2 -> {
                        img = GetSpriteSheet(tileUnder);
                        g2d.drawImage(img, (y * TILES_SIZE) - graphicsContext.getCamX(), (x * TILES_SIZE) - graphicsContext.getCamY(), TILES_SIZE, TILES_SIZE, null);
                    }
                    case 3 -> {
                        img = GetSpriteSheet(tileRock);
                        g2d.drawImage(img, (y * TILES_SIZE) - graphicsContext.getCamX(), (x * TILES_SIZE) - graphicsContext.getCamY(), TILES_SIZE, TILES_SIZE, null);
                    }
                }
            }
        }
    }
}
