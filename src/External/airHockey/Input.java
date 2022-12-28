/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package External.airHockey;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

/**
 *
 * @author ahmed osama
 */
public class Input implements KeyListener {

    boolean[] keys;
    boolean anyKeyPressed;
            
    // JFRame must include to perform a keyListener
    public Input(JFrame frame) {
        frame.addKeyListener(this);
        keys = new boolean[200];
        for (int i = 0; i < keys.length; i++) {
            keys[i] = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        //System.out.println(e.getKeyText(e.getKeyCode()) + "code: " + e.getKeyCode());
        keys[e.getKeyCode()] = true;
        anyKeyPressed=true; 
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
        anyKeyPressed=false;

    }

    public boolean keyIsDown(int keyCode) {
        return keys[keyCode];
    }
       public boolean keyIsUp(int keyCode) {
        return !  keys[keyCode];
    }

    public boolean anyKeyPressed() {
        return anyKeyPressed;
    }

}
