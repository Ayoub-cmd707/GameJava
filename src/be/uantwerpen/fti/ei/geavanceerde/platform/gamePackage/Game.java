package be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage;

import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Systems.CollisionDetection;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Systems.Movement;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.enteties.AbstractBackground;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.enteties.AbstractInput;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.enteties.AbstractMap;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.enteties.AbstractPlayer;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.utilities.Maps;
import be.uantwerpen.fti.ei.geavanceerde.platform.helper.ConfigFileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Game {





    private final AbstractFactory abstractFactory;
    private AbstractPlayer abstractPlayer;
    private AbstractBackground abstractBackground;
    private AbstractMap abstractMap;
    private Movement movement;
    private CollisionDetection collisionDetection;
    HashMap<String, Integer> data;
    public static int gameWidth = 0;
    public static int gameHeigth =0;
    private AbstractInput inputs;

    //map settins
    public final static int tilePictureSize = 64;
    public final static float scale = 1.0f;
    public final static int tilesWidth= 10;
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
        abstractMap = abstractFactory.createAMap(Maps.map1,tilesHeight,tilesWidth,tileSize);
        movement = new Movement(abstractPlayer.getMovement(), abstractPlayer.getPosition());
        collisionDetection = new CollisionDetection();
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
                System.out.println(input);
                if (inputs != null) {
                    checkMovement(input);
                    abstractPlayer.setDirection(input);
                }
                movement.update();
                updates++;
                deltaU--;
            }

            if(deltaF >=1){

                abstractBackground.visualize();
                abstractMap.visualize();
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

    private void checkMovement(AbstractInput.Inputs inputs) {


            if (abstractPlayer.getMovement().isMoving() && inputs == AbstractInput.Inputs.LEFT) {
                abstractPlayer.getMovement().setLeft(true);
                abstractPlayer.getMovement().setRight(true);
            } else if (abstractPlayer.getMovement().isMoving() && inputs == AbstractInput.Inputs.RIGHT) {
                abstractPlayer.getMovement().setRight(true);
                abstractPlayer.getMovement().setLeft(false);
            } else {
                abstractPlayer.getMovement().setRight(false);
                abstractPlayer.getMovement().setLeft(false);
            }

        /*else if(inputs == AbstractInput.Inputs.ATTACKING){
            //FIRE BULLETS
            long elapsed = (System.nanoTime() - firingTimer) / 1000000;
            if(elapsed > firingDelay){
                bullets.add(factory.createBullet(new BulletComponent(player.getPositionComponent().x,player.getPositionComponent().y, 270,5,data.get("ScreenWidth"),data.get("ScreenHeight"),2)));
                firingTimer = System.nanoTime();
                drawables.addAll(bullets);
            }
        }
        else{
            player.getMovementComponent().setLeft(false);
            player.getMovementComponent().setRight(false);
        }*/
    }
}

