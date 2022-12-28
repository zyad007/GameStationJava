/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package External.airHockey;

import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JFrame;

/**
 *
 * @author ahmed osama
 */
public class welcome extends GamePanel {

    public welcome(JFrame frame) {
        super(frame);
    }

    @Override
    public void draw(Graphics g) {

        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 10));
        g.drawString("WELCOME", 20, 20);
        g.drawString("press any key to play", 200, 200);
    }

    @Override
    public void action() {

            if (input.anyKeyPressed()) {}
            //    StartMenu = false;
                }   

}
