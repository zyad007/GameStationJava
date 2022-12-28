/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package External.airHockey;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import java.util.Random;
import static javafx.scene.input.KeyCode.Y;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author ahmed osama
 */
public class GamePanelClass extends GamePanel {

    int xBall;
    int yBall;
    int xSpeed;
    int ySpeed;
    int Board1;
    int Board2;
    int score1;
    //boolean down;
    //int lives;
    int score2;
    boolean incSpeed1 = false;
    boolean incSpeed2 = false;
    boolean Flag = false;
    int player;
    int XBoard1;
    int XBoard2;

    public GamePanelClass(JFrame frame) {

        super(frame);
        xBall = 50;
        yBall = 50;
        Board1 = 225;
        Board2 = 225;
        xSpeed = 5;
        ySpeed = 5;
        //lives = 2;
        score1 = 0;
        score2 = 0;
        XBoard1 = 100;
        XBoard2 = 100;

    }

    @Override
    public void draw(Graphics g) {
        //Start message
        if (Flag == false) {
            startMessage(g);
        }

        //Score: 
        Font font = new Font("Verdana", Font.BOLD, 10);
        g.setFont(font);
        g.setColor(Color.WHITE);
        g.drawString(
                "Score Player1 : " + score1, 360, 40);
        g.drawString(
                "Score Player2 : " + score2, 360, 390);

        //Ball position
        g.fillOval(xBall, yBall, 10, 10);

        g.setColor(Color.BLUE);
        // Dec Board
        switch (score1) {
            case 0:
                g.fillRect(Board2, 50, XBoard1, 10);
            case 1:

                g.fillRect(Board2, 50, XBoard1, 10);
            case 2:

                g.fillRect(Board2, 50, XBoard1, 10);
            case 3:

                g.fillRect(Board2, 50, XBoard1, 10);
            case 4:

                g.fillRect(Board2, 50, XBoard1, 10);
            case 5:

                g.fillRect(Board2, 50, XBoard1, 10);

        }

        g.setColor(Color.RED);
        switch (score2) {
            case 0:
                g.fillRect(Board1, 400, XBoard2, 10);
            case 1:

                g.fillRect(Board1, 400, XBoard2, 10);
            case 2:

                g.fillRect(Board1, 400, XBoard2, 10);
            case 3:

                g.fillRect(Board1, 400, XBoard2, 10);
            case 4:

                g.fillRect(Board1, 400, XBoard2, 10);
            case 5:

                g.fillRect(Board1, 400, XBoard2, 10);

        }

        //Winner message
        g.setColor(Color.WHITE);
        font = new Font("Verdana", Font.BOLD, 18);

        g.setFont(font);

        winner(g);
    }

    @Override
    public void action() {
        //Start Game
        if (input.keyIsDown(KeyEvent.VK_ENTER)) {
            Flag = true;
        }
        if (Flag == true) {

            // Play until anyone reaches score 5
            if (score1 < 5 && score2 < 5) {
                //Ball move
                xBall += xSpeed;
                yBall += ySpeed;
                // inc Score
                if (yBall <= 0) {
                    ySpeed *= -1;
                    incSpeed1 = false;
                    XBoard2 -= 10;
                    score2++;
                }
                if (yBall >= 450) {
                    ySpeed *= -1;
                    incSpeed2 = false;
                    XBoard1 -= 10;
                    score1++;
                }

                if (xBall + xSpeed < 0 || xBall + xSpeed >= 500) {
                    xSpeed *= -1;
                }

                //Input from User
                if (input.keyIsDown(KeyEvent.VK_RIGHT)) {
                    //
                    Board1 += 8;
                    //Send to server Right true 
                }
                if (input.keyIsDown(KeyEvent.VK_LEFT)) {
                    Board1 -= 8;
                }
                if (input.keyIsDown(KeyEvent.VK_A)) {
                    Board2 -= 8;
                }
                if (input.keyIsDown(KeyEvent.VK_D)) {
                    Board2 += 8;
                }

                //Player2 reaction
                if (yBall >= 400 && yBall <= 410 && xBall >= Board1 && xBall <= Board1 + XBoard2 ) {
                      incSpeed2 = true;
                    if (ySpeed < 0) {
                        ySpeed *= -1;
                        xBall -= 5;
                        yBall += 5;
                    } else {
                        ySpeed *= -1;
                        xBall += 5;
                        yBall -= 5;
                    }
                  

                }

                // Player1 reaction
                if (yBall >= 50 && yBall <= 60 && xBall >= Board2 && xBall <= Board2 + XBoard1) {
                      incSpeed1 = true;
                    if (ySpeed > 0) {
                        ySpeed *= -1;
                        xBall += 5;
                        yBall -= 5;
                    } else {
                        ySpeed *= -1;
                        xBall -= 5;
                        yBall += 5;
                    }
                  

                }
                if (incSpeed1 == true && incSpeed2 == true) {
                    xSpeed++;
                    ySpeed++;
                    incSpeed1 = false;
                    incSpeed2 = false;
                }
            }
            //Winner message
        }
    }

    private boolean winner(Graphics g) {
        if (score1 >= 5) {
            g.drawString("Player1 win", 190, 200);

            return true;

        } else if (score2 >= 5) {
            g.drawString("Player2 win", 190, 200);

            return true;
        } else {
            return false;
        }
    }

    private void startMessage(Graphics g) {
        Font font = new Font("Verdana", Font.BOLD, 15);
        g.setFont(font);
        g.setColor(Color.white);
        g.drawString("Pls Press enter to start the game", 110, 200);
    }

}
