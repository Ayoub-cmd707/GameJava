package be.uantwerpen.fti.ei.GamaJava;

public class Game {
    private Window window;
    private GraphicsContent graphicsContent;
    public Game(){
        graphicsContent = new GraphicsContent();
        window = new Window(graphicsContent);
    }
}
