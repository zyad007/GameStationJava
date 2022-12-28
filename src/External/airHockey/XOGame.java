/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package External.airHockey;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author ahmed osama
 */
public class XOGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        JFrame frame = new JFrame("Game");

        frame.setSize(500, 500);
      
        frame.getContentPane().setBackground(Color.black);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        GamePanelClass gameclass = new GamePanelClass(frame);
        //welcome wel =new welcome(frame);
        frame.add(gameclass);

        frame.setVisible(true);

    }

}
