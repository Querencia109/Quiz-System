/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizsystem;

import java.sql.*;
import javax.swing.JOptionPane;

public class UserRegistration extends javax.swing.JFrame {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String CONN_STRING = "jdbc:mysql://localhost:3306/quiz_base";

    public UserRegistration() {
        initComponents();
    }

    public static boolean isStringOnlyAlphabet(String str) {
        return ((!str.equals("")) && (str != null) && (str.matches("^[a-zA-Z]*$")));
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        textArea1 = new java.awt.TextArea();
        panel1 = new java.awt.Panel();
        jPanel1 = new javax.swing.JPanel();
        userreg = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        register = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lname = new javax.swing.JTextField();
        passreg = new javax.swing.JPasswordField();
        confirmpass = new javax.swing.JPasswordField();
        clearreg = new javax.swing.JButton();
        fname = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        textArea2 = new java.awt.TextArea();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel1.setBackground(new java.awt.Color(51, 153, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        userreg.setBackground(new java.awt.Color(255, 255, 255));
        userreg.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        userreg.setForeground(new java.awt.Color(0, 0, 0));
        userreg.setName("reg_user"); // NOI18N
        userreg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userregMouseClicked(evt);
            }
        });
        userreg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userregActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("USERNAME ");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("PASSWORD");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 25)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 255));
        jLabel2.setText("WELCOME TO O-SHI KUIZU!!");

        jButton2.setBackground(new java.awt.Color(255, 204, 51));
        jButton2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Go back");
        jButton2.setName("log"); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        register.setBackground(new java.awt.Color(255, 204, 51));
        register.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        register.setForeground(new java.awt.Color(255, 255, 255));
        register.setText("REGISTER");
        register.setName("registerAcc"); // NOI18N
        register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("CONFIRM PASSWORD");
        jLabel5.setName("confirmpass"); // NOI18N

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizsystem/Picture1.png"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("FIRSTNAME");

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("LASTNAME");

        lname.setBackground(new java.awt.Color(255, 255, 255));
        lname.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lname.setForeground(new java.awt.Color(0, 0, 0));
        lname.setName("reg_user"); // NOI18N
        lname.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lnameMouseClicked(evt);
            }
        });
        lname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lnameActionPerformed(evt);
            }
        });

        passreg.setBackground(new java.awt.Color(255, 255, 255));
        passreg.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        passreg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passregActionPerformed(evt);
            }
        });

        confirmpass.setBackground(new java.awt.Color(255, 255, 255));
        confirmpass.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        clearreg.setBackground(new java.awt.Color(255, 204, 51));
        clearreg.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        clearreg.setForeground(new java.awt.Color(255, 255, 255));
        clearreg.setText("CLEAR");
        clearreg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearregActionPerformed(evt);
            }
        });

        fname.setBackground(new java.awt.Color(255, 255, 255));
        fname.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        fname.setForeground(new java.awt.Color(0, 0, 0));
        fname.setName("reg_user"); // NOI18N
        fname.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fnameMouseClicked(evt);
            }
        });
        fname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fnameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel2)
                                        .addGap(38, 38, 38))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(confirmpass, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(passreg, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel8)
                                                    .addComponent(fname, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lname, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel9)))
                                            .addComponent(userreg, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel3)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(clearreg, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(73, 73, 73)
                                                        .addComponent(register, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(0, 15, Short.MAX_VALUE)))
                                        .addGap(67, 67, 67)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(35, 35, 35))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton2)
                                        .addGap(57, 57, 57)))))
                        .addGap(31, 31, 31))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lname, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fname, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(userreg, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(passreg, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(confirmpass, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearreg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(register, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(23, 23, 23))
        );

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizsystem/a.png"))); // NOI18N

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel10)
                .addGap(44, 44, 44)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1097, 751));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void userregMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userregMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_userregMouseClicked

    private void userregActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userregActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_userregActionPerformed

    private void registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerActionPerformed
        String nameF = fname.getText();
        String nameF2 = nameF.toUpperCase();
        String nameL = lname.getText();
        String nameL2 = nameL.toUpperCase();
        String userInput = userreg.getText();
        String userInput2 = userInput.toUpperCase();
        String passInput = passreg.getText();
        String passInput2 = passInput.toUpperCase();
        int attempt1 = 0, attempt2 = 0, attempt3 = 0, attempts = 0, time1 = 0, time2 = 0, time3 = 0;
        Connection conn;

        try {
            conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            
            if (isStringOnlyAlphabet(nameF) && isStringOnlyAlphabet(nameL)) {
                if (passreg.getText().equals(confirmpass.getText())) {
                    int action = JOptionPane.showConfirmDialog(this, "Register Account?", "VERIFY", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);//show confirm dialog
                    if (action == JOptionPane.YES_OPTION) {
                        
                    String sqll = "SELECT * FROM tbl_users WHERE username = '"+userInput+"'";
                    PreparedStatement pstt = conn.prepareStatement(sqll);
                    ResultSet rss = pstt.executeQuery();
                    if (rss.next()) {
                        JOptionPane.showMessageDialog(this, "Account already registered");
                    }  
                    
                    else {
                    String sql = "INSERT INTO tbl_users VALUES ('" + nameF2 + "', '" + nameL2 + "', '" + userInput2 + "', '" + passInput2 + "', '" + attempt1 + "', '" + attempt2 + "', '" + attempt3 + "', '" + attempts + "', '" + time1 + "', '" + time2 + "', '" + time3 + "')";
                    PreparedStatement pst = conn.prepareStatement(sql);
                    pst.executeUpdate();

                    JOptionPane.showMessageDialog(this, "Registered");
                    
                    fname.setText("");
                    lname.setText("");
                    userreg.setText("");
                    passreg.setText("");
                    confirmpass.setText("");
                    }
                    }
                    if (action == JOptionPane.NO_OPTION) {
                        JOptionPane.showMessageDialog(this, "Edi don't");
                    }
                } 
                else {
                    fname.setText("");
                    lname.setText("");
                    userreg.setText("");
                    passreg.setText("");
                    confirmpass.setText("");
                    // Dialog Window
                    JOptionPane.showMessageDialog(this, "Password does not match");
                }
            }
            else {
                    fname.setText("");
                    lname.setText("");
                    userreg.setText("");
                    passreg.setText("");
                    confirmpass.setText("");
                    // Dialog Window
                    JOptionPane.showMessageDialog(this, "Wrong input");
                }
        } 
        catch (SQLException e) {
            System.out.println("Failed To Connect");
        }
    }//GEN-LAST:event_registerActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        UserLogIn login = new UserLogIn();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed
    
    private void lnameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lnameMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lnameMouseClicked

    private void lnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lnameActionPerformed

    private void clearregActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearregActionPerformed
        fname.setText("");
        lname.setText("");
        userreg.setText("");
        passreg.setText("");
        confirmpass.setText("");
    }//GEN-LAST:event_clearregActionPerformed

    private void passregActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passregActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passregActionPerformed

    private void fnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fnameActionPerformed

    private void fnameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fnameMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_fnameMouseClicked

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
            java.util.logging.Logger.getLogger(UserRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserRegistration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearreg;
    private javax.swing.JPasswordField confirmpass;
    private javax.swing.JTextField fname;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField lname;
    private java.awt.Panel panel1;
    private javax.swing.JPasswordField passreg;
    private javax.swing.JButton register;
    private java.awt.TextArea textArea1;
    private java.awt.TextArea textArea2;
    private javax.swing.JTextField userreg;
    // End of variables declaration//GEN-END:variables
}
