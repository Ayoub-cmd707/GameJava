package be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage;

import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.enteties.AbstractBackground;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.enteties.AbstractInput;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.enteties.AbstractLevel;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.enteties.AbstractPlayer;

import java.io.IOException;

public abstract class AbstractFactory {
    public abstract AbstractPlayer createPlayer(int x, int y, int width, int height ) throws IOException;
    //public abstract AbstractLevel createLevel();
    //public abstract AbstractBackground Background();
    //public abstract AbstractInput createInputs();
    public abstract void setGameDimensions(int CellX, int CellY);
    public abstract void render();
}
