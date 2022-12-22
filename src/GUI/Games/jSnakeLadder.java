package GUI.Games;
import Clients.SnakeLadderClient;
import GUI.JHome;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class jSnakeLadder extends javax.swing.JPanel{
    
    public jSnakeLadder(JHome jh) {
        initComponents();
        
        _JHome = jh;
        
        client = new SnakeLadderClient(this);
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
    
    public void setPlayerLocation(int location) {
        //Move player to location
    }
    
    public void setOponentLocation(int location) {
        //Move player to Oponent
    }
    
    public void quitGame() {
        client.QUIT();
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
        diceTwoPanel = new javax.swing.JPanel();
        diceOnePanel = new javax.swing.JPanel();
        chatPanel = new javax.swing.JPanel();
        enterMsg = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        chatArea = new javax.swing.JTextArea();
        bSend = new javax.swing.JButton();
        gamePanel = new javax.swing.JPanel();
        jMessage = new javax.swing.JLabel();
        Board = new javax.swing.JLabel();

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        diceTwoPanel.setPreferredSize(new java.awt.Dimension(100, 100));

        javax.swing.GroupLayout diceTwoPanelLayout = new javax.swing.GroupLayout(diceTwoPanel);
        diceTwoPanel.setLayout(diceTwoPanelLayout);
        diceTwoPanelLayout.setHorizontalGroup(
            diceTwoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        diceTwoPanelLayout.setVerticalGroup(
            diceTwoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        diceOnePanel.setPreferredSize(new java.awt.Dimension(100, 100));

        javax.swing.GroupLayout diceOnePanelLayout = new javax.swing.GroupLayout(diceOnePanel);
        diceOnePanel.setLayout(diceOnePanelLayout);
        diceOnePanelLayout.setHorizontalGroup(
            diceOnePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        diceOnePanelLayout.setVerticalGroup(
            diceOnePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout dicePanelLayout = new javax.swing.GroupLayout(dicePanel);
        dicePanel.setLayout(dicePanelLayout);
        dicePanelLayout.setHorizontalGroup(
            dicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dicePanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(dicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dicePanelLayout.createSequentialGroup()
                        .addComponent(diceOnePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(diceTwoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))
                    .addGroup(dicePanelLayout.createSequentialGroup()
                        .addComponent(bRollDice, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        dicePanelLayout.setVerticalGroup(
            dicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dicePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(diceOnePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(diceTwoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bRollDice)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        chatPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        enterMsg.setText("enter text here");

        chatArea.setEditable(false);
        chatArea.setColumns(18);
        chatArea.setRows(5);
        chatArea.setText("Chat ");
        chatArea.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        chatArea.setFocusable(false);
        jScrollPane1.setViewportView(chatArea);

        bSend.setText("Send");

        javax.swing.GroupLayout chatPanelLayout = new javax.swing.GroupLayout(chatPanel);
        chatPanel.setLayout(chatPanelLayout);
        chatPanelLayout.setHorizontalGroup(
            chatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chatPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(chatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(chatPanelLayout.createSequentialGroup()
                        .addComponent(enterMsg)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bSend)))
                .addContainerGap())
        );
        chatPanelLayout.setVerticalGroup(
            chatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, chatPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(chatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(enterMsg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bSend))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gamePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jMessage.setBackground(new java.awt.Color(204, 204, 204));
        jMessage.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMessage.setText("message");
        jMessage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Board.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Snake & Ladder.jpg"))); // NOI18N

        javax.swing.GroupLayout gamePanelLayout = new javax.swing.GroupLayout(gamePanel);
        gamePanel.setLayout(gamePanelLayout);
        gamePanelLayout.setHorizontalGroup(
            gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gamePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Board))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        gamePanelLayout.setVerticalGroup(
            gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gamePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(Board)
                .addContainerGap())
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(gamePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                        .addComponent(chatPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        if(result == JOptionPane.YES_OPTION) quitGame();
    }//GEN-LAST:event_bBackMouseClicked
    
    
    // roll dice botton
    private void bRollDiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bRollDiceMouseClicked
        // TODO add your handling code here:
//        Random rand = new Random();
//        int diceOne = rand.nextInt(1,7);
//        int diceTwo = rand.nextInt(1,7);
//        JLabel diceOneImg = ImageHandler.loadImage("dice/dice"+diceOne+".png");
//        JLabel diceTwoImg = ImageHandler.loadImage("dice/dice"+diceTwo+".png");
//        diceOnePanel.add(diceOneImg);
//        diceTwoPanel.add(diceTwoImg);
//        diceOnePanel.repaint();
           JLabel imgLabel = new JLabel(new ImageIcon("C:\\Users\\Zyad\\Desktop\\Java Projcet\\GameStation\\src\\GUI\\Games\\dice\\dice1.png"));
           diceOnePanel.add(imgLabel);
           diceOnePanel.repaint();
    }//GEN-LAST:event_bRollDiceMouseClicked
          
    //Parent
    private JHome _JHome;
    private SnakeLadderClient client;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Board;
    private javax.swing.JLabel GameName;
    private javax.swing.JLabel UserAvatarIcon;
    private javax.swing.JLabel UserNameLabel;
    private javax.swing.JPanel UserPanel;
    private javax.swing.JButton bBack;
    private javax.swing.JButton bRollDice;
    private javax.swing.JButton bSend;
    private javax.swing.JTextArea chatArea;
    private javax.swing.JPanel chatPanel;
    private javax.swing.JPanel diceOnePanel;
    private javax.swing.JPanel dicePanel;
    private javax.swing.JPanel diceTwoPanel;
    private javax.swing.JTextField enterMsg;
    private javax.swing.JPanel gamePanel;
    private javax.swing.JLabel jMessage;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
