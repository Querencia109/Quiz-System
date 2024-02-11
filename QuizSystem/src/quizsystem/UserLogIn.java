
package quizsystem;

import java.sql.*;
import javax.swing.*;

public class UserLogIn extends javax.swing.JFrame {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String CONN_STRING = "jdbc:mysql://localhost:3306/quiz_base";
    public String userInput, passInput;
    public int attempts;
    AdminValidation al = new AdminValidation();
    QuizInterface qi = new QuizInterface();

    public UserLogIn() {
        initComponents();
    }
    
    public void getAttempts() {
        try {
            Connection conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            String sql = "SELECT * FROM tbl_users WHERE username = '"+userInput+"'";
            Statement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery(sql);
            
            if (rs.next()) {
                attempts = rs.getInt(8);
                System.out.println(attempts);
            }
        }
        catch (SQLException e) {
            System.out.println("Failed");
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        panel1 = new java.awt.Panel();
        jPanel11 = new javax.swing.JPanel();
        userlog = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        passlog = new javax.swing.JPasswordField();
        seepass = new javax.swing.JCheckBox();
        login = new javax.swing.JButton();
        adminlogin = new javax.swing.JButton();
        registerform = new javax.swing.JButton();
        jLabel56 = new javax.swing.JLabel();
        clearlog = new javax.swing.JButton();
        jLabel57 = new javax.swing.JLabel();
        forgotpass = new javax.swing.JButton();
        jLabel55 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLayeredPane2.setBackground(new java.awt.Color(0, 204, 255));

        jButton1.setText("jButton1");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("WELCOME to QUIZ");

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addGap(182, 182, 182)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(182, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(146, 146, 146))
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane2Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 336, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(193, 193, 193))
        );
        jLayeredPane2.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel1.setBackground(new java.awt.Color(51, 153, 255));
        panel1.setPreferredSize(new java.awt.Dimension(1081, 712));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        userlog.setBackground(new java.awt.Color(255, 255, 255));
        userlog.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        userlog.setForeground(new java.awt.Color(0, 0, 0));
        userlog.setName("user"); // NOI18N
        userlog.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userMouseClicked(evt);
            }
        });
        userlog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userActionPerformed(evt);
            }
        });

        jLabel53.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(51, 51, 51));
        jLabel53.setText("USERNAME ");

        jLabel54.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(51, 51, 51));
        jLabel54.setText("PASSWORD");

        passlog.setBackground(new java.awt.Color(255, 255, 255));
        passlog.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        passlog.setForeground(new java.awt.Color(0, 0, 0));
        passlog.setName(""); // NOI18N
        passlog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passActionPerformed(evt);
            }
        });

        seepass.setBackground(new java.awt.Color(255, 255, 255));
        seepass.setLabel("Show password");
        seepass.setName("cbox"); // NOI18N
        seepass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showpassActionPerformed(evt);
            }
        });

        login.setBackground(new java.awt.Color(255, 204, 51));
        login.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        login.setForeground(new java.awt.Color(255, 255, 255));
        login.setText("LOG IN");
        login.setName("log"); // NOI18N
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });

        adminlogin.setBackground(new java.awt.Color(255, 204, 51));
        adminlogin.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        adminlogin.setForeground(new java.awt.Color(255, 255, 255));
        adminlogin.setText("Log in as Admin");
        adminlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminloginActionPerformed(evt);
            }
        });

        registerform.setBackground(new java.awt.Color(255, 204, 51));
        registerform.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        registerform.setForeground(new java.awt.Color(255, 255, 255));
        registerform.setText("REGISTER");
        registerform.setName("reg"); // NOI18N
        registerform.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel56.setForeground(new java.awt.Color(255, 51, 51));
        jLabel56.setText("Don't have an account? Register now!");

        clearlog.setBackground(new java.awt.Color(255, 204, 51));
        clearlog.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        clearlog.setForeground(new java.awt.Color(255, 255, 255));
        clearlog.setText("CLEAR ALL");
        clearlog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearregActionPerformed(evt);
            }
        });

        jLabel57.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizsystem/Picture1.png"))); // NOI18N

        forgotpass.setBackground(new java.awt.Color(255, 255, 255));
        forgotpass.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        forgotpass.setForeground(new java.awt.Color(102, 204, 255));
        forgotpass.setText("Forgot Password?");
        forgotpass.setBorder(null);
        forgotpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forgotpassActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addComponent(adminlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(registerform, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel56)))
                .addContainerGap())
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGap(91, 91, 91)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel54)
                                    .addComponent(jLabel53)))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGap(138, 138, 138)
                                .addComponent(userlog, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(seepass)
                            .addComponent(passlog, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(forgotpass, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(clearlog))))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(243, 243, 243)
                        .addComponent(jLabel57)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel53)
                .addGap(18, 18, 18)
                .addComponent(userlog, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel54)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passlog, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(seepass)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clearlog, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(login, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(forgotpass, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jLabel56)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registerform, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(adminlogin))
                .addContainerGap())
        );

        passlog.getAccessibleContext().setAccessibleName("");

        jLabel55.setFont(new java.awt.Font("Dialog", 1, 25)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setText("WELCOME TO O-SHI KUIZU!!");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizsystem/a.png"))); // NOI18N

        jLabel58.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(255, 255, 255));

        jLabel59.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(255, 255, 255));
        jLabel59.setText("Confident with your general knowledge?");

        jLabel60.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(255, 255, 255));
        jLabel60.setText("O-shi kuizu will test how knowledgable");

        jLabel61.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(255, 255, 255));
        jLabel61.setText("you are about the world");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel55)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(399, 399, 399)
                                .addComponent(jLabel58))
                            .addComponent(jLabel59)
                            .addComponent(jLabel60)
                            .addComponent(jLabel61)))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(jLabel58)
                .addGap(12, 12, 12)
                .addComponent(jLabel59)
                .addGap(42, 42, 42)
                .addComponent(jLabel60)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel61)
                .addGap(110, 110, 110)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1099, 759));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void clearregActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearregActionPerformed
        userlog.setText("");
        passlog.setText("");
    }//GEN-LAST:event_clearregActionPerformed

    private void passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passActionPerformed

    private void showpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showpassActionPerformed
        if(seepass.isSelected()){
            passlog.setEchoChar((char)0);
        }
        else{
            passlog.setEchoChar('*');
        }
    }//GEN-LAST:event_showpassActionPerformed

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        userInput = userlog.getText();
        passInput = passlog.getText();
        
        Connection conn;
        
        try {
            conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            String sql = "SELECT * FROM tbl_users WHERE username = ? AND password = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, userInput);
            pst.setString(2, passInput);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                if (userInput.equals(userInput) && passInput.equals(passInput)) {
                    getAttempts();
                    
                    if (attempts < 3) {
                        new Instructions(userInput).setVisible(true);
                        this.dispose();
                    }
                    else {
                        JOptionPane.showMessageDialog(this, "You've reached the maximum attempts.");
                        userlog.setText("");
                        passlog.setText("");
                    }
                }
            }
            else {
                JOptionPane.showMessageDialog(this, "Wrong username or password");
                userlog.setText("");
                passlog.setText("");
            }
            if (userInput.equals("") || passInput.equals("")) {
                JOptionPane.showMessageDialog(this, "Please fill out the form");
            }
        }   
        catch (SQLException e) {
            System.out.println("Failed To Connect");
        }
        
    }//GEN-LAST:event_loginActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        UserRegistration registerform = new UserRegistration();
        registerform.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userActionPerformed

    private void userMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_userMouseClicked

    private void adminloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminloginActionPerformed
        al.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_adminloginActionPerformed

    private void forgotpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forgotpassActionPerformed
        ForgotPass fp = new ForgotPass();
        fp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_forgotpassActionPerformed
    private int xMouse,yMouse;
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(UserLogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserLogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserLogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserLogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserLogIn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adminlogin;
    private javax.swing.JButton clearlog;
    private javax.swing.JButton forgotpass;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JButton login;
    private java.awt.Panel panel1;
    private javax.swing.JPasswordField passlog;
    private javax.swing.JButton registerform;
    private javax.swing.JCheckBox seepass;
    private javax.swing.JTextField userlog;
    // End of variables declaration//GEN-END:variables
}
