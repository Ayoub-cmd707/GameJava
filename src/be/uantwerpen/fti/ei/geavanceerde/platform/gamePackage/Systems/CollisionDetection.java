package be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Systems;

import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components.CollisionComponent;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components.MovementComponent;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Game;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.utilities.Maps;

import java.awt.geom.Rectangle2D;

public class CollisionDetection {


    public static boolean Move(float x, float y, int width, int height, int[][] map){
        if (!Solid(x,y,map)) {
            if (!Solid(x + width, y + height, map)) {
                if (!Solid(x + width, y, map)) {
                    if (!Solid(x, y + height, map)) {
                        return true;
                    }
                }
            }
        }
        //System.out.println("Ik ben tegen de tile");
        return false;
    }

    private static boolean Solid(float x,float y, int[][] map){

        if (x < 0.5f || x >= Game.tileSize * Game.tilesWidth){
            System.out.println("rand x-as");
            return true;
        }

        if (y < 0.5f || y >= Game.tileSize * Game.tilesWidth){
            System.out.println("rand y-as");
            return true;
        }


        float xIndex = x / Game.tileSize;
        float yIndex = y / Game.tileSize;
        CollisionComponent.positionX = x;
        CollisionComponent.positionY = y;


        int value = map[(int)yIndex][(int)xIndex];

        if (value == 1 || value == 2)
            return true;

        return false;
    }
    public float GetEntityPosNextToWall(int x, int y, int width, int height, Float xSpeed){
        int currentTile = (int)(x / Game.tileSize);
        if(xSpeed > 0){
            int tileXpos = currentTile * Game.tileSize;
            int xOffset = (int)(Game.tileSize - width);
            return tileXpos + xOffset +64 - 1;
        }
        else
            return currentTile * Game.tileSize;
    }

    public static float GetEntityYPosUnderRoofOrAboveFloor(int x, int y, int width, int height, Float airSpeed){
        int currentTile = (int) (y / Game.tileSize);
        if(airSpeed > 0){
            int tileYPos = currentTile * Game.tileSize;
            int yOffset = (int)(Game.tileSize - height);
            return tileYPos + 64 -1;
        }
        else
            return currentTile * Game.tileSize;

    }

    public static boolean IsEntityOnFloor(int x, int y, int width, int height){
        //check below bottomleft and bottomright
        if(!Solid(x, y + height+1,Maps.map1)){
            return Solid(x + width, y + height + 1, Maps.map1);
        }
        return true;
    }
}
