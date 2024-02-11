/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizsystem;

import java.sql.*;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class ModifyQuestionsIntermediate extends javax.swing.JFrame {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String CONN_STRING = "jdbc:mysql://localhost:3306/quiz_base";
    DecimalFormat dFormat = new DecimalFormat("00");
    String selected, username, ddseconds, ddminutes, ddhours, date, time, action2;
    int day,month,year;
    int second, minute, hour;
    Connection conn;

    public ModifyQuestionsIntermediate() {
        initComponents();
        updateTable();
    }
    
    public ModifyQuestionsIntermediate(String username) {
        initComponents();
        updateTable();
        this.username = username;
        adminuser.setVisible(true);
        adminuser.setText(this.username);
    }

    public void updateTable() {
        Connection conn;
        
        try {
            conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            String sql = "SELECT * FROM tbl_intermediate ORDER BY questionnum ASC";
            Statement s = conn.prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);
            
            modtable.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public void getDateAndTime(){
        GregorianCalendar gc = new GregorianCalendar();
        day = gc.get(Calendar.DAY_OF_MONTH);
        month = gc.get(Calendar.MONTH);
        year = gc.get(Calendar.YEAR);
        second = gc.get(Calendar.SECOND);
        minute = gc.get(Calendar.MINUTE);
        hour = gc.get(Calendar.HOUR);
 
        ddseconds = dFormat.format(second);
        ddminutes = dFormat.format(minute);
        ddhours = dFormat.format(hour);
        
        time = hour+":"+ddminutes+":"+ddseconds;
        date = day+"/"+month+"/"+year;
    }
    
    public void setUpdate() {
        action2 = "Modified Intermediate Question";
        System.out.println(username+" "+action2+" "+date+" "+time);
        try {
            conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            String sql = "INSERT INTO tbl_history VALUES ('"+username+"', '"+action2+"', '"+date+"', '"+time+"')";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.executeUpdate();
        } 
        catch (SQLException e) {
            System.out.println("Failed To Connect");
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        admin = new javax.swing.JLabel();
        adminuser = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        modtable = new javax.swing.JTable();
        modify = new javax.swing.JButton();
        back = new javax.swing.JButton();
        modnumber = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        modquestion = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        modchoice1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        modchoice2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        modchoice3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        modchoice4 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        answer5 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jPanel8.setBackground(new java.awt.Color(51, 153, 255));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("INTERMEDIATE");

        admin.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        admin.setForeground(new java.awt.Color(255, 255, 255));
        admin.setText("ADMIN:");

        adminuser.setEditable(false);
        adminuser.setBackground(new java.awt.Color(51, 153, 255));
        adminuser.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        adminuser.setForeground(new java.awt.Color(255, 255, 255));
        adminuser.setText("name");
        adminuser.setBorder(null);
        adminuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminuserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(admin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(adminuser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(20, 20, 20))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(admin)
                        .addComponent(adminuser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        modtable.setBackground(new java.awt.Color(255, 255, 255));
        modtable.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        modtable.setForeground(new java.awt.Color(0, 0, 0));
        modtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "num", "question", "choice1", "choice2", "choice3", "choice4", "answer", "points"
            }
        ));
        modtable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modtableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(modtable);
        if (modtable.getColumnModel().getColumnCount() > 0) {
            modtable.getColumnModel().getColumn(7).setResizable(false);
        }

        modify.setBackground(new java.awt.Color(255, 204, 51));
        modify.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        modify.setForeground(new java.awt.Color(255, 255, 255));
        modify.setText("MODIFY QUESTIONS");
        modify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyActionPerformed(evt);
            }
        });

        back.setBackground(new java.awt.Color(255, 204, 51));
        back.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        back.setForeground(new java.awt.Color(255, 255, 255));
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        modnumber.setEditable(false);
        modnumber.setBackground(new java.awt.Color(255, 255, 255));
        modnumber.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        modnumber.setForeground(new java.awt.Color(51, 51, 51));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Number: ");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Question: ");

        modquestion.setBackground(new java.awt.Color(255, 255, 255));
        modquestion.setColumns(20);
        modquestion.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        modquestion.setForeground(new java.awt.Color(51, 51, 51));
        modquestion.setRows(5);
        jScrollPane2.setViewportView(modquestion);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Choice 1");

        modchoice1.setBackground(new java.awt.Color(255, 255, 255));
        modchoice1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        modchoice1.setForeground(new java.awt.Color(51, 51, 51));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Choice 2");

        modchoice2.setBackground(new java.awt.Color(255, 255, 255));
        modchoice2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        modchoice2.setForeground(new java.awt.Color(51, 51, 51));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Choice 3");

        modchoice3.setBackground(new java.awt.Color(255, 255, 255));
        modchoice3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        modchoice3.setForeground(new java.awt.Color(51, 51, 51));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Choice 4");

        modchoice4.setBackground(new java.awt.Color(255, 255, 255));
        modchoice4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        modchoice4.setForeground(new java.awt.Color(51, 51, 51));
        modchoice4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modchoice4ActionPerformed(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Answer");

        answer5.setBackground(new java.awt.Color(255, 255, 255));
        answer5.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        answer5.setForeground(new java.awt.Color(51, 51, 51));
        answer5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                answer5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(modchoice1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(modchoice2, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(modchoice3, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(answer5, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(modchoice4, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(modnumber, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 632, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(modify)
                .addGap(18, 18, 18)
                .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(modify, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(modnumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(modchoice1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(modchoice2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(modchoice3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(modchoice4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(answer5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(16, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1097, 878));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void modtableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modtableMouseClicked
        DefaultTableModel tbl = (DefaultTableModel)modtable.getModel();

        String tblnum = tbl.getValueAt(modtable.getSelectedRow(), 0).toString();
        String tblQuestions = tbl.getValueAt(modtable.getSelectedRow(), 1).toString();
        String tblchoice1 = tbl.getValueAt(modtable.getSelectedRow(), 2).toString();
        String tblchoice2 = tbl.getValueAt(modtable.getSelectedRow(), 3).toString();
        String tblchoice3 = tbl.getValueAt(modtable.getSelectedRow(), 4).toString();
        String tblchoice4 = tbl.getValueAt(modtable.getSelectedRow(), 5).toString();
        String tblanswer = tbl.getValueAt(modtable.getSelectedRow(), 6).toString();

        //set to textfield to modify
        modnumber.setText(tblnum);
        modquestion.setText(tblQuestions);
        modchoice1.setText(tblchoice1);
        modchoice2.setText(tblchoice2);
        modchoice3.setText(tblchoice3);
        modchoice4.setText(tblchoice4);
        answer5.setText(tblanswer);
    }//GEN-LAST:event_modtableMouseClicked

    private void modifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyActionPerformed
        DefaultTableModel tbl = (DefaultTableModel)modtable.getModel();
        
        if (modtable.getSelectedRowCount() == 1) {
            int action = JOptionPane.showConfirmDialog(this, "Update Item?", "WARNING", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);//show confirm dialog
            if(action == JOptionPane.YES_OPTION){//if the admin really wants to update an item
            String adn = modnumber.getText();
            String quest = modquestion.getText();
            String quest2 = quest.toUpperCase();
            String c1 = modchoice1.getText();
            String c12 = c1.toUpperCase();
            String c2 = modchoice2.getText();
            String c22 = c2.toUpperCase();
            String c3 = modchoice3.getText();
            String c32 = c3.toUpperCase();
            String c4 = modchoice4.getText();
            String c42 = c4.toUpperCase();
            String answer = answer5.getText();
            String answer2 = answer.toUpperCase();
            String points = "3";
            Connection conn = null;
            
            try {
                conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
                String sql = "UPDATE tbl_intermediate SET question = '"+quest2+"', choice1 = '"+c12+"', choice2 = '"+c22+"', choice3 = '"+c32+"', choice4 = '"+c42+"', answer = '"+answer2+"', points = '"+points+"' WHERE questionnum = '"+adn+"'";
                Statement state = conn.createStatement();
                state.executeUpdate(sql);
                
                getDateAndTime();
                setUpdate();
                JOptionPane.showMessageDialog(this, "Question Updated");
            } 
            catch (SQLException e) {
                System.out.println("Failed To Connect");
            }
        } 
        }
        else {
            if (modtable.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "table is empty");
            } 
            else {
                JOptionPane.showMessageDialog(this, "Please choose an item from the table to modify");
            }
        }
        updateTable();
    }//GEN-LAST:event_modifyActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        new AdminIntermediate(username).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backActionPerformed

    private void adminuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminuserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_adminuserActionPerformed

    private void modchoice4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modchoice4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_modchoice4ActionPerformed

    private void answer5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_answer5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_answer5ActionPerformed

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
            java.util.logging.Logger.getLogger(ModifyQuestionsIntermediate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModifyQuestionsIntermediate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModifyQuestionsIntermediate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModifyQuestionsIntermediate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModifyQuestionsIntermediate().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel admin;
    private javax.swing.JTextField adminuser;
    private javax.swing.JTextField answer5;
    private javax.swing.JButton back;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField modchoice1;
    private javax.swing.JTextField modchoice2;
    private javax.swing.JTextField modchoice3;
    private javax.swing.JTextField modchoice4;
    private javax.swing.JButton modify;
    private javax.swing.JTextField modnumber;
    private javax.swing.JTextArea modquestion;
    private javax.swing.JTable modtable;
    // End of variables declaration//GEN-END:variables
}
