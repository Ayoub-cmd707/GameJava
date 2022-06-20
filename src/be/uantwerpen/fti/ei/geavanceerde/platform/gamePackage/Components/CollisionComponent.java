package be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components;

import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Game;
import be.uantwerpen.fti.ei.geavanceerde.platform.helper.ConfigFileReader;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.HashMap;

public class CollisionComponent {
   protected float x,y;
   protected int width, height;
   protected Rectangle hitBox;

   public static float positionX;
   public static float positionY;

    public CollisionComponent(float x, float y, int width, int height ) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        initHitbox();
        
    }


    private void initHitbox() {
        hitBox = new Rectangle((int) x,(int) y,width,height);
    }

    protected void updateHitbox(){
        hitBox.x = (int) x;
        hitBox.y = (int) y;
    }

    public Rectangle getHitBox(){
        return hitBox;
    }




}
