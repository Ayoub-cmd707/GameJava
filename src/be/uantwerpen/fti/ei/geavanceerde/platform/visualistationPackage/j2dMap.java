package be.uantwerpen.fti.ei.geavanceerde.platform.visualistationPackage;

import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.enteties.AbstractMap;

import java.awt.*;
import java.awt.image.BufferedImage;

public class j2dMap extends AbstractMap {
    private GraphicsContext graphicsContext;
    private BufferedImage[] levelSprite;
    private String tile_spritesheet = "/assets/images/SpriteSheets/tilesets.png";
    private int TILES_IN_WIDTH, TILES_IN_HEIGHT, TILES_SIZE;

    public j2dMap(GraphicsContext graphicsContext, int[][] tileArray, int TILES_IN_HEIGHT, int TILES_IN_WIDTH, int TILES_SIZE) {
        super(tileArray, TILES_IN_HEIGHT, TILES_IN_WIDTH, TILES_SIZE);
        this.TILES_IN_WIDTH = TILES_IN_WIDTH;
        this.TILES_IN_HEIGHT = TILES_IN_HEIGHT;
        this.TILES_SIZE = TILES_SIZE;
        this.graphicsContext = graphicsContext;
        importOutsideSprites();
    }


    public void importOutsideSprites(){
        BufferedImage img = GetSpriteSheet(tile_spritesheet);
        levelSprite = new BufferedImage[256];
        for(int i =0;i<1;i++){
            for(int j=0;j<4;j++){
                int index = i*4 + j;
                levelSprite[index] = img.getSubimage(j*32,i*32,32,32);
            }
        }
    }


    @Override
    public void visualize() {
        Graphics2D g2d = graphicsContext.getG2d();

        for(int i = 0;i<TILES_IN_HEIGHT;i++){
            for(int j =0;j<TILES_IN_WIDTH;j++){
                int index = getSpriteIndex(j,i);
                if(index==0){
                    index = 200;
                }
                g2d.drawImage(levelSprite[index],(j*TILES_SIZE)-graphicsContext.getCamX(),(i*TILES_SIZE)-graphicsContext.getCamY(),TILES_SIZE,TILES_SIZE,null);
            }
        }
    }
}
