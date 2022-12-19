/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI.StartUp;

import GUI.JHome;
import IServices.IAccountServices;
import Services.AccountServices;
import javax.swing.JPanel;

/**
 *
 * @author Zyad
 */
public class JStartUp extends javax.swing.JFrame {
    
    
    public JStartUp() {
        initComponents();
        _jSignUp = new jSignUp(this);
        
        _AccountServices = new AccountServices();
    }
    
    private void switchPanels(JPanel panel) {
        jDefault.removeAll();
        jDefault.add(panel);
        jDefault.repaint();
        jDefault.revalidate();
    }
    
    public void home() {
        switchPanels(jLogin);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDefault = new javax.swing.JPanel();
        jLogin = new javax.swing.JPanel();
        bLogin = new javax.swing.JButton();
        bSignUp = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jDefault.setLayout(new java.awt.CardLayout());

        bLogin.setText("Login");
        bLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bLoginMouseClicked(evt);
            }
        });

        bSignUp.setText("SignUp");
        bSignUp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bSignUpMouseClicked(evt);
            }
        });

        jLabel1.setText("login");

        javax.swing.GroupLayout jLoginLayout = new javax.swing.GroupLayout(jLogin);
        jLogin.setLayout(jLoginLayout);
        jLoginLayout.setHorizontalGroup(
            jLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLoginLayout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addGroup(jLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(bSignUp)
                    .addComponent(bLogin))
                .addContainerGap(167, Short.MAX_VALUE))
        );
        jLoginLayout.setVerticalGroup(
            jLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLoginLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addComponent(bLogin)
                .addGap(37, 37, 37)
                .addComponent(bSignUp)
                .addGap(50, 50, 50))
        );

        jDefault.add(jLogin, "card2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDefault, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDefault, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Log In -> Home
    private void bLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bLoginMouseClicked
        boolean result = _AccountServices.login("", "");
        if(result) {
            this.dispose();
            new JHome().setVisible(true);
        }
    }//GEN-LAST:event_bLoginMouseClicked

    // -> Sign Up
    private void bSignUpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bSignUpMouseClicked
        switchPanels(_jSignUp);
    }//GEN-LAST:event_bSignUpMouseClicked
    
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JStartUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JStartUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JStartUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JStartUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JStartUp().setVisible(true);
            }
        });
    }

    //JPanel
    private jSignUp _jSignUp;
    
    private IAccountServices _AccountServices;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bLogin;
    private javax.swing.JButton bSignUp;
    private javax.swing.JPanel jDefault;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jLogin;
    // End of variables declaration//GEN-END:variables
}
