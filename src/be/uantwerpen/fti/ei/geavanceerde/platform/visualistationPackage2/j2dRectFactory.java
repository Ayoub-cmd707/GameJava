package be.uantwerpen.fti.ei.geavanceerde.platform.visualistationPackage2;

import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.AbstractFactory;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components.BonusComponent;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components.HealthComponent;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Components.ProjectileComponent;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.enteties.*;
import be.uantwerpen.fti.ei.geavanceerde.platform.helper.ConfigFileReader;

import java.io.IOException;
import java.util.HashMap;
/**
 * j2dRectFactory
 * @author Ayoub Aouraghe
 * */
public class j2dRectFactory extends AbstractFactory {

    private final GraphicsContext grCtx;

    /**
     * j2dRectFactory
     * @param graphics_config
     */
    public j2dRectFactory(String graphics_config) {
        HashMap<String, Integer> data = ConfigFileReader.getConfigFileReaderInstance().loadOrCreateConfig(graphics_config);
        this.grCtx = new GraphicsContext((int)(data.get("ScreenWidth")), (int)(data.get("ScreenHeight")));
    }

    /**
     * abstract factory implementation
     */



    @Override
    public void render() {
        this.grCtx.render();
    }


    @Override
    public AbstractPlayer createPlayer(int x, int y, int hitboxWidth, int hitboxHeight) throws IOException {
        return new j2dRectPlayer(grCtx, x, y,hitboxWidth,hitboxHeight);
    }

    @Override
    public AbstractBackground background() {
        return new j2dRectBackground(grCtx);
    }

    @Override
    public AbstractInput createInputs() {
        return new j2dRectInputs(grCtx.getFrame());
    }


    @Override
    public AbstractMap createAMap(int[][][] tileMap, int height, int width, int size) {
        return new j2dRectMap(grCtx,tileMap, height, width, size);
    }

    @Override
    public void setGameDimensions(int GameCellsX, int GameCellsY) {
        this.grCtx.setGameDimensions(GameCellsX, GameCellsY);
    }


    @Override
    public AbstractBonus abstractBonus(BonusComponent bonusComponent) {
        return new j2dRectCoinCounter(grCtx,bonusComponent);
    }

    @Override
    public AbstractHealth abstractHealth(HealthComponent healthComponent) {
        return new j2dRectHealthBar(grCtx,healthComponent);
    }

    @Override
    public AbstractProjectiles abstractProjectiles(ProjectileComponent projectileComponent) {
        return new j2dRectProjectile(grCtx,projectileComponent);
    }


}
