package GUI.Games;

import Clients.SnakeLadderClient;
import GUI.JHome;
import GUI.jChat;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class jSnakeLadder extends javax.swing.JPanel {

    String CURRENT_PATH = System.getProperty("user.dir");
    BufferedImage[] dices;
    JPanel[] playerPosition;
    BufferedImage p1Icon;
    BufferedImage p2Icon;
    BufferedImage winnerIcon;
    int currenntP1Location = 1;
    int currenntP2Location = 1;

    public jSnakeLadder(JHome jh) {
        initComponents();

        _JHome = jh;

        client = new SnakeLadderClient(this);

        initChat();

        loadDiceImages();

        loadBoardImage();

        gridPlayerLocation();
    }

    private void initChat() {
        _jChat = new jChat(_JHome.logedInUser.username);
        chatPanel.add(_jChat);
        chatPanel.repaint();
        chatPanel.revalidate();
    }

    private void loadDiceImages() {
        dices = new BufferedImage[6];
        CURRENT_PATH = System.getProperty("user.dir");
        for (int i = 1; i <= 6; i++) {
            try {
                dices[i - 1] = ImageIO.read(new File(CURRENT_PATH + "\\src\\GUI\\Games\\dice\\dice" + i + ".png"));
            } catch (IOException ex) {
                Logger.getLogger(jSnakeLadder.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void loadBoardImage() {
        JPanel glass = new JPanel(new BorderLayout());
        glass.setSize(500, 500);

        BufferedImage img;
        try {
            p1Icon = ImageIO.read(new File(CURRENT_PATH + "\\src\\Icons\\player1.png"));
            p2Icon = ImageIO.read(new File(CURRENT_PATH + "\\src\\Icons\\player2.png"));
            winnerIcon = ImageIO.read(new File(CURRENT_PATH + "\\src\\Icons\\winner.png"));

            img = ImageIO.read(new File(CURRENT_PATH + "\\src\\Icons\\Snake & Ladder.jpg"));
            JLabel imgg = new JLabel();
            imgg.setIcon(new ImageIcon(img));
            glass.add(imgg, BorderLayout.CENTER);
        } catch (IOException ex) {
            Logger.getLogger(jSnakeLadder.class.getName()).log(Level.SEVERE, null, ex);
        }
        LayeredBoard.add(glass, 1);
    }

    private void gridPlayerLocation() {
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(new GridLayout(10, 10, 2, 2));
        playerPosition = new JPanel[100];
        int j = 1;
        for (int i = 0; i < 100; i++) {
            if (j == 21) {
                j = 1;
            }
            int boardIndex = 0;
            if ((i / 10) % 2 == 0) {
                boardIndex = 100 - i;
            } else {
                boardIndex = 90 - i + j;
                j += 2;
            }

            JPanel s = new JPanel();

            s.setOpaque(false);
            playerPosition[boardIndex - 1] = s;
            panel.add(s);
        }
        panel.setSize(500, 500);

        LayeredBoard.add(panel, Integer.valueOf(2));

        playerPosition[0].add(new JLabel(new ImageIcon(p1Icon)), BorderLayout.CENTER);
        playerPosition[0].add(new JLabel(new ImageIcon(p2Icon)), BorderLayout.CENTER);
    }

    //Move Client
    private void move(int step) {
        client.MOVE(step);
    }

    //UI Changes Functions
    public void showDialog(String message) {
        JOptionPane.showMessageDialog(_JHome, message);
    }

    public void setTextMessage(String message) {
        //Set the Text Message
        jMessage.setText(message);
    }

    public void setPlayerLocation(int location){
        if(location > 99) {
            playerPosition[99].add(new JLabel(new ImageIcon(winnerIcon)), BorderLayout.CENTER);
            return;
        }
        playerPosition[currenntP1Location - 1].removeAll();
        if(currenntP1Location == currenntP2Location) playerPosition[currenntP1Location - 1].add(new JLabel(new ImageIcon(p2Icon)), BorderLayout.CENTER);
            
        playerPosition[location - 1].add(new JLabel(new ImageIcon(p1Icon)), BorderLayout.CENTER);
        currenntP1Location = location;
        repaint();
        revalidate();
    }

    public void setOponentLocation(int location) {
        if(location > 99) {
            playerPosition[99].add(new JLabel(new ImageIcon(winnerIcon)), BorderLayout.CENTER);
            return;
        }
        playerPosition[currenntP2Location - 1].removeAll();
        if(currenntP1Location == currenntP2Location) playerPosition[currenntP1Location - 1].add(new JLabel(new ImageIcon(p1Icon)), BorderLayout.CENTER);
        
        playerPosition[location - 1].add(new JLabel(new ImageIcon(p2Icon)), BorderLayout.CENTER);
        currenntP2Location = location;
        repaint();
        revalidate();
    }

    public void quitGame() {
        client.QUIT();
        _jChat._ChatClient.QUIT();
        _JHome.home();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bBack = new javax.swing.JButton();
        UserPanel = new javax.swing.JPanel();
        UserNameLabel = new javax.swing.JLabel();
        UserAvatarIcon = new javax.swing.JLabel();
        GameName = new javax.swing.JLabel();
        dicePanel = new javax.swing.JPanel();
        bRollDice = new javax.swing.JButton();
        diceOneLabel = new javax.swing.JLabel();
        diceTwoLabel = new javax.swing.JLabel();
        chatPanel = new javax.swing.JPanel();
        gamePanel = new javax.swing.JPanel();
        jMessage = new javax.swing.JLabel();
        LayeredBoard = new javax.swing.JLayeredPane();

        setPreferredSize(new java.awt.Dimension(800, 550));

        bBack.setText("Quit");
        bBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bBackMouseClicked(evt);
            }
        });

        UserPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        UserNameLabel.setText("User name");

        UserAvatarIcon.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        UserAvatarIcon.setText("          Icon");

        javax.swing.GroupLayout UserPanelLayout = new javax.swing.GroupLayout(UserPanel);
        UserPanel.setLayout(UserPanelLayout);
        UserPanelLayout.setHorizontalGroup(
            UserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UserPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(UserNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(UserAvatarIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        UserPanelLayout.setVerticalGroup(
            UserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UserPanelLayout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(UserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(UserAvatarIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UserNameLabel))
                .addGap(22, 22, 22))
        );

        GameName.setFont(new java.awt.Font("Old English Text MT", 1, 18)); // NOI18N
        GameName.setText("Snake & Ladder");
        GameName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        dicePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bRollDice.setText("Roll Dice");
        bRollDice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bRollDiceMouseClicked(evt);
            }
        });

        diceOneLabel.setText("jLabel1");

        diceTwoLabel.setText("jLabel2");

        javax.swing.GroupLayout dicePanelLayout = new javax.swing.GroupLayout(dicePanel);
        dicePanel.setLayout(dicePanelLayout);
        dicePanelLayout.setHorizontalGroup(
            dicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dicePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(dicePanelLayout.createSequentialGroup()
                        .addComponent(diceOneLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addComponent(diceTwoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bRollDice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        dicePanelLayout.setVerticalGroup(
            dicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dicePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(diceTwoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(diceOneLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(7, 7, 7)
                .addComponent(bRollDice)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        chatPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        chatPanel.setLayout(new java.awt.CardLayout());

        gamePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jMessage.setBackground(new java.awt.Color(204, 204, 204));
        jMessage.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMessage.setText("message");
        jMessage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout LayeredBoardLayout = new javax.swing.GroupLayout(LayeredBoard);
        LayeredBoard.setLayout(LayeredBoardLayout);
        LayeredBoardLayout.setHorizontalGroup(
            LayeredBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        LayeredBoardLayout.setVerticalGroup(
            LayeredBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout gamePanelLayout = new javax.swing.GroupLayout(gamePanel);
        gamePanel.setLayout(gamePanelLayout);
        gamePanelLayout.setHorizontalGroup(
            gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gamePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LayeredBoard)
                    .addComponent(jMessage, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        gamePanelLayout.setVerticalGroup(
            gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gamePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LayeredBoard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bBack, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(GameName)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(chatPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dicePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(UserPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(gamePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bBack)
                            .addComponent(GameName))
                        .addGap(18, 18, 18)
                        .addComponent(UserPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dicePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chatPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(gamePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        chatPanel.getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents

    private void bBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBackMouseClicked
        int result = JOptionPane.showConfirmDialog(_JHome, "Sure? you want ot Quit?",
                "Game Station",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if (result == JOptionPane.YES_OPTION)
            quitGame();
    }//GEN-LAST:event_bBackMouseClicked

    // roll dice botton
    private void bRollDiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bRollDiceMouseClicked
        Random rand = new Random();
        int diceOne = rand.nextInt(6) + 1;
        int diceTwo = rand.nextInt(6) + 1;
        diceOneLabel.setIcon(new ImageIcon(dices[diceOne - 1]));
        diceTwoLabel.setIcon(new ImageIcon(dices[diceTwo - 1]));

        client.MOVE(diceOne + diceTwo);
    }//GEN-LAST:event_bRollDiceMouseClicked

    //Parent
    private JHome _JHome;
    private jChat _jChat;
    private SnakeLadderClient client;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel GameName;
    private javax.swing.JLayeredPane LayeredBoard;
    private javax.swing.JLabel UserAvatarIcon;
    private javax.swing.JLabel UserNameLabel;
    private javax.swing.JPanel UserPanel;
    private javax.swing.JButton bBack;
    private javax.swing.JButton bRollDice;
    private javax.swing.JPanel chatPanel;
    private javax.swing.JLabel diceOneLabel;
    private javax.swing.JPanel dicePanel;
    private javax.swing.JLabel diceTwoLabel;
    private javax.swing.JPanel gamePanel;
    private javax.swing.JLabel jMessage;
    // End of variables declaration//GEN-END:variables
}
