/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI.StartUp;

import Entities.User;
import GUI.JHome;
import IServices.IUserServices;
import Services.UserServices;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Zyad
 */
public class JStartUp extends javax.swing.JFrame {
    
    
    public JStartUp() {
        initComponents();
        _jSignUp = new jSignUp(this);
        _UserServices = new UserServices();
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
        jLabel2 = new javax.swing.JLabel();
        tUsername = new javax.swing.JTextField();
        tPassword = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login to GameStack");

        jDefault.setLayout(new java.awt.CardLayout());

        jLogin.setBackground(new java.awt.Color(51, 51, 51));

        bLogin.setBackground(new java.awt.Color(255, 0, 0));
        bLogin.setForeground(new java.awt.Color(255, 255, 255));
        bLogin.setText("Login");
        bLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bLoginMouseClicked(evt);
            }
        });
        bLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLoginActionPerformed(evt);
            }
        });

        bSignUp.setBackground(new java.awt.Color(255, 0, 0));
        bSignUp.setForeground(new java.awt.Color(255, 255, 255));
        bSignUp.setText("Sign Up");
        bSignUp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bSignUpMouseClicked(evt);
            }
        });
        bSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSignUpActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("USERNAME");

        jLabel2.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("PASSWORD");

        jLabel3.setFont(new java.awt.Font("Rockwell Condensed", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Log In");

        javax.swing.GroupLayout jLoginLayout = new javax.swing.GroupLayout(jLogin);
        jLogin.setLayout(jLoginLayout);
        jLoginLayout.setHorizontalGroup(
            jLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLoginLayout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addGroup(jLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLoginLayout.createSequentialGroup()
                        .addComponent(bSignUp)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLoginLayout.createSequentialGroup()
                        .addGroup(jLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                            .addComponent(tUsername))
                        .addGap(66, 66, 66))))
            .addGroup(jLoginLayout.createSequentialGroup()
                .addGroup(jLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLoginLayout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(jLabel3))
                    .addGroup(jLoginLayout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(bLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jLoginLayout.setVerticalGroup(
            jLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLoginLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(jLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tUsername))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(bLogin)
                .addGap(26, 26, 26)
                .addComponent(bSignUp)
                .addContainerGap())
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

        
        String name= tUsername.getText().toString();
        String pass= tPassword.getText().toString();
        
       
        
        if(name.equals("")){
            JOptionPane.showMessageDialog(null, "PLS ENTER USERNAME");
        }
        else if(pass.equals("")){
            JOptionPane.showMessageDialog(null, "PLS ENTER PASSWORD");
        }
        if(!name.equals("")&&!pass.equals(""))
        {
            
        User user = _UserServices.signIn(name, pass); //Todo Sign IN
        
        if(user != null) {
            this.dispose();
             JHome _JHome=new JHome();
            _JHome.setLogedInUser(user);
            _JHome.setLocationRelativeTo(null);
            _JHome.setResizable(false);
            _JHome.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "Wrong Username or Password");
        }
                
        }
    }//GEN-LAST:event_bLoginMouseClicked

    // -> Sign Up
    private void bSignUpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bSignUpMouseClicked
        
        switchPanels(_jSignUp);
    }//GEN-LAST:event_bSignUpMouseClicked

    private void bLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bLoginActionPerformed

    private void bSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSignUpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bSignUpActionPerformed
    
    
    
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
                
               JStartUp _StartUp =  new JStartUp();
               _StartUp.setLocationRelativeTo(null);
               _StartUp.setResizable(false);
               _StartUp.setVisible(true);
              
            }
        });
    }

    //JPanel
    private jSignUp _jSignUp;
    private IUserServices _UserServices;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bLogin;
    private javax.swing.JButton bSignUp;
    private javax.swing.JPanel jDefault;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jLogin;
    private javax.swing.JPasswordField tPassword;
    private javax.swing.JTextField tUsername;
    // End of variables declaration//GEN-END:variables
}
