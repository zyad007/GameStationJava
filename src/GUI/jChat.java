/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import Clients.ChatClient;

/**
 *
 * @author Zyad
 */
public class jChat extends javax.swing.JPanel {

    /**
     * Creates new form jChat
     */
    public jChat(String username) {
        initComponents();
        _ChatClient = new ChatClient(this, username);
    }

    public void pushMessage(String message) {
        String txt = chatArea.getText();
        txt = txt.concat("\n"+message);
        chatArea.setText(txt);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        chatArea = new javax.swing.JTextArea();
        bSend = new javax.swing.JButton();
        enterMsg = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(226, 232));

        chatArea.setEditable(false);
        chatArea.setColumns(18);
        chatArea.setRows(5);
        chatArea.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        chatArea.setFocusable(false);
        jScrollPane1.setViewportView(chatArea);

        bSend.setText("Send");
        bSend.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bSendMouseClicked(evt);
            }
        });

        enterMsg.setText("Enter text here..");
        enterMsg.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(enterMsg)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bSend)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bSend)
                    .addComponent(enterMsg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bSendMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bSendMouseClicked
        _ChatClient.MESSAGE(enterMsg.getText());
    }//GEN-LAST:event_bSendMouseClicked

    public ChatClient _ChatClient;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bSend;
    private javax.swing.JTextArea chatArea;
    private javax.swing.JTextField enterMsg;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}