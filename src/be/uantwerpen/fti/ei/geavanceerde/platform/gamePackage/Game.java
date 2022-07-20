package be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage;

import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Systems.CollisionDetection;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Systems.LevelManagerSystem;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Systems.Movement;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.enteties.*;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.utilities.Maps;
import be.uantwerpen.fti.ei.geavanceerde.platform.helper.ConfigFileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * kladjklasjda
 */

public class Game {





    private final AbstractFactory abstractFactory;
    private AbstractPlayer abstractPlayer;
    private AbstractEnemy abstractEnemy;
    private AbstractBackground abstractBackground;
    private AbstractMap abstractMap;
    private Movement movement;
    private CollisionDetection collisionDetection;
    private LevelManagerSystem levelManagerSystem;
    HashMap<String, Integer> data;
    public static int gameWidth = 0;
    public static int gameHeigth =0;
    private AbstractInput inputs;

    //map settins
    public final static int tilePictureSize = 64;
    public final static float scale = 1.0f;
    public final static int tilesWidth= 25;
    public final static int tilesHeight = 11;
    public final static int tileSize = (int)(tilePictureSize*scale);

    //voor run



    public Game(AbstractFactory abstractFactory) throws IOException {
        this.abstractFactory = abstractFactory;
        initGame();
    }

    public void initGame() throws IOException {
        inputs = abstractFactory.createInputs();
        abstractBackground = abstractFactory.background();
        abstractPlayer = abstractFactory.createPlayer(70,50,64,64);
        abstractMap = abstractFactory.createAMap(Maps.maps,tilesHeight,tilesWidth,tileSize);
        movement = new Movement(abstractPlayer.getMovement(), abstractPlayer.getPosition(),abstractPlayer.getLevelComponent());
        collisionDetection = new CollisionDetection(abstractPlayer.getLevelComponent());
        levelManagerSystem = new LevelManagerSystem(abstractPlayer.getLevelComponent(),abstractPlayer.getPosition());
        abstractEnemy = abstractFactory.createEnemy(70 ,300,64,64);
    }

    private volatile boolean runWhile = false;
    public void run(final String configFile) {
        data = ConfigFileReader.getConfigFileReaderInstance().loadOrCreateConfig(configFile);
        abstractFactory.setGameDimensions((int)(data.get("ScreenWidth")), (int)(data.get("ScreenHeight")));
        gameWidth = data.get("ScreenWidth");
        gameHeigth = data.get("ScreenHeight");
        runWhile = true;
        double timePerFrame = 1000000000.0/30;
        double timePerUpdate = 1000000000.0/30;

        long previousTime = System.nanoTime();

        int frames = 0;
        int updates = 0;
        long lastCheck = System.currentTimeMillis();

        double deltaU = 0;
        double deltaF = 0;


        while (runWhile) {
            Thread.onSpinWait();

            long currentTime = System.nanoTime();

            deltaU += (currentTime - previousTime)/timePerUpdate;
            deltaF += (currentTime - previousTime)/timePerFrame;
            previousTime = currentTime;

            if(deltaU>=1){
                AbstractInput.Inputs input = inputs.getInputs();
                //if (input != AbstractInput.Inputs.IDLE)
                    //System.out.println(input);
                if (inputs != null) {
                    abstractPlayer.checkMovement(input);
                    abstractPlayer.setDirection(input);
                }
                movement.update();
                levelManagerSystem.updateLevel();
                updates++;
                deltaU--;
            }

            if(deltaF >=1){

                abstractBackground.visualize();
                abstractMap.visualize();
                abstractEnemy.visualize();
                abstractPlayer.visualize();

                abstractFactory.render();

                frames++;
                deltaF--;
            }

            if (System.currentTimeMillis() - lastCheck >= 1000) {
                lastCheck = System.currentTimeMillis();
				//System.out.println("FPS: " + frames + " | UPS: " + updates);
				frames = 0;
				updates = 0;

			}
        }

    }


}

