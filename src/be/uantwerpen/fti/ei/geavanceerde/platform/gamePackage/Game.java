package be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage;

import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components.BonusComponent;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components.ProjectileComponent;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Systems.*;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.enteties.*;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.utilities.Maps;
import be.uantwerpen.fti.ei.geavanceerde.platform.helper.ConfigFileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Game
 * @author Ayoub Aouraghe
 * */

public class Game {




    private ArrayList<Drawable> drawables;
    private final AbstractFactory abstractFactory;
    private AbstractPlayer abstractPlayer;
    private ArrayList<AbstractProjectiles> bullets;
    private AbstractHealth abstractHealth;
    private AbstractBackground abstractBackground;
    private AbstractMap abstractMap;
    private Movement movement;
    private CollisionDetection collisionDetection;
    private Bonus bonus;
    private Health health;
    private LevelManagerSystem levelManagerSystem;
    HashMap<String, Integer> data;
    public static int gameWidth = 0;
    public static int gameHeigth =0;
    private AbstractInput inputs;
    private AbstractBonus abstractBonus;
    private ProjectileSystem projectileSystem;
    //map settins
    public final static int tilePictureSize = 64;
    public final static float scale = 1.0f;
    public final static int tilesWidth= 25;
    public final static int tilesHeight = 11;
    public final static int tileSize = (int)(tilePictureSize*scale);
    private long fireTimer;
    private long fireDelay;
    //voor run


    /**
     * Game
     * @param abstractFactory
     * @throws IOException
     */
    public Game(AbstractFactory abstractFactory) throws IOException {
        this.abstractFactory = abstractFactory;
        initGame();
    }

    /**
     * initGame function
     * Initialize the game assets
     * @throws IOException
     */
    public void initGame() throws IOException {
        bullets = new ArrayList<AbstractProjectiles>();
        inputs = abstractFactory.createInputs();
        abstractBackground = abstractFactory.background();
        abstractPlayer = abstractFactory.createPlayer(70,50,30,15);
        abstractMap = abstractFactory.createAMap(Maps.maps,tilesHeight,tilesWidth,tileSize);
        abstractBonus = abstractFactory.abstractBonus(abstractPlayer.getBonusComponent());
        abstractHealth = abstractFactory.abstractHealth(abstractPlayer.getHealthComponent());
        movement = new Movement(abstractPlayer.getMovement(), abstractPlayer.getPosition(),abstractPlayer.getLevelComponent());
        collisionDetection = new CollisionDetection(abstractPlayer.getLevelComponent());

        levelManagerSystem = new LevelManagerSystem(abstractPlayer.getLevelComponent(),abstractPlayer.getPosition());

        projectileSystem = new ProjectileSystem(bullets);
        bonus = new Bonus(abstractPlayer.getCollisionComponent(),abstractPlayer.getPosition(),abstractPlayer.getBonusComponent(),abstractPlayer.getLevelComponent());
        health = new Health(abstractPlayer.getCollisionComponent(),abstractPlayer.getPosition(),abstractPlayer.getMovement(),abstractPlayer.getHealthComponent(),abstractPlayer.getLevelComponent());
        drawables = new ArrayList<Drawable>();
        drawables.addAll(bullets);

        fireTimer = System.nanoTime();
        fireDelay = 200;
    }

    private volatile boolean runWhile = false;

    /**
     * run function
     * running the gameloop here
     * @param configFile
     */
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

                if (inputs != null) {
                    abstractPlayer.checkMovement(input);
                    abstractPlayer.setDirection(input);
                    projectileMovement(input);
                }
                movement.update();
                levelManagerSystem.updateLevel();
                projectileSystem.update();
                bonus.coincheck();
                health.CheckForhealth();

                updates++;
                deltaU--;
            }

            if(deltaF >=1){

                abstractBackground.visualize();
                abstractMap.visualize();
                abstractPlayer.visualize();
                abstractBonus.visualize();
                abstractHealth.visualize();

                //for bullets
                for (Drawable drawable : drawables) {
                    drawable.visualize();
                }
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

    /**
     * projectileMovement function
     * Movements for the bullets
     * @param inputs
     */

    private void projectileMovement(AbstractInput.Inputs inputs){
        if (inputs == AbstractInput.Inputs.SHOOT) {
            //FIRE BULLETS
            long elapsed = (System.nanoTime() - fireTimer) / 1000000;
            if (elapsed > fireDelay) {
                if(abstractPlayer.getMovement().isLeft()){bullets.add(abstractFactory.abstractProjectiles(new ProjectileComponent("PLAYER", abstractPlayer.getPosition().x-100, abstractPlayer.getPosition().y, 25, 16, -270, 5, data.get("ScreenWidth"), data.get("ScreenHeight"), 2)));}
                else if(abstractPlayer.getMovement().isRight()){bullets.add(abstractFactory.abstractProjectiles(new ProjectileComponent("PLAYER", abstractPlayer.getPosition().x, abstractPlayer.getPosition().y, 25, 16, 270, 5, data.get("ScreenWidth"), data.get("ScreenHeight"), 2)));}
                else{bullets.add(abstractFactory.abstractProjectiles(new ProjectileComponent("PLAYER", abstractPlayer.getPosition().x, abstractPlayer.getPosition().y, 25, 16, 270, 5, data.get("ScreenWidth"), data.get("ScreenHeight"), 2)));}
                fireTimer = System.nanoTime();
                drawables.addAll(bullets);
                System.out.println(bullets.size());
            }
        }
    }

}

