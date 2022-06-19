package be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage;

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
    private AbstractMap map;
    private Movement movement;
    HashMap<String, Integer> data;
    private ArrayList<Drawable> drawables;
    private AbstractInput inputs;

    //map settins
    public final static int tilePictureSize = 64;
    public final static int tilesWidth= 10;
    public final static int tilesHeight = 12;
    public final static int tileSize = (int)(tilePictureSize);

    //voor run
    double timingsPerFrame = 1000000000.0 / 61; //
    double updater =  1000000000.0 / 61;
    long pTime = System.nanoTime();
    long lastCheck = 0L;
    double deltaU = 0;
    double deltaF = 0;
    int fps = 0;
    int ups = 0;


    public Game(AbstractFactory abstractFactory) throws IOException {
        this.abstractFactory = abstractFactory;
        initGame();
    }

    public void initGame() throws IOException {
        inputs = abstractFactory.createInputs();
        abstractBackground = abstractFactory.background();
        abstractPlayer = abstractFactory.createPlayer(10,10,64,64);
        map = abstractFactory.createAMap(Maps.map1,tilesHeight,tilesWidth,tileSize);
        drawables = new ArrayList<>();


        drawables.add(abstractBackground);
        drawables.add(map);
        drawables.add(abstractPlayer);


        movement = new Movement(abstractPlayer.getMovement(), abstractPlayer.getPosition());

    }


    public void run(final String configFile){
        data = ConfigFileReader.getConfigFileReaderInstance().loadOrCreateConfig(configFile);
        abstractFactory.setGameDimensions((int)(data.get("ScreenWidth")), (int)(data.get("ScreenHeight")));

        while (true){
            long cTime = System.nanoTime();
            deltaU += (cTime - pTime) / updater;
            deltaF += (cTime - pTime) / timingsPerFrame;
            pTime = cTime;
            if(deltaU >= 1){

                //STATUS
                //statusCheck();
                //INPUTS
                AbstractInput.Inputs input = inputs.getInputs();
                System.out.println(input);
                if (inputs != null) {checkMovement(input);abstractPlayer.setDirection(input);}
                //SYSTEMS UPDATE
                //collisionSystem.updateCollision();
                movement.update();
                //bulletSystem.update();
                ups++;
                deltaU--;
            }

            if(deltaF >= 1){

                //DRAW
                for (Drawable drawable : drawables) {drawable.visualize();}
                //RENDER
                abstractFactory.render();
                fps++;
                deltaF--;
            }

            if(System.currentTimeMillis() - lastCheck >=1000){
                lastCheck = System.currentTimeMillis();
                fps = 0;
                ups = 0;
            }
        }

    }

    private void checkMovement(AbstractInput.Inputs inputs) {
        if (abstractPlayer.getMovement().isMoving() && inputs == AbstractInput.Inputs.LEFT) {
            abstractPlayer.getMovement().setLeft(true);
        }
        else if (abstractPlayer.getMovement().isMoving() && inputs == AbstractInput.Inputs.RIGHT) {
            abstractPlayer.getMovement().setRight(true);
        }
        else if(inputs == AbstractInput.Inputs.JUMPING){
            abstractPlayer.getMovement().setJump(true);
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

