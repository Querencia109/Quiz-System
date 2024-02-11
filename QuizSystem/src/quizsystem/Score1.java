
package quizsystem;

import java.sql.*;
import javax.swing.*;

public class Score1 extends javax.swing.JFrame {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String CONN_STRING = "jdbc:mysql://localhost:3306/quiz_base";
    String userName, Time1, Time2, Time3;
    int attempts, score1, score2, score3;
    double result, percent;
    
    public Score1() { 
        initComponents();
        this.userName = userName;
        this.attempts = attempts;
        quizeruser.setText(this.userName);
        showScore();
        showGrade();
    }
    
    public Score1(String userName, int attempts) {
        initComponents();
        this.userName = userName;
        this.attempts = attempts;
        quizeruser.setText(this.userName);
        showScore();
        showGrade();
    }
    
    public void showScore() {
        try {
            Connection conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            String sql = "SELECT * FROM tbl_users WHERE username = '"+userName+"'";
            Statement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery(sql);
            
            if (rs.next()) {
                score1 = rs.getInt(5);
                score2 = rs.getInt(6);
                score3 = rs.getInt(7);
                Time1 = rs.getString(9);
                Time2 = rs.getString(10);
                Time3 = rs.getString(11);
            }
           
            if (attempts == 1) {
               Score1.setText(score1+" out of 46");
               time1.setText(Time1);
               
               percent = (double) score1 / 46;
               result = (double) percent * 100;
//               inform.setText(String.format("%.4g%n", result)+"%");
              
               attempt2.setVisible(false);
               Score2.setVisible(false);
               time2.setVisible(false);
               
               attempt3.setVisible(false);
               Score3.setVisible(false);
               time3.setVisible(false);
            }
            else if (attempts > 1 && attempts < 3) {
               Score1.setText(score1+" out of 46");
               time1.setText(Time1);

               Score2.setText(score2+" out of 46");
               time2.setText(Time2);
               
               percent = (double) score2 / 46;
               result = (double) percent * 100;
//               inform.setText(String.format("%.4g%n", result)+"%");
               
               attempt3.setVisible(false);
               Score3.setVisible(false);
               time3.setVisible(false);
            }
            else if (attempts > 2 && attempts < 4) {
               Score1.setText(score1+" out of 46");
               time1.setText(Time1);

               Score2.setText(score2+" out of 46");
               time2.setText(Time2);

               Score3.setText(score3+" out of 46");
               time3.setText(Time3);
               
               percent = (double) score3 / 46;
               result = (double) percent * 100;
//               inform.setText(String.format("%.4g%n", result)+"%");
            }
        }
        catch (SQLException e) {
            System.out.println("Failed To Connect");
        }
    }
    
