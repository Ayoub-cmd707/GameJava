package be.uantwerpen.fti.ei.geavanceerde.platform.visualistationPackage2;

import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.enteties.AbstractInput;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;
/**
 * j2dRectInputs
 * @author Ayoub Aouraghe
 * */
public class j2dRectInputs extends AbstractInput{
    private static HashMap<String, Boolean> keyValues;

    /**
     * j2dRectInputs
     * @param frame
     */
    public j2dRectInputs(JFrame frame) {
        frame.addKeyListener(new KeyInputAdapter());
        keyValues = new HashMap<>();
        keyValues.put("LEFT",false);
        keyValues.put("RIGHT",false);
        keyValues.put("SHOOT",false);
        keyValues.put("JUMPING",false);
        //System.out.println(keyValues);
    }

    /**
     * getInputs function
     * @return
     */
    @Override
    public Inputs getInputs() {
        for (Map.Entry<String, Boolean> me : keyValues.entrySet()) {
            if(me.getKey().equals("LEFT") && me.getValue().equals(true)){return Inputs.LEFT;}
            if(me.getKey().equals("RIGHT") && me.getValue().equals(true)){return Inputs.RIGHT;}
            if(me.getKey().equals("JUMPING") && me.getValue().equals(true)){return Inputs.JUMP;}
            if(me.getKey().equals("SHOOT") && me.getValue().equals(true)){return Inputs.SHOOT;}
        }
        return Inputs.IDLE;



    }

    /**
     * KeyInputAdapter function
     */
    static class KeyInputAdapter extends KeyAdapter {

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT -> keyValues.put("LEFT",false);
                case KeyEvent.VK_RIGHT -> keyValues.put("RIGHT",false);
                case KeyEvent.VK_SPACE -> keyValues.put("JUMPING",false);
                case KeyEvent.VK_ENTER -> keyValues.put("SHOOT",false);
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT -> keyValues.put("LEFT",true);
                case KeyEvent.VK_RIGHT -> keyValues.put("RIGHT",true);
                case KeyEvent.VK_SPACE -> keyValues.put("JUMPING",true);
                case KeyEvent.VK_ENTER -> keyValues.put("SHOOT",true);

            }
        }
    }
}
