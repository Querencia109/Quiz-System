
package quizsystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class QuizInterface extends javax.swing.JFrame {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String CONN_STRING = "jdbc:mysql://localhost:3306/quiz_base";
    public int attempts; // Keeps Track of the Number of Attempts
    public int questionnum = 1; // Keeps Track of the Number of Question
    public int score1 = 0; // 1st Attempt Score
    public int score2 = 0; // 2nd Attempt Score
    public int score3 = 0; // 3rd Attempt Score
    public String answer, userName;
    int randomE = 0, randomI = 0, randomH = 0;
    
    DecimalFormat dFormat = new DecimalFormat("00");
    public String ddseconds, ddminutes;
    int seconds, minute;

    public QuizInterface() {
        initComponents();
        generateEasyQuestion();
        num.setEditable(false);
        question.setEditable(false);
        submit.setVisible(false);
    }
    
    public QuizInterface(String userName, int attempts) {
        initComponents();
        generateEasyQuestion();
        num.setEditable(false);
        question.setEditable(false);
        submit.setVisible(false);
        this.userName = userName;
        this.attempts = attempts;
        quizeruser.setText(this.userName);
        System.out.println(this.userName);
        System.out.println(this.attempts);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        choices = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        choice1 = new javax.swing.JRadioButton();
        choice2 = new javax.swing.JRadioButton();
        choice3 = new javax.swing.JRadioButton();
        choice4 = new javax.swing.JRadioButton();
        next = new javax.swing.JButton();
        submit = new javax.swing.JButton();
        num = new javax.swing.JTextField();
        quizeruser = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        question = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        timer = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(51, 153, 255));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizsystem/b.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(965, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        choice1.setBackground(new java.awt.Color(255, 255, 255));
        choices.add(choice1);
        choice1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        choice1.setForeground(new java.awt.Color(0, 0, 0));
        choice1.setText("choice1");
        choice1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                choice1ActionPerformed(evt);
            }
        });

        choice2.setBackground(new java.awt.Color(255, 255, 255));
        choices.add(choice2);
        choice2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        choice2.setForeground(new java.awt.Color(0, 0, 0));
        choice2.setText("choice2");

        choice3.setBackground(new java.awt.Color(255, 255, 255));
        choices.add(choice3);
        choice3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        choice3.setForeground(new java.awt.Color(0, 0, 0));
        choice3.setText("choice3");

        choice4.setBackground(new java.awt.Color(255, 255, 255));
        choices.add(choice4);
        choice4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        choice4.setForeground(new java.awt.Color(0, 0, 0));
        choice4.setText("choice4");

        next.setBackground(new java.awt.Color(255, 204, 51));
        next.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        next.setForeground(new java.awt.Color(255, 255, 255));
        next.setText("Next");
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });

        submit.setBackground(new java.awt.Color(255, 204, 51));
        submit.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        submit.setForeground(new java.awt.Color(255, 255, 255));
        submit.setText("Submit");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        num.setBackground(new java.awt.Color(255, 255, 255));
        num.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        num.setForeground(new java.awt.Color(51, 51, 51));
        num.setText("1");
        num.setBorder(null);

        quizeruser.setEditable(false);
        quizeruser.setBackground(new java.awt.Color(255, 255, 255));
        quizeruser.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        quizeruser.setForeground(new java.awt.Color(51, 51, 51));
        quizeruser.setText("quizeruser");
        quizeruser.setBorder(null);
        quizeruser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quizeruserActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Quiz Taker: ");

        question.setEditable(false);
        question.setBackground(new java.awt.Color(255, 255, 255));
        question.setColumns(20);
        question.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        question.setForeground(new java.awt.Color(51, 51, 51));
        question.setRows(5);
        question.setText("questions\n");
        question.setBorder(null);
        jScrollPane1.setViewportView(question);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Time Left:");

        timer.setEditable(false);
        timer.setBackground(new java.awt.Color(255, 255, 255));
        timer.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        timer.setForeground(new java.awt.Color(51, 51, 51));
        timer.setText("timer");
        timer.setBorder(null);
        timer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(quizeruser, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(timer, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(num, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(choice4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
                                        .addComponent(choice3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(choice2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(choice1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 925, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(next, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(submit, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quizeruser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(timer, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(num, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(next, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(submit, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(31, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(choice1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(choice2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(choice3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(choice4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1085, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1101, 673));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    ArrayList<Integer> eQuestions = new ArrayList<>(); // Randomizing of Easy Questions
    ArrayList<Integer> iQuestions = new ArrayList<>(); // Randomizing of Intermediate Questions
    ArrayList<Integer> hQuestions = new ArrayList<>(); // Randomizing of Hard Questions
    ArrayList<String> choice = new ArrayList<>(); // Randomizing of Choices
    
    public void generateEasyQuestion() {
        Random rand = new Random(); // Randomizer
        Connection conn; // Initialize Database
        
        try {
            // Connect Database
            conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);

//            for(int i = 0; i < (eQuestions.size()) ; i++) {  
//                System.out.print(eQuestions.get(i) + " ");
//            } 

            // Size of Easy Questions Table
            String sqes = "SELECT COUNT(*) FROM tbl_easy";
            Statement ses = conn.prepareStatement(sqes);
            ResultSet rses = ses.executeQuery(sqes);
            rses.next();
            int eSize = 1 + rses.getInt(1);

            // Fetch Random Easy Question
            randomE = rand.nextInt(eSize);
            for (int i = 0; randomE == 0 || eQuestions.contains(randomE); i++) {
                randomE = rand.nextInt(eSize);
            }
//            System.out.println(randomE);
            eQuestions.add(randomE);
            
            // Easy Questions Table
            String sqe = "SELECT * FROM tbl_easy WHERE questionnum = '"+randomE+"'";
            Statement se = conn.prepareStatement(sqe);
            ResultSet rse = se.executeQuery(sqe);
            
            // The if statement here will check if there is that data type
            // Easy Questions
            if (rse.next()) {
                // Set Question and Choices
                question.setText(rse.getString("Question"));
                choice.add(rse.getString("Choice1"));
                choice.add(rse.getString("Choice2"));
                choice.add(rse.getString("Choice3"));
                choice.add(rse.getString("Choice4"));
                answer = rse.getString("answer");

                // Randomize Choices
                for (int i = 0; i != 1; i++) {
                    int randomIndex1 = rand.nextInt(choice.size());
                    choice1.setText(choice.get(randomIndex1));
                    choice.remove(randomIndex1);
                    int randomIndex2 = rand.nextInt(choice.size());
                    choice2.setText(choice.get(randomIndex2));
                    choice.remove(randomIndex2);
                    int randomIndex3 = rand.nextInt(choice.size());
                    choice3.setText(choice.get(randomIndex3));
                    choice.remove(randomIndex3);
                    int randomIndex4 = rand.nextInt(choice.size());
                    choice4.setText(choice.get(randomIndex4));
                    choice.remove(randomIndex4);
                }
            }
            else {
                JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        catch (SQLException e) {
            System.out.println("Failed To Connect");
        }
    }
    
    public void generateIntermediateQuestion() {
        Random rand = new Random(); // Randomizer
        Connection conn; // Initialize Database
        
        try {
            // Connect Database
            conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            
//            for(int i = 0; i < (iQuestions.size()) ; i++) {  
//                System.out.print(iQuestions.get(i) + " ");
//            } 

            // Size of Intermediate Questions Table
            String sqis = "SELECT COUNT(*) FROM tbl_intermediate";
            Statement sis = conn.prepareStatement(sqis);
            ResultSet rsis = sis.executeQuery(sqis);
            rsis.next();
            int iSize = rsis.getInt(1);
            
            // Fetch Random Intermediate Question
            randomI = rand.nextInt(iSize);
            for (int i = 0; randomI == 0 || iQuestions.contains(randomI); i++) {
                randomI = rand.nextInt(iSize);
            }
//            System.out.println(randomI);
            iQuestions.add(randomI);
                    
            // Intermediate Questions Table
            String sqi = "SELECT * FROM tbl_intermediate WHERE questionnum = '"+randomI+"'";
            Statement si = conn.prepareStatement(sqi);
            ResultSet rsi = si.executeQuery(sqi);
            
            if (rsi.next()) {
                // Intermediate Questions
                question.setText(rsi.getString("Question"));
                choice.add(rsi.getString("Choice1"));
                choice.add(rsi.getString("Choice2"));
                choice.add(rsi.getString("Choice3"));
                choice.add(rsi.getString("Choice4"));
                answer = rsi.getString("answer");

                //This for loop will randomize the choices 
                for (int i = 0; i != 1; i++) {
                    int randomIndex1 = rand.nextInt(choice.size());
                    choice1.setText(choice.get(randomIndex1));
                    choice.remove(randomIndex1);
                    int randomIndex2 = rand.nextInt(choice.size());
                    choice2.setText(choice.get(randomIndex2));
                    choice.remove(randomIndex2);
                    int randomIndex3 = rand.nextInt(choice.size());
                    choice3.setText(choice.get(randomIndex3));
                    choice.remove(randomIndex3);
                    int randomIndex4 = rand.nextInt(choice.size());
                    choice4.setText(choice.get(randomIndex4));
                    choice.remove(randomIndex4);
                }
            }
        }
        catch (SQLException e) {
            System.out.println("Failed To Connect");
        }
    }
    
    public void generateHardQuestion() {
        Random rand = new Random(); // Randomizer
        Connection conn; // Initialize Database
        
        try {
            // Connect Database
            conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            
//            for(int i = 0; i < (hQuestions.size()) ; i++) {  
//                System.out.print(hQuestions.get(i) + " ");
//            } 
            
            // Size of Hard Questions Table
            String sqhs = "SELECT COUNT(*) FROM tbl_hard";
            Statement shs = conn.prepareStatement(sqhs);
            ResultSet rshs = shs.executeQuery(sqhs);
            rshs.next();
            int hSize = rshs.getInt(1);
            
            // Fetch Random Intermediate Question
            randomH = rand.nextInt(hSize);
            for (int i = 0; randomH == 0 || hQuestions.contains(randomH); i++) {
                randomH = rand.nextInt(hSize);
            }
//            System.out.println(randomH);
            hQuestions.add(randomH);
            
            // Hard Questions Table
            String sqh = "SELECT * FROM tbl_hard WHERE questionnum = '"+randomH+"'";
            Statement sh = conn.prepareStatement(sqh);
            ResultSet rsh = sh.executeQuery(sqh);
            
            if (rsh.next()) {
                // Hard Questions
                question.setText(rsh.getString("Question"));
                choice.add(rsh.getString("Choice1"));
                choice.add(rsh.getString("Choice2"));
                choice.add(rsh.getString("Choice3"));
                choice.add(rsh.getString("Choice4"));
                answer = rsh.getString("answer");

                //This for loop will randomize the choices 
                for (int i = 0; i != 1; i++) {
                    int randomIndex1 = rand.nextInt(choice.size());
                    choice1.setText(choice.get(randomIndex1));
                    choice.remove(randomIndex1);
                    int randomIndex2 = rand.nextInt(choice.size());
                    choice2.setText(choice.get(randomIndex2));
                    choice.remove(randomIndex2);
                    int randomIndex3 = rand.nextInt(choice.size());
                    choice3.setText(choice.get(randomIndex3));
                    choice.remove(randomIndex3);
                    int randomIndex4 = rand.nextInt(choice.size());
                    choice4.setText(choice.get(randomIndex4));
                    choice.remove(randomIndex4);
                }
            }
            else {
                JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        catch (SQLException e) {
            System.out.println("Failed To Connect");
        }
    }

    public void checkAnswer() {
        // Getting Student Answer
        String studAnswer = "";
        
        if (choice1.isSelected()) {
            studAnswer = choice1.getText();
        } 
        else if (choice2.isSelected()) {
            studAnswer = choice2.getText();
        } 
        else if (choice3.isSelected()) {
            studAnswer = choice3.getText();
        } 
        else if (choice4.isSelected()) {
            studAnswer = choice4.getText();
        }
//        System.out.println(studAnswer);
//        System.out.println(answer);
        
        if (attempts == 0) { //Attempt 1
            if (questionnum <= 10) {
                if (studAnswer.equals(answer)) {
                    score1 += 1;
                }
            } 
            else if (questionnum <= 17 && questionnum > 10) {
                if (studAnswer.equals(answer)) {
                    score1 += 3;
                }
            }
            else if (questionnum <= 20 && questionnum > 17) {
                if (studAnswer.equals(answer)) {
                    score1 += 5;
                }
            }
        }
        else if (attempts == 1) { // Attempt 2
            if (questionnum <= 10) {
                if (studAnswer.equals(answer)) {
                    score2 += 1;
                }
            }
            else if (questionnum <= 17 && questionnum > 10) {
                if (studAnswer.equals(answer)) {
                    score2 += 3;
                }
            }
            else if (questionnum <= 20 && questionnum > 17) {
                if (studAnswer.equals(answer)) {
                    score2 += 5;
                }
            }
        } 
        else if (attempts == 2) { // Attempt 3
            if (questionnum <= 10) {
                if (studAnswer.equals(answer)) {
                    score3 += 1;
                }
            }
            else if (questionnum <= 17 && questionnum > 10) {
                if (studAnswer.equals(answer)) {
                    score3 += 3;
                }
            }
            else if (questionnum <= 20 && questionnum > 17) {
                if (studAnswer.equals(answer)) {
                    score3 += 5;
                }
            }
        }
    }

    public void submit() {
        Connection conn; // Initialize Database
        
        try {
            // Connect Database
            conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            
            if (attempts == 0) { // 1st Attempt
                String a1 = "UPDATE tbl_users SET attempt1 = '"+score1+"' WHERE username = '"+userName+"'";
                PreparedStatement pst = conn.prepareStatement(a1);
                pst.executeUpdate();
                
                attempts++;
                String sqll = "UPDATE tbl_users SET totalattempts = '"+attempts+"' WHERE username = '"+userName+"'";
                PreparedStatement pstt = conn.prepareStatement(sqll);
                pstt.executeUpdate();
                
                JOptionPane.showMessageDialog(this, "DONE");
            }
            else if (attempts == 1) { // 2nd Attempt
                String a2 = "UPDATE tbl_users SET attempt2 = '"+score2+"' WHERE username = '"+userName+"'";
                PreparedStatement pst = conn.prepareStatement(a2);
                pst.executeUpdate();
                
                attempts++;
                String sqll = "UPDATE tbl_users SET totalattempts = '"+attempts+"' WHERE username = '"+userName+"'";
                PreparedStatement pstt = conn.prepareStatement(sqll);
                pstt.executeUpdate();
                
                JOptionPane.showMessageDialog(this, "DONE");
            }
            else if (attempts == 2) { // 3rd Attempt
                String a3 = "UPDATE tbl_users SET attempt3 = '"+score3+"' WHERE username = '"+userName+"'";
                PreparedStatement pst = conn.prepareStatement(a3);
                pst.executeUpdate();
                
                attempts++;
                String sqll = "UPDATE tbl_users SET totalattempts = '"+attempts+"' WHERE username = '"+userName+"'";
                PreparedStatement pstt = conn.prepareStatement(sqll);
                pstt.executeUpdate();
                JOptionPane.showMessageDialog(this, "DONE");
            }
        }
        catch (SQLException e) {
            System.out.println("Failed To Connect");
        }
        new EndQuiz(userName, attempts).setVisible(true);
        this.dispose();
    }
    
    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        do{
            if (choice1.isSelected() == false && choice2.isSelected() == false && choice3.isSelected() == false && choice4.isSelected() == false) {
                    JOptionPane.showMessageDialog(this, "You didn't choose any answer");
            }
            else {
                checkAnswer();
                num.setText(String.valueOf(questionnum + 1));
                choices.clearSelection();
                questionnum++;
                System.out.println("Number: " + questionnum);

                if (questionnum <= 10) {
                    generateEasyQuestion();
                }
                else if (questionnum <= 17 && questionnum > 10) {
                    generateIntermediateQuestion();
                }
                else if (questionnum <= 20 && questionnum > 17) {
                    generateHardQuestion();
                }
            }

            if(questionnum == 20){
                next.setVisible(false);
                submit.setVisible(true);
            }
        }while(questionnum == 21);
    }//GEN-LAST:event_nextActionPerformed

    private void choice1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_choice1ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_choice1ActionPerformed

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        checkAnswer();
        submit();
        time.stop();
    }//GEN-LAST:event_submitActionPerformed

    private void quizeruserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quizeruserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quizeruserActionPerformed

    private void timerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_timerActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        timer.setVisible(true);
        timer.setText("10:00");
        
        seconds = 0;
        minute = 10;
        time.start();
    }//GEN-LAST:event_formWindowOpened

    Timer time = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            seconds--;
            ddseconds = dFormat.format(seconds);
            ddminutes = dFormat.format(minute);
            timer.setText(ddminutes + ":" + ddseconds);

            if (seconds == -1) {
                seconds = 59;
                minute--;
                ddseconds = dFormat.format(seconds);
                ddminutes = dFormat.format(minute);
                timer.setText(ddminutes + ":" + ddseconds);
            }
            if (minute == 0 && seconds == 0) {
                time.stop();
                submit();
                
                new EndQuiz(userName, attempts).setVisible(true);
            }
        }
    });
    
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
            java.util.logging.Logger.getLogger(QuizInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuizInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuizInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuizInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuizInterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton choice1;
    private javax.swing.JRadioButton choice2;
    private javax.swing.JRadioButton choice3;
    private javax.swing.JRadioButton choice4;
    private javax.swing.ButtonGroup choices;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton next;
    private javax.swing.JTextField num;
    private javax.swing.JTextArea question;
    private javax.swing.JTextField quizeruser;
    private javax.swing.JButton submit;
    private javax.swing.JTextField timer;
    // End of variables declaration//GEN-END:variables
}
