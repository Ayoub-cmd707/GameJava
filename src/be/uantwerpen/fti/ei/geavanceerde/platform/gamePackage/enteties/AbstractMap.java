package be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.enteties;

import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components.LevelComponent;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Drawable;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public abstract class AbstractMap implements Drawable {
    private final int[][][] tilesMap;
    private final LevelComponent levelComponent;
    private int witdthOfTiles, heightOfTiles, sizeOfTiles;

    public AbstractMap(int[][][] tilesMap, int width, int height, int size){
        this.tilesMap = tilesMap;
        this.heightOfTiles = height;
        this.witdthOfTiles = width;
        this.sizeOfTiles = size;
        this.levelComponent = LevelComponent.getInstance();
    }

    public BufferedImage GetSpriteSheet(String fileName) {

        BufferedImage bufferedImage = null;


        try {
                bufferedImage = ImageIO.read(new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bufferedImage;
    }

    public int[][][] getTilesMap() {
        return tilesMap;
    }

    public LevelComponent getLevelComponent() {
        return levelComponent;
    }

    public int getWitdthOfTiles() {
        return witdthOfTiles;
    }

    public int getHeightOfTiles() {
        return heightOfTiles;
    }

    public int getSizeOfTiles() {
        return sizeOfTiles;
    }

    public int getSpriteIndex(int level, int x, int y){
        return tilesMap[level][y][x];
    }


}
