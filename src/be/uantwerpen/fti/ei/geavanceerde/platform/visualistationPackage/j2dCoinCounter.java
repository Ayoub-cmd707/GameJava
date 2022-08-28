package be.uantwerpen.fti.ei.geavanceerde.platform.visualistationPackage;

import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components.BonusComponent;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.enteties.AbstractBonus;

import java.awt.*;
import java.awt.image.BufferedImage;

public class j2dCoinCounter extends AbstractBonus {


    private final GraphicsContext graphicsC;
    private final Font font;
    private final BufferedImage coin;

    j2dCoinCounter(GraphicsContext graphicsContext, BonusComponent bonusComponent){
        super(bonusComponent);
        this.graphicsC = graphicsContext;
        font = new Font("Courier New",1,(int)(20));
        String coinImagePath = "src/resources/star.png";
        coin = this.graphicsC.loadImages(coinImagePath,(int)(30),(int)(30), false);

    }

    @Override
    public void visualize() {
        Graphics2D g2d = graphicsC.getG2d();
        g2d.setFont(font);
        g2d.setColor(Color.BLACK);
        g2d.drawString("x",(int)((graphicsC.getFrame().getWidth()/21)),(int)(30));
        String scr = String.valueOf(GetPoints());
        g2d.drawString(scr,(int)((graphicsC.getFrame().getWidth()/15)),(int)(30));
        g2d.drawImage(coin,(int)((graphicsC.getFrame().getWidth()/60)),(int)(10), null);

    }
}
