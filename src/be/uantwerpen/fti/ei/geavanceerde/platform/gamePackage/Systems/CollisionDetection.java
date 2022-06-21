package be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Systems;

import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components.CollisionComponent;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components.MovementComponent;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Game;

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
    public static float UnderAboveTile(float airspeed, float y, int[][] map){
        int tile = (int)(y/Game.tileSize);
        if (airspeed > 0){
            int tilePosY = tile * Game.tileSize;
            int offset = Game.tileSize - 64;
            return tilePosY + offset -1;
        }else
            return tile * Game.tileSize;
    }

    public static boolean FloorCheck(float x, float y, int[][] map){
        if(!Solid(x,y+65,map))
            if (!Solid(x+65,y,map))
                return false;

        return true;
    }

    public static float GetEntityPosNextToWall(int x, int y, int width, int height, Float xSpeed){
        Rectangle2D.Float hitbox = new Rectangle2D.Float();
        hitbox.x = x;
        hitbox.y = y;
        hitbox.width = width;
        hitbox.height = height;
        int currentTile = (int)(hitbox.x / Game.tileSize);
        if(xSpeed > 0){
            //right
            int tileXpos = currentTile * Game.tileSize;
            int xOffset = (int)(Game.tileSize - hitbox.width);
            System.out.println(tileXpos + xOffset - 1);
            return tileXpos + xOffset - 1;
        }
        else{
            //left
            return currentTile * Game.tileSize;
        }

    }

    public static float GetEntityYPosUnderRoofOrAboveFloor(int x, int y, int width, int height, Float airSpeed){
        Rectangle2D.Float hitbox = new Rectangle2D.Float();
        hitbox.x = x;
        hitbox.y = y;
        hitbox.width = width;
        hitbox.height = height;
        int currentTile = (int) (hitbox.y / Game.tileSize);
        if(airSpeed > 0){
            //falling or touching floor
            System.out.println("touching flore");
            int tileYPos = currentTile * Game.tileSize;
            return tileYPos + 64 - 1;
        }
        else{
            //jumping
            System.out.println("jumping");
            return currentTile * Game.tileSize;
        }
    }


    public static boolean IsEntityOnFloor(int x, int y, int width, int height, int[][] levelData){
        Rectangle2D.Float hitbox = new Rectangle2D.Float();
        hitbox.x = x;
        hitbox.y = y;
        hitbox.width = width;
        hitbox.height = height;
        //System.out.println(hitbox);
        //check below bottomleft and bottomright
        if(!Solid(hitbox.x+1, hitbox.y + hitbox.height+1, levelData)){
            if(!Solid(hitbox.x + hitbox.width+ 1,hitbox.y + hitbox.height+1, levelData)){

                return false;
            }
        }

        return true;
    }
}
