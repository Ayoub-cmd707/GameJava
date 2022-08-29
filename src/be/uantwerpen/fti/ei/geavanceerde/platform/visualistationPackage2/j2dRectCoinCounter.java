package be.uantwerpen.fti.ei.geavanceerde.platform.visualistationPackage2;

import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components.BonusComponent;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.enteties.AbstractBonus;

import java.awt.*;
import java.awt.image.BufferedImage;
/**
 * j2dRectCoinCounter
 * @author Ayoub Aouraghe
 * */
public class j2dRectCoinCounter extends AbstractBonus {


    private final GraphicsContext graphicsC;


    j2dRectCoinCounter(GraphicsContext graphicsContext, BonusComponent bonusComponent){
        super(bonusComponent);
        this.graphicsC = graphicsContext;


    }

    @Override
    public void visualize() {
        Graphics2D graphics2D = graphicsC.getG2d();

        graphics2D.setColor(Color.YELLOW);
        graphics2D.drawString(":",(int)((graphicsC.getFrame().getWidth()/21)),(int)(30));
        String s = String.valueOf(GetPoints());
        graphics2D.drawString(s,(int)((graphicsC.getFrame().getWidth()/15)),(int)(30));
        graphics2D.fillRect((int)((graphicsC.getFrame().getWidth()/60)),(int)(10), 60, 60);

    }
}
