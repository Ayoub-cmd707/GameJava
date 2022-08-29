package be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Systems;

import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components.CollisionComponent;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components.LevelComponent;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components.MovementComponent;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Game;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.utilities.Maps;

import java.awt.geom.Rectangle2D;
/**
 * CollisionDetection
 * @author Ayoub Aouraghe
 * */
public class CollisionDetection {
    private static LevelComponent levelComponent;

    /**
     * CollisionDetection
     * @param levelComponent
     */
    public CollisionDetection(LevelComponent levelComponent) {
        this.levelComponent = levelComponent;
    }

    /**
     * move function it is checking for a collision with my tiles
     * @param x
     * @param y
     * @param width
     * @param height
     * @param map
     * @return
     */
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

    /**
     * Solid function her happens the calculation for the collision
     * it checks the position
     * @param x
     * @param y
     * @param map
     * @return
     */
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
        //System.out.println("collision: "+value);
        if (value == 1 || value == 2 || value == 5)
            return true;

        return false;
    }

    /**
     * GetEntityYPosUnderRoofOrAboveFloor
     * it checks if the player can stand on it or does it fall off
     * and checks if there is nothing above
     * @param x
     * @param y
     * @param width
     * @param height
     * @param airSpeed
     * @return
     */
    public static float GetEntityYPosUnderRoofOrAboveFloor(int x, int y, int width, int height, int airSpeed){
        int currentTile = (int) (y / Game.tileSize);
        if(airSpeed > 0){
            //System.out.println("Falling Down");
            int tileYPos = currentTile * Game.tileSize;

            return tileYPos + 64 -1;
        }
        else {
            //System.out.println("JUMPING IN THE AIR");
            return currentTile * Game.tileSize;
        }
    }

    /**
     * GetEntityPosNextToWall
     * checking for the walls left and rifght
     * @param x
     * @param y
     * @param width
     * @param height
     * @param xSpeed
     * @return
     */
    public static float GetEntityPosNextToWall(int x, int y, int width, int height, Float xSpeed) {
        int currentTile = (int) (x / Game.tileSize);
        if (xSpeed > 0) {
            //System.out.println("next to wall");
            int tileXpos = currentTile * Game.tileSize;

            return tileXpos + 64 - 1;
        } else {
            //System.out.println("not next to  wall");
            return currentTile * Game.tileSize;
        }
    }

    /**
     * IsEntityOnFloor function
     * checks if the player is standing on the floor
     * @param x
     * @param y
     * @param width
     * @param height
     * @return
     */
    public static boolean IsEntityOnFloor(int x, int y, int width, int height){
        //check below bottomleft and bottomright
        if(!Solid(x, y + height+1,Maps.maps[levelComponent.getLevel()])){
            //System.out.println("is on floor");
            return Solid(x + width, y + height + 1, Maps.maps[levelComponent.getLevel()]);
        }
        return true;
    }

    /**
     * CheckPoint function
     * it looks for the check point so it can go to level2
     * @param x
     * @param y
     * @param width
     * @param height
     * @param map
     * @return
     */
    public static boolean CheckPoint(float x, float y, int width, int height, int[][] map){
        if (!CheckForCheckPoint(x,y,map)) {
            if (!CheckForCheckPoint(x + width, y + height, map)) {
                if (!CheckForCheckPoint(x + width, y, map)) {
                    if (!CheckForCheckPoint(x, y + height, map)) {
                        return true;
                    }
                }
            }
        }
        //System.out.println("Ik ben tegen de tile");
        return false;
    }

    /**
     * CheckForCheckPoint function
     * calculates the collision detection for the check point
     * @param x
     * @param y
     * @param map
     * @return
     */
    private static boolean CheckForCheckPoint(float x,float y, int[][] map){

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

        if (value == 4)
            return true;

        return false;
    }

    /**
     * DamageWithSpike function
     * it checks for collision with the spikes
     * @param x
     * @param y
     * @param width
     * @param height
     * @param map
     * @return
     */

    public static boolean DamageWithSpike(float x, float y, int width, int height, int[][] map){
        if (!CheckForDamage(x,y,map)) {
            if (!CheckForDamage(x + width, y + height, map)) {
                if (!CheckForDamage(x + width, y, map)) {
                    if (!CheckForDamage(x, y + height, map)) {
                        return true;
                    }
                }
            }
        }
        //System.out.println("Ik ben tegen de tile");
        return false;
    }

    /**
     * CheckForDamage function
     * calculates the collision with the spike
     * @param x
     * @param y
     * @param map
     * @return
     */
    private static boolean CheckForDamage(float x,float y, int[][] map){

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


        int value = map[(int)yIndex + 1][(int)xIndex];

        if (value == 5 || value == 7) {
            return true;
        }
        return false;
    }

    /**
     * coins function
     * check for the coins collision
     * @param x
     * @param y
     * @param width
     * @param height
     * @param map
     * @return
     */
    public static boolean coins(float x, float y, int width, int height, int[][] map){
        if (!CheckForCoins(x,y,map)) {
            if (!CheckForCoins(x + width, y + height, map)) {
                if (!CheckForCoins(x + width, y, map)) {
                    if (!CheckForCoins(x, y + height, map)) {
                        return true;
                    }
                }
            }
        }
        //System.out.println("Ik ben tegen de tile");
        return false;
    }

    /**
     * CheckForCoins function
     * calculation of the coins collision
     * @param x
     * @param y
     * @param map
     * @return
     */
    private static boolean CheckForCoins(float x,float y, int[][] map){

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

        if (value == 6)
            return true;

        return false;
    }


    public static boolean enemy(float x, float y, int width, int height, int[][] map){
        if (!CheckForEnemys(x,y,map)) {
            if (!CheckForEnemys(x + width, y + height, map)) {
                if (!CheckForEnemys(x + width, y, map)) {
                    if (!CheckForEnemys(x, y + height, map)) {
                        return true;
                    }
                }
            }
        }
        //System.out.println("Ik ben tegen de tile");
        return false;
    }

    private static boolean CheckForEnemys(float x,float y, int[][] map){

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


        int value = map[(int)yIndex-1 ][(int)xIndex -1];

        if (value == 7)
            return true;

        return false;
    }
}
