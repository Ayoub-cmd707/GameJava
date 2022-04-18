package be.uantwerpen.fti.ei.GamaJava;

import javax.swing.*;
import java.awt.*;

public class GraphicsContent extends JPanel {

    public GraphicsContent() {

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.drawRect(100,100,200,50);
    }
}
