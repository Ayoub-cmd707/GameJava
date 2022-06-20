package be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Systems;

import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components.CollisionComponent;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Game;

public class CollisionDetection {


    public static boolean Move(float x, float y, int width, int height, int[][] map){
        if (!Solid(x,y,map)) {
            if (!Solid(x + width, y + height, map)) {
                if (!Solid(x + width, y, map)) {
                    if (!Solid(x, y + height, map)) {
                        //System.out.println("collision werkteroodooor");
                        return true;
                    }
                }
            }
        }
        //System.out.println("collision werkt");
        return false;

    }

    private static boolean Solid(float x,float y, int[][] map){

        if (x < 0 || x >= Game.gameWidth)
            return true;
        if (x < 0 || x >= Game.gameHeigth)
            return true;

        float xIndex = x / Game.tileSize;
        float yIndex = y / Game.tileSize;
        CollisionComponent.positionX = x;
        CollisionComponent.positionY = y;


        int value = map[(int)yIndex][(int)xIndex];

        if (value == 1 || value == 2)
            return true;

        return false;
    }
}
