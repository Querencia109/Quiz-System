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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class AdminHard extends javax.swing.JFrame {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String CONN_STRING = "jdbc:mysql://localhost:3306/quiz_base";
    DecimalFormat dFormat = new DecimalFormat("00");
    String selected, username, ddseconds, ddminutes, ddhours, date, time, action2;
    int day,month,year;
    int second, minute, hour;
    Connection conn;

    public AdminHard() {
        initComponents();
        updateTable();
    }

    public AdminHard(String username) {
        initComponents();
        updateTable();
        this.username = username;
        adminuser1.setVisible(true);
        adminuser1.setText(this.username);
        System.out.println(this.username);
    }

    public void updateTable() {
        try {
            conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            String sql = "SELECT * FROM tbl_hard ORDER BY questionnum ASC";
            Statement s = conn.prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);
            
            aetable.setModel(DbUtils.resultSetToTableModel(rs));
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
        action2 = "Removed Hard Question";
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

        admin = new javax.swing.JLabel();
        adminuser = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        aetable = new javax.swing.JTable();
        addquestion = new javax.swing.JButton();
        modifyquestion = new javax.swing.JButton();
        remove = new javax.swing.JButton();
        back = new javax.swing.JButton();
        adminuser1 = new javax.swing.JTextField();
        admin1 = new javax.swing.JLabel();

        admin.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        admin.setForeground(new java.awt.Color(51, 51, 51));
        admin.setText("ADMIN:");

        adminuser.setEditable(false);
        adminuser.setBackground(new java.awt.Color(255, 255, 255));
        adminuser.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        adminuser.setForeground(new java.awt.Color(51, 51, 51));
        adminuser.setText("name");
        adminuser.setBorder(null);
        adminuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminuserActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jPanel6.setBackground(new java.awt.Color(51, 153, 255));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("HARD");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel5)
                .addContainerGap(1001, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel5)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        aetable.setBackground(new java.awt.Color(255, 255, 255));
        aetable.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        aetable.setForeground(new java.awt.Color(51, 51, 51));
        aetable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "num", "question", "choice1", "choice2", "choice3", "choice4", "answer", "points"
            }
        ));
        aetable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aetableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(aetable);

        addquestion.setBackground(new java.awt.Color(255, 204, 51));
        addquestion.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        addquestion.setForeground(new java.awt.Color(255, 255, 255));
        addquestion.setText("ADD QUESTIONS");
        addquestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addquestionActionPerformed(evt);
            }
        });

        modifyquestion.setBackground(new java.awt.Color(255, 204, 51));
        modifyquestion.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        modifyquestion.setForeground(new java.awt.Color(255, 255, 255));
        modifyquestion.setText("MODIFY QUESTIONS");
        modifyquestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyquestionActionPerformed(evt);
            }
        });

        remove.setBackground(new java.awt.Color(255, 102, 102));
        remove.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        remove.setForeground(new java.awt.Color(255, 255, 255));
        remove.setText("REMOVE QUESTIONS");
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
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

        adminuser1.setEditable(false);
        adminuser1.setBackground(new java.awt.Color(255, 255, 255));
        adminuser1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        adminuser1.setForeground(new java.awt.Color(51, 51, 51));
        adminuser1.setText("name");
        adminuser1.setBorder(null);

        admin1.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        admin1.setForeground(new java.awt.Color(51, 51, 51));
        admin1.setText("ADMIN:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)))
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(addquestion, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(modifyquestion)
                        .addGap(18, 18, 18)
                        .addComponent(remove))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(admin1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(adminuser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(admin1)
                    .addComponent(adminuser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addquestion, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modifyquestion, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(remove, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1097, 782));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addquestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addquestionActionPerformed
        new AddQuestionsHard(username).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_addquestionActionPerformed

    private void modifyquestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyquestionActionPerformed
        new ModifyQuestionsHard(username).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_modifyquestionActionPerformed

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
        DefaultTableModel tbl = (DefaultTableModel)aetable.getModel();

        if(aetable.getSelectedRowCount()==1) {
            Connection conn;
            int action = JOptionPane.showConfirmDialog(this, "Remove Item?", "WARNING", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);//show confirm dialog
            if(action == JOptionPane.YES_OPTION){//if the admin really wants to remove an item
            try {
                conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
                String sql = "DELETE from tbl_hard WHERE questionnum ='" + selected + "'";
                Statement state = conn.createStatement();
                state.execute(sql);
                
                getDateAndTime();
                setUpdate();
                updateTable();
                JOptionPane.showMessageDialog(this, "Removed Successfully");
            } 
            catch (SQLException e) {
                System.out.println("Failed To Connect");
            } 
        }
        }
        else {
            if(aetable.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Table is empty.");
            }
            else {
                JOptionPane.showMessageDialog(this, "Please select a row to remove!");
            }
        }
    }//GEN-LAST:event_removeActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        new Difficulty(username).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backActionPerformed

    private void aetableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aetableMouseClicked
        DefaultTableModel tbl = (DefaultTableModel) aetable.getModel();
        selected = tbl.getValueAt(aetable.getSelectedRow(), 0).toString();
    }//GEN-LAST:event_aetableMouseClicked

    private void adminuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminuserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_adminuserActionPerformed

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
            java.util.logging.Logger.getLogger(AdminHard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminHard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminHard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminHard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminHard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addquestion;
    private javax.swing.JLabel admin;
    private javax.swing.JLabel admin1;
    private javax.swing.JTextField adminuser;
    private javax.swing.JTextField adminuser1;
    private javax.swing.JTable aetable;
    private javax.swing.JButton back;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modifyquestion;
    private javax.swing.JButton remove;
    // End of variables declaration//GEN-END:variables
}
