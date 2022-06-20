package be.uantwerpen.fti.ei.geavanceerde.platform.visualistationPackage;

import be.uantwerpen.fti.ei.geavanceerde.platform.gamePackage.enteties.AbstractInput;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class j2dInputs extends AbstractInput{
    //private static HashMap<String, Boolean> keyValues;
    private LinkedList<Inputs> keyValues;
    public j2dInputs(JFrame frame) {
        frame.addKeyListener(new KeyInputAdapter());
        //keyValues = new HashMap<>();
        //keyValues.put("LEFT",false);
        //keyValues.put("RIGHT",false);
        //System.out.println(keyValues);
        keyValues = new LinkedList<Inputs>();
    }

    @Override
    public Inputs getInputs() {
        /*for (Map.Entry<String, Boolean> me : keyValues.entrySet()) {
            if(me.getKey().equals("LEFT") && me.getValue().equals(true)){
                System.out.println("Ik ben left aan het returnnen");
                return Inputs.LEFT;
            }
            if(me.getKey().equals("RIGHT") && me.getValue().equals(true)){

                System.out.println("Ik ben right aan het returnnen");
                return Inputs.RIGHT;
            }
            if(me.getKey().equals("LEFT") && me.getValue().equals(false)){
                System.out.println("ik zit in idle left");
                return Inputs.IDLE;
            }
            if(me.getKey().equals("RIGHT") && me.getValue().equals(false)){
                System.out.println("ik zit in idle right");
                return Inputs.IDLE;
            }
          }
        return Inputs.IDLE;*/
        if (!keyValues.isEmpty())
            return keyValues.poll();
        return Inputs.IDLE;
    }


    /*static class KeyInputAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    keyValues.put("LEFT",false);
                    System.out.println("Left released");
                    break;
                case KeyEvent.VK_RIGHT:
                    keyValues.put("RIGHT",false);
                    System.out.println("Right released");
                    break;
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    keyValues.put("LEFT",true);
                    System.out.println("left pressed");
                    break;
                case KeyEvent.VK_RIGHT :
                    keyValues.put("RIGHT",true);
                    System.out.println("right pressed " + keyValues.get("RIGHT"));
                    break;
            }
        }
    }*/
    class KeyInputAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int keycode = e.getKeyCode();
            switch (keycode) {
                case KeyEvent.VK_LEFT : keyValues.add(Inputs.LEFT);  break;
                case KeyEvent.VK_RIGHT: keyValues.add(Inputs.RIGHT); break;

            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT : keyValues.clear();  break;
                case KeyEvent.VK_RIGHT: keyValues.clear(); break;
            }
        }
    }
}
