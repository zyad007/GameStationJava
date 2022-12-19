package GUI.Games;

import Clients.SnakeLadderClient;
import GUI.JHome;
import javax.swing.JOptionPane;


public class jSnakeLadder extends javax.swing.JPanel {
    
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
        jMessage = new javax.swing.JLabel();
        UserPanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        bBack.setText("Quit");
        bBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bBackMouseClicked(evt);
            }
        });

        UserPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jButton1.setText("Roll Dice");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout UserPanelLayout = new javax.swing.GroupLayout(UserPanel);
        UserPanel.setLayout(UserPanelLayout);
        UserPanelLayout.setHorizontalGroup(
            UserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UserPanelLayout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(36, 36, 36))
        );
        UserPanelLayout.setVerticalGroup(
            UserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UserPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addContainerGap(73, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(bBack))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(UserPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(339, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bBack)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(UserPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(222, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBackMouseClicked
        int result = JOptionPane.showConfirmDialog(_JHome, "Sure? you want ot Quit?",
                "Game Station",
                JOptionPane.YES_NO_OPTION,
               JOptionPane.QUESTION_MESSAGE);
        if(result == JOptionPane.YES_OPTION) quitGame();
    }//GEN-LAST:event_bBackMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        //TODO add random dice number 1 - 6 in the MOVE();
        
        client.MOVE(2);
    }//GEN-LAST:event_jButton1MouseClicked


    //Parent
    private JHome _JHome;
    private SnakeLadderClient client;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel UserPanel;
    private javax.swing.JButton bBack;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jMessage;
    // End of variables declaration//GEN-END:variables
}
