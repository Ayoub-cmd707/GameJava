package be.uantwerpen.fti.ei.geavanceerde.platform;

import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.AbstractFactory;
import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.Game;
import be.uantwerpen.fti.ei.geavanceerde.platform.visualistationPackage.j2dFactory;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        AbstractFactory f = new j2dFactory("config.txt");

        Game game = new Game(f);
        game.run("config.txt");
    }
}
