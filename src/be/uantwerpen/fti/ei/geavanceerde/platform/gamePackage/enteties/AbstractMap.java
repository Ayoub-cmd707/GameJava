package be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.enteties;

import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Drawable;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public abstract class AbstractMap implements Drawable {
    private final int[][] tilesMap;

    private int witdthOfTiles, heightOfTiles, sizeOfTiles;

    public AbstractMap(int[][] tilesMap, int width, int height, int size){
        this.tilesMap = tilesMap;
        this.heightOfTiles = height;
        this.witdthOfTiles = width;
        this.sizeOfTiles = size;
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


    public int getSpriteIndex(int x, int y){
        return tilesMap[y][x];
    }


}
