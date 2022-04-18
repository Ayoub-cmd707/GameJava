package be.uantwerpen.fti.ei.GamaJava;

import javax.swing.*;

public class Window {
    private JFrame jFrame;

    public Window(GraphicsContent graphicsContent) {
        jFrame = new JFrame();
        jFrame.setSize(400,400);

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.add(graphicsContent);



        jFrame.setVisible(true);
    }

}
