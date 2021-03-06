package be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.enteties;

import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components.CollisionComponent;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components.PositioningComponent;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Drawable;

public abstract class AbstractEnemy implements Drawable {
    private final PositioningComponent positionComponent;
    private final CollisionComponent collisionComponent;

    public AbstractEnemy(int x, int y , int width, int height) {
        this.positionComponent = new PositioningComponent(x,y,height,width);
        this.collisionComponent = new CollisionComponent(x,y,width,height);
    }

    public PositioningComponent getPositionComponent() {
        return positionComponent;
    }

    public CollisionComponent getCollisionComponent() {
        return collisionComponent;
    }
}
