package be.uantwerpen.fti.ei.geavanceerde.platform.visualistationPackage2;

import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.enteties.AbstractPlayer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
/**
 * j2dRectPlayer
 * @author Ayoub Aouraghe
 * */
public class j2dRectPlayer extends AbstractPlayer {

    private final GraphicsContext graphicsContext;
    private float xDrawOffset = 0;
    private float yDrawOffset = 0;

    /**
     * j2dRectPlayer
     * @param grCtx
     * @param x
     * @param y
     * @param hitboxWidth
     * @param hitboxHeight
     * @throws IOException
     */
    public j2dRectPlayer(GraphicsContext grCtx, int x, int y, int hitboxWidth, int hitboxHeight) throws IOException {
        super(x,y,hitboxWidth,hitboxHeight);
        this.graphicsContext = grCtx;
    }


    /**
     * visualize function
     */
    @Override
    public void visualize() {
        Graphics2D graphics2D = graphicsContext.getG2d();


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
        graphics2D.setColor(Color.RED);
        if(getInput().toString()== "RIGHT"  ){

            graphics2D.fillRect((int)( getPosition().x- xDrawOffset)-graphicsContext.getCamX() +1,(int) (getPosition().y- yDrawOffset)-graphicsContext.getCamY(),64,64);
            graphics2D.setColor(Color.RED);
            graphics2D.drawRect((int)( getPosition().x- xDrawOffset)-graphicsContext.getCamX(),(int) (getPosition().y- yDrawOffset)-graphicsContext.getCamY(),64,64);

        }
        else if (getInput().toString()== "LEFT"){
            graphics2D.fillRect((int)( getPosition().x- xDrawOffset)-graphicsContext.getCamX()+ 64,(int) (getPosition().y- yDrawOffset)-graphicsContext.getCamY(),-64,64);
            //graphics2D.drawImage(runningAnimation[aniRunningIndex],((int) getPosition().x + 64)-1,(int) getPosition().y,-64,64,null);
            graphics2D.setColor(Color.RED);
            graphics2D.drawRect((int)( getPosition().x- xDrawOffset)-graphicsContext.getCamX(),(int) (getPosition().y- yDrawOffset)-graphicsContext.getCamY(),64,64);

        }
        else if (getInput().toString() == "IDLE" || getInput().toString()== "JUMP"){
            graphics2D.fillRect((int)( getPosition().x- xDrawOffset)-graphicsContext.getCamX(),(int) (getPosition().y- yDrawOffset)-graphicsContext.getCamY(),64,64);
            graphics2D.setColor(Color.RED);
            graphics2D.drawRect((int)( getPosition().x- xDrawOffset)-graphicsContext.getCamX(),(int) (getPosition().y- yDrawOffset)-graphicsContext.getCamY(),64,64);
        }


    }


}
