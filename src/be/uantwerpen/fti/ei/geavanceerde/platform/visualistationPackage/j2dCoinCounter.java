package be.uantwerpen.fti.ei.geavanceerde.platform.visualistationPackage;

import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components.BonusComponent;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.enteties.AbstractBonus;

import java.awt.*;
import java.awt.image.BufferedImage;
/**
 * j2dCoinCounter
 * @author Ayoub Aouraghe
 * */
public class j2dCoinCounter extends AbstractBonus {


    private final GraphicsContext graphicsC;
    private final Font font;
    private final BufferedImage coin;

    /**
     * j2dCoinCounter
     * @param graphicsContext
     * @param bonusComponent
     */
    public j2dCoinCounter(GraphicsContext graphicsContext, BonusComponent bonusComponent){
        super(bonusComponent);
        this.graphicsC = graphicsContext;
        font = new Font("Aharoni",1,(int)(20));
        String coinImagePath = "src/resources/star.png";
        coin = this.graphicsC.loadImages(coinImagePath,(int)(30),(int)(30), false);

    }

    /**
     * visualize function
     */
    @Override
    public void visualize() {
        Graphics2D graphics2D = graphicsC.getG2d();
        graphics2D.setFont(font);
        graphics2D.setColor(Color.BLACK);
        graphics2D.drawString(":",(int)((graphicsC.getFrame().getWidth()/21)),(int)(30));
        String s = String.valueOf(GetPoints());
        graphics2D.drawString(s,(int)((graphicsC.getFrame().getWidth()/15)),(int)(30));
        graphics2D.drawImage(coin,(int)((graphicsC.getFrame().getWidth()/60)),(int)(10), null);

    }
}
