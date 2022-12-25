/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.Games;

import Clients.Connect4Client;
import GUI.JHome;
import GUI.jChat;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Zyad
 */
public class jConnect4 extends javax.swing.JPanel {
    String CURRENT_PATH = System.getProperty("user.dir");
    JPanel[] playerPosition;
    BufferedImage p1Icon;
    BufferedImage p2Icon;
    Connect4Client client;
    
    public jConnect4(JHome jh) {
        initComponents();
        
        setBackground(new Color(230,240,249));
        
        _JHome = jh;
        
        client = new Connect4Client(this);
        
        initChat();
        
        gridPlayerLocation();
        
        loadBoardImage();
        
        
        try {
            UserNameLabel.setText(_JHome.logedInUser.username);
            UserAvatarIcon.setIcon(new ImageIcon(_JHome.userIcon));
            Score.setText(""+_JHome.logedInUser.global_score);
        }catch(Exception e) {
            
        }
    }

    private void initChat() {
        _jChat = new jChat(_JHome.logedInUser.username);
        chatPanel.add(_jChat);
        chatPanel.repaint();
        chatPanel.revalidate();
    }
    
    private  void  loadBoardImage() {
        
        
        JPanel glass = new JPanel(new BorderLayout());
        glass.setSize(588, 569);

        BufferedImage img;
        try {
            p1Icon = ImageIO.read(new File(CURRENT_PATH + "\\src\\Icons\\redC4.png"));
            p2Icon = ImageIO.read(new File(CURRENT_PATH + "\\src\\Icons\\yellowC4.png"));
            
            img = ImageIO.read(new File(CURRENT_PATH + "\\src\\Icons\\Connect4.png"));
            JLabel imgg = new JLabel();
            imgg.setIcon(new ImageIcon(img));
            imgg.setOpaque(false);
            glass.add(imgg, BorderLayout.CENTER);
        } catch (IOException ex) {
            Logger.getLogger(jSnakeLadder.class.getName()).log(Level.SEVERE, null, ex);
        }
        LayeredBoard.add(glass, 1);
    }
    
    private void gridPlayerLocation() {
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(new GridLayout(6, 7, 2, 2));
        playerPosition = new JPanel[42];
        for (int i = 0; i < 42; i++) {
            
            JPanel s = new JPanel();
            s.setOpaque(false);
            playerPosition[i] = s;
            panel.add(s);
        }
        panel.setSize(588, 575);

        LayeredBoard.add(panel,2);
    }
    
    public void quitGame() {
        _JHome.home();
        client.QUIT();
        _jChat._ChatClient.QUIT();
    }
    
    public void movePlayer(int r,  int c) {
        playerPosition[r + (7 * (c-1))].add(new JLabel( new ImageIcon(p1Icon)), BorderLayout.CENTER);
    }
    
    public void moveOponenet(int r,  int c) {
        playerPosition[r + (7 * (c-1))].add(new JLabel( new ImageIcon(p2Icon)),BorderLayout.CENTER);
    }
    
     public void showDialog(String message) {
        JOptionPane.showMessageDialog(_JHome, message);
    }