    public void showGrade() {
        if (result >= 96.00) { // 4.00
            inform.setText("Grade Point: 4.00");
            description.setText("Excellent!");
            description1.setText("You are very knowledgeable about the quiz!");
        }
        else if (result <= 95.99 && result >= 90.00) { // 3.50
            inform.setText("Grade Point: 3.50");
            description.setText("Very Good!");
            description1.setText("You are an almost quiz master!");
        }
        else if (result <= 89.99 && result >= 84.00) { // 3.00
            inform.setText("Grade Point: 3.00");
            description.setText("Good!");
            description1.setText("I know you can do better!");
        }
        else if (result <= 83.99 && result >= 78.00) { // 2.50
            inform.setText("Grade Point: 2.50");
            description.setText("Above Satisfactory!");
            description1.setText("Strive harder quizzer!");
        }
        else if (result <= 77.99 && result >= 72.00) { // 2.00
            inform.setText("Grade Point: 2.00");
            description.setText("Satisfactory!");
            description1.setText("Aim higher quizzer!");
        }
        else if (result <= 71.99 && result >= 66.00) { // 1.50
            inform.setText("Grade Point: 1.50");
            description.setText("Fair!");
            description1.setText("Add some more!");
        }
        else if (result <= 65.99 && result >= 60.00) { // 1.00
            inform.setText("Grade Point: 1.00");
            description.setText("Pass!");
            description1.setText("Aim for the top next time!");
        }
        else if (result <= 59.99 && result >= 1.00) { // Repeat
            inform.setText("YOU NEED TO REPEAT");
            description.setText("Repeat!");
            description1.setText("Pass your next attempts!");
        }
        else if (result == 0) { // Fail
            inform.setText("FAILED");
            description.setText("Failed.");
            description1.setText("You got a failing grade. Better luck next time.");
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        Score4 = new javax.swing.JTextField();
        Score5 = new javax.swing.JTextField();
        Score6 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        exit = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        inform = new javax.swing.JTextField();
        description = new javax.swing.JLabel();
        tryAgain = new javax.swing.JButton();
        attempt1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        quizeruser = new javax.swing.JTextField();
        attempt3 = new javax.swing.JTextField();
        attempt2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        Score3 = new javax.swing.JTextField();
        Score2 = new javax.swing.JTextField();
        Score1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        time3 = new javax.swing.JTextField();
        time2 = new javax.swing.JTextField();
        time1 = new javax.swing.JTextField();
        description1 = new javax.swing.JLabel();

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("SCORE");

        Score4.setEditable(false);
        Score4.setBackground(new java.awt.Color(255, 255, 255));
        Score4.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        Score4.setForeground(new java.awt.Color(51, 51, 51));
        Score4.setText("quizeruser");
        Score4.setBorder(null);

        Score5.setEditable(false);
        Score5.setBackground(new java.awt.Color(255, 255, 255));
        Score5.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        Score5.setForeground(new java.awt.Color(51, 51, 51));
        Score5.setText("quizeruser");
        Score5.setBorder(null);
        Score5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Score5ActionPerformed(evt);
            }
        });

        Score6.setEditable(false);
        Score6.setBackground(new java.awt.Color(255, 255, 255));
        Score6.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        Score6.setForeground(new java.awt.Color(51, 51, 51));
        Score6.setText("quizeruser");
        Score6.setBorder(null);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(51, 153, 255));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("RESULT");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel4)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        exit.setBackground(new java.awt.Color(255, 102, 102));
        exit.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        exit.setForeground(new java.awt.Color(255, 255, 255));
        exit.setText("EXIT");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        logout.setBackground(new java.awt.Color(255, 102, 102));
        logout.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        logout.setForeground(new java.awt.Color(255, 255, 255));
        logout.setText("Log Out");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("NAME:");

        inform.setEditable(false);
        inform.setBackground(new java.awt.Color(255, 255, 255));
        inform.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        inform.setForeground(new java.awt.Color(51, 51, 51));
        inform.setText("Grade Point");
        inform.setBorder(null);

        description.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        description.setForeground(new java.awt.Color(51, 51, 51));
        description.setText("description");

        tryAgain.setBackground(new java.awt.Color(255, 204, 51));
        tryAgain.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        tryAgain.setForeground(new java.awt.Color(255, 255, 255));
        tryAgain.setText("TRY AGAIN");
        tryAgain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tryAgainActionPerformed(evt);
            }
        });

        attempt1.setEditable(false);
        attempt1.setBackground(new java.awt.Color(255, 255, 255));
        attempt1.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        attempt1.setForeground(new java.awt.Color(51, 51, 51));
        attempt1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        attempt1.setText("Attempt 1");
        attempt1.setBorder(null);
        attempt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attempt1ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("ATTEMPT");

        quizeruser.setEditable(false);
        quizeruser.setBackground(new java.awt.Color(255, 255, 255));
        quizeruser.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        quizeruser.setForeground(new java.awt.Color(51, 51, 51));
        quizeruser.setText("quizeruser");
        quizeruser.setBorder(null);

        attempt3.setEditable(false);
        attempt3.setBackground(new java.awt.Color(255, 255, 255));
        attempt3.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        attempt3.setForeground(new java.awt.Color(51, 51, 51));
        attempt3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        attempt3.setText("Attempt 3");
        attempt3.setBorder(null);

        attempt2.setEditable(false);
        attempt2.setBackground(new java.awt.Color(255, 255, 255));
        attempt2.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        attempt2.setForeground(new java.awt.Color(51, 51, 51));
        attempt2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        attempt2.setText("Attempt 2");
        attempt2.setBorder(null);
        attempt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attempt2ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("SCORE");

        Score3.setEditable(false);
        Score3.setBackground(new java.awt.Color(255, 255, 255));
        Score3.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        Score3.setForeground(new java.awt.Color(51, 51, 51));
        Score3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Score3.setText("score 3");
        Score3.setBorder(null);

        Score2.setEditable(false);
        Score2.setBackground(new java.awt.Color(255, 255, 255));
        Score2.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        Score2.setForeground(new java.awt.Color(51, 51, 51));
        Score2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Score2.setText("score 2");
        Score2.setBorder(null);
        Score2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Score2ActionPerformed(evt);
            }
        });

        Score1.setEditable(false);
        Score1.setBackground(new java.awt.Color(255, 255, 255));
        Score1.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        Score1.setForeground(new java.awt.Color(51, 51, 51));
        Score1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Score1.setText("score 1");
        Score1.setBorder(null);

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("TIME TAKEN");

        time3.setEditable(false);
        time3.setBackground(new java.awt.Color(255, 255, 255));
        time3.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        time3.setForeground(new java.awt.Color(51, 51, 51));
        time3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        time3.setText("time 3");
        time3.setBorder(null);

        time2.setEditable(false);
        time2.setBackground(new java.awt.Color(255, 255, 255));
        time2.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        time2.setForeground(new java.awt.Color(51, 51, 51));
        time2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        time2.setText("time 2");
        time2.setBorder(null);
        time2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                time2ActionPerformed(evt);
            }
        });

        time1.setEditable(false);
        time1.setBackground(new java.awt.Color(255, 255, 255));
        time1.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        time1.setForeground(new java.awt.Color(51, 51, 51));
        time1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        time1.setText("time 1");
        time1.setBorder(null);

        description1.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        description1.setForeground(new java.awt.Color(51, 51, 51));
        description1.setText("description");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 517, Short.MAX_VALUE)
                .addComponent(tryAgain, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(logout)
                .addGap(18, 18, 18)
                .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(174, 174, 174))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(46, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(attempt2)
                                                    .addComponent(attempt1)
                                                    .addComponent(attempt3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(4, 4, 4)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel7))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(quizeruser, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(77, 77, 77))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Score2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Score1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Score3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(54, 54, 54)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(time1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(time3, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(time2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(82, 82, 82)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(description)
                    .addComponent(inform, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(description1))
                .addGap(146, 146, 146))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(quizeruser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(attempt1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Score1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(time1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(attempt2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Score2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(time2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(attempt3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Score3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(time3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(inform, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(description)
                        .addGap(18, 18, 18)
                        .addComponent(description1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tryAgain, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1078, 493));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tryAgainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tryAgainActionPerformed
        if (attempts >= 3) {
            JOptionPane.showMessageDialog(this, "You've reached the maximum attempts.");
        }
        else {
            new Instructions(userName).setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_tryAgainActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        // TODO add your handling code here:
        UserLogIn login = new UserLogIn();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logoutActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_exitActionPerformed

    private void attempt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attempt2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_attempt2ActionPerformed

    private void Score2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Score2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Score2ActionPerformed

    private void Score5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Score5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Score5ActionPerformed

    private void time2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_time2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_time2ActionPerformed

    private void attempt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attempt1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_attempt1ActionPerformed

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
            java.util.logging.Logger.getLogger(Score1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Score1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Score1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Score1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Score1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Score1;
    private javax.swing.JTextField Score2;
    private javax.swing.JTextField Score3;
    private javax.swing.JTextField Score4;
    private javax.swing.JTextField Score5;
    private javax.swing.JTextField Score6;
    private javax.swing.JTextField attempt1;
    private javax.swing.JTextField attempt2;
    private javax.swing.JTextField attempt3;
    private javax.swing.JLabel description;
    private javax.swing.JLabel description1;
    private javax.swing.JButton exit;
    private javax.swing.JTextField inform;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton logout;
    private javax.swing.JTextField quizeruser;
    private javax.swing.JTextField time1;
    private javax.swing.JTextField time2;
    private javax.swing.JTextField time3;
    private javax.swing.JButton tryAgain;
    // End of variables declaration//GEN-END:variables
}
