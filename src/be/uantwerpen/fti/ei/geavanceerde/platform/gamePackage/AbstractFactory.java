package be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage;

import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.enteties.AbstractPlayer;
import be.uantwerpen.fti.ei.geavanceerde.platform.visualistationPackage.j2dInputs;

import java.io.IOException;

public abstract class AbstractFactory {
    public abstract AbstractPlayer createPlayer(int x, int y, int width, int height ) throws IOException;
    //public abstract AbstractLevel createLevel();
    //public abstract AbstractBackground Background();
    public abstract j2dInputs createInputs();
    public abstract void setGameDimensions(int CellX, int CellY);
    public abstract void render();
}