    public void setTextMessage(String message) {
        //Set the Text Message
        jMessage.setText(message);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bBack = new javax.swing.JButton();
        UserPanel = new javax.swing.JPanel();
        UserAvatarIcon = new javax.swing.JLabel();
        labbel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Score = new javax.swing.JLabel();
        UserNameLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jMessage = new javax.swing.JLabel();
        LayeredBoard = new javax.swing.JLayeredPane();
        jPanel3 = new javax.swing.JPanel();
        b2 = new javax.swing.JButton();
        b1 = new javax.swing.JButton();
        b3 = new javax.swing.JButton();
        b4 = new javax.swing.JButton();
        b5 = new javax.swing.JButton();
        b6 = new javax.swing.JButton();
        b7 = new javax.swing.JButton();
        chatPanel = new javax.swing.JPanel();

        bBack.setText("Quit");
        bBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bBackMouseClicked(evt);
            }
        });

        UserPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        UserAvatarIcon.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        UserAvatarIcon.setText("          Icon");

        labbel.setText("Username :");

        jLabel1.setText("Level :");

        Score.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Score.setForeground(new java.awt.Color(0, 51, 255));
        Score.setText("1");

        UserNameLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        UserNameLabel.setForeground(new java.awt.Color(0, 51, 255));
        UserNameLabel.setText("1");

        javax.swing.GroupLayout UserPanelLayout = new javax.swing.GroupLayout(UserPanel);
        UserPanel.setLayout(UserPanelLayout);
        UserPanelLayout.setHorizontalGroup(
            UserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UserPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(UserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(labbel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(UserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Score)
                    .addComponent(UserNameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(UserAvatarIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        UserPanelLayout.setVerticalGroup(
            UserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UserPanelLayout.createSequentialGroup()
                .addGroup(UserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(UserPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(UserAvatarIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(UserPanelLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(UserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labbel)
                            .addComponent(UserNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(UserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(Score, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jMessage.setBackground(new java.awt.Color(204, 204, 204));
        jMessage.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMessage.setText("message");
        jMessage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        LayeredBoard.setPreferredSize(new java.awt.Dimension(588, 569));

        javax.swing.GroupLayout LayeredBoardLayout = new javax.swing.GroupLayout(LayeredBoard);
        LayeredBoard.setLayout(LayeredBoardLayout);
        LayeredBoardLayout.setHorizontalGroup(
            LayeredBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        LayeredBoardLayout.setVerticalGroup(
            LayeredBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 569, Short.MAX_VALUE)
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        b2.setText("2");
        b2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b2MouseClicked(evt);
            }
        });

        b1.setText("1");
        b1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b1MouseClicked(evt);
            }
        });

        b3.setText("3");
        b3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b3MouseClicked(evt);
            }
        });

        b4.setText("4");
        b4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b4MouseClicked(evt);
            }
        });

        b5.setText("5");
        b5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b5MouseClicked(evt);
            }
        });

        b6.setText("6");
        b6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b6MouseClicked(evt);
            }
        });

        b7.setText("7");
        b7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b7MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(b1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(b2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(b3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(b4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(b5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(b6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(b7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b2)
                    .addComponent(b1)
                    .addComponent(b3)
                    .addComponent(b4)
                    .addComponent(b5)
                    .addComponent(b6)
                    .addComponent(b7))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LayeredBoard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 6, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LayeredBoard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        chatPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        chatPanel.setPreferredSize(new java.awt.Dimension(256, 219));
        chatPanel.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bBack)
                    .addComponent(UserPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chatPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UserPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(chatPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBackMouseClicked
        int result = JOptionPane.showConfirmDialog(_JHome, "Sure? you want ot Quit?",
                "Game Station",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if (result == JOptionPane.YES_OPTION)
            quitGame();
    }//GEN-LAST:event_bBackMouseClicked

    private void b1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b1MouseClicked
        client.MOVE(0);
    }//GEN-LAST:event_b1MouseClicked

    private void b2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b2MouseClicked
        // TODO add your handling code here:
        client.MOVE(1);
    }//GEN-LAST:event_b2MouseClicked

    private void b3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b3MouseClicked
        // TODO add your handling code here:
        client.MOVE(2);
    }//GEN-LAST:event_b3MouseClicked

    private void b4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b4MouseClicked
        // TODO add your handling code here:
        client.MOVE(3);
    }//GEN-LAST:event_b4MouseClicked

    private void b5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b5MouseClicked
        // TODO add your handling code here:
        client.MOVE(4);
    }//GEN-LAST:event_b5MouseClicked

    private void b6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b6MouseClicked
        // TODO add your handling code here:
        client.MOVE(5);
    }//GEN-LAST:event_b6MouseClicked

    private void b7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b7MouseClicked
        // TODO add your handling code here:
        client.MOVE(6);
    }//GEN-LAST:event_b7MouseClicked


    private JHome _JHome;
    private jChat _jChat;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane LayeredBoard;
    private javax.swing.JLabel Score;
    private javax.swing.JLabel UserAvatarIcon;
    private javax.swing.JLabel UserNameLabel;
    private javax.swing.JPanel UserPanel;
    private javax.swing.JButton b1;
    private javax.swing.JButton b2;
    private javax.swing.JButton b3;
    private javax.swing.JButton b4;
    private javax.swing.JButton b5;
    private javax.swing.JButton b6;
    private javax.swing.JButton b7;
    private javax.swing.JButton bBack;
    private javax.swing.JPanel chatPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jMessage;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel labbel;
    // End of variables declaration//GEN-END:variables
}
