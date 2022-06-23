package be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage;

import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.enteties.AbstractBackground;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.enteties.AbstractEnemy;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.enteties.AbstractMap;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.enteties.AbstractPlayer;
import be.uantwerpen.fti.ei.geavanceerde.platform.visualistationPackage.j2dInputs;

import java.io.IOException;

public abstract class AbstractFactory {
    public abstract AbstractPlayer createPlayer(int x, int y, int width, int height ) throws IOException;
    public abstract AbstractMap createAMap(int[][][] map, int tilesInHeight, int tilesInWidth, int tilesSize);
    public abstract AbstractBackground background();
    public abstract j2dInputs createInputs();
    public abstract void setGameDimensions(int CellX, int CellY);
    public abstract AbstractEnemy createEnemy(int x, int y, int width, int height ) throws IOException;
    public abstract void render();
}
