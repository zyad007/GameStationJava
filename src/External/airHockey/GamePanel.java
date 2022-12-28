/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package External.airHockey;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.JPanel;

/**
 *
 * @author ahmed osama
 */
public abstract class GamePanel extends JPanel {

    protected Timer timer;
    protected Input input;
  
    public GamePanel(JFrame frame) {
        
           this.setBackground(Color.BLACK);
        input = new Input(frame);
        timer = new Timer(10, null);
        timer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                repaint();
                action();

            }

        });

        timer.start();

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        draw(g);

    }

    public abstract void draw(Graphics g);

    public abstract void action();
}
