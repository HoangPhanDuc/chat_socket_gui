package GUI;

import chat.Client;
import chat.Message;
import chat.Server;
import java.awt.Color;
import javax.swing.BoxLayout;

public class ChatView extends javax.swing.JFrame {

    private Client client;
    private Server server;
    private int mode;

    public ChatView() {
        initComponents();
        this.setTitle("Chat");
        messagePanel.setLayout(new BoxLayout(messagePanel, BoxLayout.Y_AXIS));
        mode = 0;
    }

    public void SetUsername(String username) {
        chatroomTitle.setText("Chatroom: " + username);
        this.repaint();
    }

    public void SetClient(Client cli) {
        mode = 1;
        client = cli;
    }
    /**
     * Set server class
     */
    public void SetServer(Server srv) {
        mode = 2;
        server = srv;
    }

    public void AddClientMessage(String msg) {
        if (mode == 1) {
            Message message = new Message(client.getUsername(), msg);
            String msgAdd = "[" + message.getTime() + " " + message.getUsername() + "]->\t" + message.getText();
            messagePanel.append(msgAdd + "\n");
        } else {
            Message message = new Message(server.getUsername(), msg);
            String msgAdd = "[" + message.getTime() + " " + message.getUsername() + "]->\t" + message.getText();
            messagePanel.append(msgAdd + "\n");
        }
    }

    public void AddRemoteMessage(String msg) {
        if (mode == 1) {
            Message message = new Message("Partner", msg);
            String msgAdd = "[" + message.getTime() + " " + message.getUsername() + "]->\t" + message.getText();
            messagePanel.append(msgAdd + "\n");
        } else {
            Message message = new Message("Partner", msg);
            String msgAdd = "[" + message.getTime() + " " + message.getUsername() + "]->\t" + message.getText();
            messagePanel.append(msgAdd + "\n");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        messageField = new javax.swing.JTextField();
        sendButton = new javax.swing.JButton();
        chatroomTitle = new javax.swing.JLabel();
        logoutButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        messagePanel = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        messageField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                messageFieldActionPerformed(evt);
            }
        });

        sendButton.setText("Send");
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });

        chatroomTitle.setFont(new java.awt.Font("Noto Sans", 0, 36)); // NOI18N
        chatroomTitle.setForeground(new java.awt.Color(120, 120, 120));
        chatroomTitle.setText("Chatroom: David");

        logoutButton.setText("Logout");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        messagePanel.setEditable(false);
        messagePanel.setColumns(20);
        messagePanel.setLineWrap(true);
        messagePanel.setRows(5);
        messagePanel.setWrapStyleWord(true);
        jScrollPane1.setViewportView(messagePanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(messageField)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sendButton, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(chatroomTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 206, Short.MAX_VALUE)
                        .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(chatroomTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logoutButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(messageField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sendButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        if(mode == 1) {
            client.CloseConnection();
        } else {
            server.CloseConnection();
        }
        this.dispose();
        System.exit(0);
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void messageFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_messageFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_messageFieldActionPerformed

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
        String msg = messageField.getText();
        if (mode == 1) client.SendMessage(msg);
        else server.SendMessage(msg);
        AddClientMessage(msg);
        messageField.setText("");
    }//GEN-LAST:event_sendButtonActionPerformed

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
            java.util.logging.Logger.getLogger(ChatView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChatView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChatView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChatView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChatView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel chatroomTitle;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logoutButton;
    private javax.swing.JTextField messageField;
    private javax.swing.JTextArea messagePanel;
    private javax.swing.JButton sendButton;
    // End of variables declaration//GEN-END:variables
}
