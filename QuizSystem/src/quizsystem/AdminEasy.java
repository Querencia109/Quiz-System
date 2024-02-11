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

public class AdminEasy extends javax.swing.JFrame {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String CONN_STRING = "jdbc:mysql://localhost:3306/quiz_base";
    DecimalFormat dFormat = new DecimalFormat("00");
    String selected, username, ddseconds, ddminutes, ddhours, date, time, action2;
    int day,month,year;
    int second, minute, hour;
    Connection conn;

    public AdminEasy() {
        initComponents();
        updateTable();
    }
    
    public AdminEasy(String username) {
        initComponents();
        updateTable();
        this.username = username;
        adminuser.setVisible(true);
        adminuser.setText(this.username);
    }
    
    public void updateTable() {
        try {
            conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            String sql = "SELECT * FROM tbl_easy ORDER BY questionnum ASC";
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
        action2 = "Removed Easy Question";
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

        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        aetable = new javax.swing.JTable();
        addquestion = new javax.swing.JButton();
        modifyquestion = new javax.swing.JButton();
        remove = new javax.swing.JButton();
        back = new javax.swing.JButton();
        admin = new javax.swing.JLabel();
        adminuser = new javax.swing.JTextField();

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(255, 255, 255));
        jTextField1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(51, 153, 255));
        jTextField1.setText("quizzer");
        jTextField1.setBorder(null);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(51, 153, 255));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("EASY");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel3)
                .addContainerGap(1003, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel3)
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
        if (aetable.getColumnModel().getColumnCount() > 0) {
            aetable.getColumnModel().getColumn(0).setPreferredWidth(15);
        }

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(admin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(adminuser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(addquestion, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(modifyquestion)
                        .addGap(18, 18, 18)
                        .addComponent(remove)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(admin)
                    .addComponent(adminuser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addquestion, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modifyquestion, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(remove, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1097, 781));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addquestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addquestionActionPerformed
        new AddQuestionsEasy(username).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_addquestionActionPerformed

    private void modifyquestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyquestionActionPerformed
        new ModifyQuestionsEasy(username).setVisible(true);
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
                String sql = "DELETE from tbl_easy WHERE questionnum ='" + selected + "'";
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
        updateTable();
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
            java.util.logging.Logger.getLogger(AdminEasy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminEasy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminEasy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminEasy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminEasy().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addquestion;
    private javax.swing.JLabel admin;
    private javax.swing.JTextField adminuser;
    private javax.swing.JTable aetable;
    private javax.swing.JButton back;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton modifyquestion;
    private javax.swing.JButton remove;
    // End of variables declaration//GEN-END:variables
}
