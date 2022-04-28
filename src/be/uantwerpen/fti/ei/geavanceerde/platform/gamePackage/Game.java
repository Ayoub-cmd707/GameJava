package be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage;

import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.enteties.AbstractInput;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.enteties.AbstractPlayer;
import be.uantwerpen.fti.ei.geavanceerde.platform.helper.ConfigFileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Game {

    private final AbstractFactory abstractFactory;
    private AbstractPlayer abstractPlayer;
    String configFile;
    HashMap<String, Integer> data;
    private ArrayList<Drawable> drawables;

    public Game(AbstractFactory abstractFactory) throws IOException {
        this.abstractFactory = abstractFactory;
        initGame();
    }

    public void initGame() throws IOException {
        abstractPlayer = abstractFactory.createPlayer(10,10,64,64);
        drawables = new ArrayList<>();
        drawables.add(abstractPlayer);
    }


    public void run(final String configFile){
        data = ConfigFileReader.getConfigFileReaderInstance().loadOrCreateConfig(configFile);
        abstractFactory.setGameDimensions((int)(data.get("ScreenWidth")), (int)(data.get("ScreenHeight")));
        double timePerFrame = 1000000000.0 / 61;
        double timerUpdate =  1000000000.0 / 61;
        long previousTime = System.nanoTime();
        int fps = 0;
        int ups = 0;
        long lastCheck = 0L;
        double deltaU = 0;
        double deltaF = 0;
        while (true){
            long currentTime = System.nanoTime();
            deltaU += (currentTime - previousTime) / timerUpdate;
            deltaF += (currentTime - previousTime) / timePerFrame;
            previousTime = currentTime;
           /* if(deltaU >= 1){

                //STATUS
                statusCheck();
                //INPUTS
                AbstractInput.Inputs inputs = input.getInput();
                if (inputs != null) {checkMovement(inputs);player.setDirection(inputs);}
                //SYSTEMS UPDATE
                collisionSystem.updateCollision();
                movementSystem.update();
                bulletSystem.update();
                ups++;
                deltaU--;
            }*/

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
}

