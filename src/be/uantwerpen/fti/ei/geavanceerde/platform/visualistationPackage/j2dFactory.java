package be.uantwerpen.fti.ei.geavanceerde.platform.visualistationPackage;

import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.AbstractFactory;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.enteties.AbstractBackground;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.enteties.AbstractInput;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.enteties.AbstractLevel;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.enteties.AbstractPlayer;
import be.uantwerpen.fti.ei.geavanceerde.platform.helper.ConfigFileReader;

import java.io.IOException;
import java.util.HashMap;

public class j2dFactory extends AbstractFactory {

    private final GraphicsContext grCtx;
    public j2dFactory(String graphics_config) {
        HashMap<String, Integer> data = ConfigFileReader.getConfigFileReaderInstance().loadOrCreateConfig(graphics_config);
        this.grCtx = new GraphicsContext((int)(data.get("ScreenWidth")), (int)(data.get("ScreenHeight")));
    }

    /*@Override
    public AbstractInput createInput() {
        return new j2dInput(grCtx.getFrame());
    }*/


    @Override
    public void render() {
        this.grCtx.render();
    }

    @Override
    public AbstractPlayer createPlayer(int x, int y, int hitboxWidth, int hitboxHeight) throws IOException {
        return new j2dPlayer(grCtx, x, y,hitboxWidth,hitboxHeight);
    }

    /*@Override
    public AbstractBackground createBackground() {
        return new j2dBackground(grCtx);
    }



    @Override
    public AbstractLevel createLevel(int[][] tileArray, int TILES_IN_HEIGHT, int TILES_IN_WIDTH, int TILES_SIZE) {
        return new j2dLevel(grCtx,tileArray, TILES_IN_HEIGHT, TILES_IN_WIDTH, TILES_SIZE);
    }*/

    @Override
    public void setGameDimensions(int GameCellsX, int GameCellsY) {this.grCtx.setGameDimensions(GameCellsX, GameCellsY);}
}
