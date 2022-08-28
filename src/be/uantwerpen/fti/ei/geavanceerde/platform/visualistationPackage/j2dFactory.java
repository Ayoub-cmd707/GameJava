package be.uantwerpen.fti.ei.geavanceerde.platform.visualistationPackage;

import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.AbstractFactory;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components.BonusComponent;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.enteties.*;
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

    @Override
    public AbstractBackground background() {
        return new j2dBackground(grCtx);
    }

    @Override
    public j2dInputs createInputs() {
        return new j2dInputs(grCtx.getFrame());
    }


    @Override
    public AbstractMap createAMap(int[][][] tileMap, int height, int width, int size) {
        return new j2dMap(grCtx,tileMap, height, width, size);
    }

    @Override
    public void setGameDimensions(int GameCellsX, int GameCellsY) {
        this.grCtx.setGameDimensions(GameCellsX, GameCellsY);
    }

    @Override
    public AbstractEnemy createEnemy(int x, int y, int width, int height) throws IOException {
        return new j2dEnemy(grCtx,x,y,width,height);
    }

    @Override
    public AbstractBonus abstractBonus(BonusComponent bonusComponent) {
        return new j2dCoinCounter(grCtx,bonusComponent);
    }



}
