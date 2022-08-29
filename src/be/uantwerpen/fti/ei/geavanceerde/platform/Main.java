package be.uantwerpen.fti.ei.geavanceerde.platform;

import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.AbstractFactory;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Game;
import be.uantwerpen.fti.ei.geavanceerde.platform.visualistationPackage.j2dFactory;
import be.uantwerpen.fti.ei.geavanceerde.platform.visualistationPackage2.j2dRectFactory;

import java.io.IOException;
/**
 * Main
 * @author Ayoub Aouraghe
 * */
public class Main {
    /**
     * main
     * @param args
     * @throws InterruptedException
     * @throws IOException
     */
    public static void main(String[] args) throws InterruptedException, IOException {
        AbstractFactory f = new j2dFactory("config.txt");
        //AbstractFactory f = new j2dRectFactory("config.txt");
        Game game = new Game(f);
        game.run("config.txt");

    }
}
