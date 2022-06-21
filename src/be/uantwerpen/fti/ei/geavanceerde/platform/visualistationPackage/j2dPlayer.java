package be.uantwerpen.fti.ei.geavanceerde.platform.visualistationPackage;

import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components.PositioningComponent;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.enteties.AbstractInput;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.enteties.AbstractPlayer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class j2dPlayer extends AbstractPlayer {

    private final GraphicsContext graphicsContext;
    private float xDrawOffset = 0;
    private float yDrawOffset = 0;
    private BufferedImage[] idleAnimation,runningAnimation;
    private int aniTick, aniRunningIndex,aniIdleIndex, aniSpeed = 3;

    public j2dPlayer(GraphicsContext grCtx, int x, int y, int hitboxWidth, int hitboxHeight) throws IOException {
        super(x,y,hitboxWidth,hitboxHeight);
        loadSprite();
        this.graphicsContext = grCtx;
    }

    private void update(){
        aniTick++;
        if (aniTick>= aniSpeed){
            aniTick = 0;
            aniRunningIndex++;
            aniIdleIndex++;

                if (aniRunningIndex >= runningAnimation.length){
                    aniRunningIndex =0;
                }

                if (aniIdleIndex >= idleAnimation.length){
                    aniIdleIndex =0;
                }


        }
    }


    private void loadSprite() throws IOException {
        idleAnimation = new BufferedImage[8];
        runningAnimation = new BufferedImage[6];
        BufferedImage imageIdle = ImageIO.read(new File("src/resources/Idle.png"));
        BufferedImage imageRunning = ImageIO.read(new File("src/resources/Run.png"));
        for (int i = 0; i < idleAnimation.length; i++) {
            idleAnimation[i] = imageIdle.getSubimage(i*64,0, 64,64);
        }

        for (int i = 0; i < runningAnimation.length; i++) {
            runningAnimation[i] = imageRunning.getSubimage(i*64,0, 64,64);
        }

    }

    @Override
    public void visualize() {
        Graphics2D graphics2D = graphicsContext.getG2d();
        update();

        //SIDEWAYS CAMERA MOVEMENT
        graphicsContext.setCamX((int)getPosition().x- graphicsContext.getViewPortX()/2);
        graphicsContext.setCamY((int)getPosition().y- graphicsContext.getViewPortY()/2);

        if (graphicsContext.getCamX() > graphicsContext.getOffsetMaxX()){
            graphicsContext.setCamX(graphicsContext.getOffsetMaxX());
        }
        else if (graphicsContext.getCamX() < graphicsContext.getOffsetMinX()){
            graphicsContext.setCamX(graphicsContext.getOffsetMinX());
        }
        if(graphicsContext.getCamY() > graphicsContext.getOffsetMaxY()){
            graphicsContext.setCamY(graphicsContext.getOffsetMaxY());
        }
        else if(graphicsContext.getCamY() < graphicsContext.getOffsetMinY()){
            graphicsContext.setCamY(graphicsContext.getOffsetMinY());
        }

        if(getInput().toString()== "RIGHT"){
            graphics2D.drawImage(runningAnimation[aniRunningIndex],(int)( getPosition().x- xDrawOffset)-graphicsContext.getCamX() +1,(int) (getPosition().y- yDrawOffset)-graphicsContext.getCamY(),64,64,null);
        }
        else if (getInput().toString()== "LEFT"){
            graphics2D.drawImage(runningAnimation[aniRunningIndex],(int)( getPosition().x- xDrawOffset)-graphicsContext.getCamX()+ 64,(int) (getPosition().y- yDrawOffset)-graphicsContext.getCamY(),-64,64,null);
            //graphics2D.drawImage(runningAnimation[aniRunningIndex],((int) getPosition().x + 64)-1,(int) getPosition().y,-64,64,null);
        }
        else if (getInput().toString() == "IDLE"){
            graphics2D.drawImage(idleAnimation[aniIdleIndex],(int)( getPosition().x- xDrawOffset)-graphicsContext.getCamX(),(int) (getPosition().y- yDrawOffset)-graphicsContext.getCamY(),64,64,null);
        }


    }


}
