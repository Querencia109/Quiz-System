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

public class AddQuestionsIntermediate extends javax.swing.JFrame {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String CONN_STRING = "jdbc:mysql://localhost:3306/quiz_base";
    DecimalFormat dFormat = new DecimalFormat("00");
    String selected, username, ddseconds, ddminutes, ddhours, date, time, action2;
    int day,month,year;
    int second, minute, hour;
    int iSize;
    Connection conn;

    public AddQuestionsIntermediate() {
        initComponents();
        updateTable();
        setQuestionNumber();
    }
    
    public AddQuestionsIntermediate(String username) {
        initComponents();
        updateTable();
        setQuestionNumber();
        this.username = username;
        adminuser.setVisible(true);
        adminuser.setText(this.username);
    }
    
    public void updateTable() {
        try {
            conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            String sql = "SELECT * FROM tbl_intermediate ORDER BY questionnum ASC";
            Statement s = conn.prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);
            
            addtable.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public void setQuestionNumber() {
        try {
            conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            // Size of Easy Questions Table
            String sqes = "SELECT COUNT(*) FROM tbl_intermediate";
            Statement ses = conn.prepareStatement(sqes);
            ResultSet rses = ses.executeQuery(sqes);
            rses.next();
            iSize = 1 + rses.getInt(1);
        } 
        catch (SQLException e) {
            System.out.println("Failed To Connect");
        }
        adnum.setText(String.valueOf(iSize));
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
        action2 = "Added Intermediate Question";
        
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
    
    public void clear() {
        adnum.setText("");
        adquest.setText("");
        adc1.setText("");
        adc2.setText("");
        adc3.setText("");
        adc4.setText("");
        adc5.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        admin = new javax.swing.JLabel();
        adminuser = new javax.swing.JTextField();
        Add = new javax.swing.JButton();
        back = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        addtable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        adnum = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        adquest = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        adc1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        adc2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        adc3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        adc4 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        adc5 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jPanel8.setBackground(new java.awt.Color(51, 153, 255));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("INTERMIDIATE");

        admin.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        admin.setForeground(new java.awt.Color(255, 255, 255));
        admin.setText("ADMIN:");

        adminuser.setEditable(false);
        adminuser.setBackground(new java.awt.Color(51, 153, 255));
        adminuser.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        adminuser.setForeground(new java.awt.Color(255, 255, 255));
        adminuser.setText("name");
        adminuser.setBorder(null);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(admin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(adminuser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(18, 18, 18))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(admin)
                    .addComponent(adminuser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        Add.setBackground(new java.awt.Color(255, 204, 51));
        Add.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Add.setForeground(new java.awt.Color(255, 255, 255));
        Add.setText("ADD QUESTIONS");
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
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

        addtable.setBackground(new java.awt.Color(255, 255, 255));
        addtable.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        addtable.setForeground(new java.awt.Color(51, 51, 51));
        addtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "num", "question", "choice1", "choice2", "choice3", "choice4", "answer", "points"
            }
        ));
        addtable.setEnabled(false);
        jScrollPane1.setViewportView(addtable);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Number: ");

        adnum.setBackground(new java.awt.Color(255, 255, 255));
        adnum.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        adnum.setForeground(new java.awt.Color(51, 51, 51));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Question: ");

        adquest.setBackground(new java.awt.Color(255, 255, 255));
        adquest.setColumns(20);
        adquest.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        adquest.setForeground(new java.awt.Color(51, 51, 51));
        adquest.setRows(5);
        jScrollPane2.setViewportView(adquest);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Choice 1");

        adc1.setBackground(new java.awt.Color(255, 255, 255));
        adc1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        adc1.setForeground(new java.awt.Color(51, 51, 51));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Choice 2");

        adc2.setBackground(new java.awt.Color(255, 255, 255));
        adc2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        adc2.setForeground(new java.awt.Color(51, 51, 51));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Choice 3");

        adc3.setBackground(new java.awt.Color(255, 255, 255));
        adc3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        adc3.setForeground(new java.awt.Color(51, 51, 51));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Choice 4");

        adc4.setBackground(new java.awt.Color(255, 255, 255));
        adc4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        adc4.setForeground(new java.awt.Color(51, 51, 51));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Answer");

        adc5.setBackground(new java.awt.Color(255, 255, 255));
        adc5.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        adc5.setForeground(new java.awt.Color(51, 51, 51));
        adc5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adc5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 632, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(adnum, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(567, 567, 567)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(adc4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(adc5, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(adc3, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(adc2, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(adc1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Add, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1079, Short.MAX_VALUE)
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
                            .addComponent(Add, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(adnum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(adc1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(adc2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(adc3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(adc4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(adc5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addContainerGap(18, Short.MAX_VALUE))))
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

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
        String adn = adnum.getText();
        String adq = adquest.getText();
        String adq2 = adq.toUpperCase();
        String adch1 = adc1.getText();
        String adch12 = adch1.toUpperCase();
        String adch2 = adc2.getText();
        String adch22 = adch2.toUpperCase();
        String adch3 = adc3.getText();
        String adch32 = adch3.toUpperCase();
        String adch4 = adc4.getText();
        String adch42 = adch4.toUpperCase();
        String aass = adc5.getText();
        String aass2 = aass.toUpperCase();
        int points = 3;
        
        // No Input
        if(adn.equals("") || adq.equals("") || adch1.equals("") || adch2.equals("") || adch3.equals("") || adch4.equals("") || aass.equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter data");
        }
        
        else {
            try {
            String check = "SELECT * FROM tbl_intermediate WHERE question = '"+adq2+"'";
            PreparedStatement ptsd = conn.prepareStatement(check);
            ResultSet rs = ptsd.executeQuery(check);

            // Question Already Exists
            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "Question Already Exist");
                clear();
            } 

            else {
                if (adch12.equals(adch22) || adch12.equals(adch32) || adch12.equals(adch42)) { // 1st Choice
                    JOptionPane.showMessageDialog(this, "You have the two or more choices that are the same");
                } 
                else if (adch22.equals(adch12) || adch22.equals(adch32) || adch22.equals(adch42)) { // 2nd Choice
                    JOptionPane.showMessageDialog(this, "You have the two or more choices that are the same");
                } 
                else if (adch32.equals(adch12) || adch32.equals(adch22) || adch32.equals(adch42)) { // 3rd Choice
                    JOptionPane.showMessageDialog(this, "You have the two or more choices that are the same");
                } 
                else if (adch42.equals(adch12) || adch42.equals(adch22) || adch42.equals(adch32)) { // 4th Choice
                    JOptionPane.showMessageDialog(this, "You have the two or more choices that are the same");
                } 
                else if (adch12.equals("") || adch22.equals("") || adch32.equals("") || adch42.equals("")) { // No Choice
                    JOptionPane.showMessageDialog(this, "You have incomplete choices");
                }

                else if (adch12.equals(aass2) || adch22.equals(aass2) || adch32.equals(aass2) || adch42.equals(aass2)) { // Answer is in the Choices
                    int action = JOptionPane.showConfirmDialog(this, "Add Question?", "VERIFY", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);//show confirm dialog
                    if(action == JOptionPane.YES_OPTION){//if the admin really wants to add an item
                    try {
                        conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
                        String sql = "INSERT INTO tbl_intermediate VALUES ('"+adn+"', '"+adq2+"', '"+adch12+"', '"+adch22+"', '"+adch32+"', '"+adch42+"', '"+aass2+"', '"+points+"')";
                        PreparedStatement pst = conn.prepareStatement(sql);
                        pst.executeUpdate();

                        getDateAndTime();
                        setUpdate();
                        JOptionPane.showMessageDialog(this, "Question Recorded");            
                        clear();
                    } 
                    catch (SQLException e) {
                        System.out.println("Failed To Connect");
                    }   
                }
                }
                else {
                    JOptionPane.showMessageDialog(this, "You have no choices that are the right answer");
                }
            }
        }
        catch (SQLException e) {
                System.out.println("Failed To Connect");
        }
        }
        updateTable();
        setQuestionNumber();
    }//GEN-LAST:event_AddActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        new AdminIntermediate(username).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backActionPerformed

    private void adc5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adc5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_adc5ActionPerformed

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
            java.util.logging.Logger.getLogger(AddQuestionsIntermediate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddQuestionsIntermediate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddQuestionsIntermediate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddQuestionsIntermediate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddQuestionsIntermediate().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add;
    private javax.swing.JTextField adc1;
    private javax.swing.JTextField adc2;
    private javax.swing.JTextField adc3;
    private javax.swing.JTextField adc4;
    private javax.swing.JTextField adc5;
    private javax.swing.JTable addtable;
    private javax.swing.JLabel admin;
    private javax.swing.JTextField adminuser;
    private javax.swing.JTextField adnum;
    private javax.swing.JTextArea adquest;
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
    // End of variables declaration//GEN-END:variables
}
