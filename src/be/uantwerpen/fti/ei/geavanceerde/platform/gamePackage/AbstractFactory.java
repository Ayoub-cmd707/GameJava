package be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage;

import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components.BonusComponent;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components.HealthComponent;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components.ProjectileComponent;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.enteties.*;
import be.uantwerpen.fti.ei.geavanceerde.platform.visualistationPackage.j2dInputs;

import java.io.IOException;
/**
 * AbstractFactory
 * @author Ayoub Aouraghe
 * */
public abstract class AbstractFactory {
    public abstract AbstractPlayer createPlayer(int x, int y, int width, int height ) throws IOException;
    public abstract AbstractMap createAMap(int[][][] map, int tilesInHeight, int tilesInWidth, int tilesSize);
    public abstract AbstractBackground background();
    public abstract AbstractInput createInputs();
    public abstract void setGameDimensions(int CellX, int CellY);
    public abstract AbstractBonus abstractBonus(BonusComponent bonusComponent);
    public abstract AbstractHealth abstractHealth(HealthComponent healthComponent);
    public abstract AbstractProjectiles abstractProjectiles(ProjectileComponent projectileComponent);
    public abstract void render();

}
