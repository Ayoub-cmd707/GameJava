package be.uantwerpen.fti.ei.geavanceerde.platform.visualistationPackage;

import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.enteties.AbstractInput;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class j2dInputs extends AbstractInput{
    private final LinkedList<Inputs> keyValues;
    public j2dInputs(JFrame frame) {
        frame.addKeyListener(new KeyInputAdapter());
        keyValues = new LinkedList<>();
    }

    @Override
    public Inputs getInputs() {
        if (!keyValues.isEmpty())
            return keyValues.poll();
        return Inputs.IDLE;
    }



    class KeyInputAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int keycode = e.getKeyCode();
            switch (keycode) {
                case KeyEvent.VK_LEFT : keyValues.add(Inputs.LEFT);  break;
                case KeyEvent.VK_RIGHT: keyValues.add(Inputs.RIGHT); break;
                case KeyEvent.VK_SPACE: keyValues.add(Inputs.JUMP); break;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT :
                case KeyEvent.VK_SPACE:
                case KeyEvent.VK_RIGHT:
                    keyValues.clear();  break;
            }
        }
    }
}
