package be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.enteties;

import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components.ProjectileComponent;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Drawable;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
/**
 * AbstractProjectiles
 * @author Ayoub Aouraghe
 * */
public abstract class AbstractProjectiles implements Drawable {

    private final ProjectileComponent projectileComponent;

    /**
     * AbstractProjectiles
     * @param projectileComponent
     */
    public AbstractProjectiles(ProjectileComponent projectileComponent){
        this.projectileComponent = projectileComponent;
    }

    /**
     * function for making the image readable
     * @param fileName
     * @return
     */
    public BufferedImage GetSpriteSheet(String fileName) {

        BufferedImage bufferedImage = null;


        try {
            bufferedImage = ImageIO.read(new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bufferedImage;
    }

    /**
     * getters and setters
     * @return
     */
    public ProjectileComponent getProjectileComponent(){return projectileComponent;}
    public double getX(){return projectileComponent.getX();}
    public double getY(){return projectileComponent.getY();}
    public int getR(){return projectileComponent.getR();}


}
