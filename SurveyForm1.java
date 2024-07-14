import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SurveyForm1 extends JFrame implements ActionListener , ItemListener {
    JLabel jLabel1, jLabelQts1 ,jLabelQts2 , jLabelQts3 , jLabelQts4 , jLabelQts5 , jLabelQts6;
    JLabel showExp;
    ImageIcon imageIconLogo;
    JPanel jPanel , jPanelSlider;
    JRadioButton poorBtn , goodBtn , veryGoodBtn , excellentBtn;
    JRadioButton badCond , goodCond , bestCond ;
    JButton jButtonNext , jButtonSubmit;
    ButtonGroup group1 , group2;
    JSlider jSlider;
    JTextArea jTextArea1;
    JComboBox comboBox;
    JCheckBox jCheckBox1 , jCheckBox2, jCheckBox3, jCheckBox4, jCheckBox5 ;
    static String choice1 = "unchecked";
    static String choice2 = "unchecked";
    static String choice3="unchecked" ;
    static String choice4="unchecked" ;
    static String choice5="unchecked";
    static String choice6 ;
    static String choice7;
    static String choice8;
    static String choice9;
    static String choice10;
    int a;
//    String [] serviceImprove = new String[6];

    SurveyForm1(){
        imageIconLogo = new ImageIcon("survey.png");

        jLabel1 = new JLabel("PRODUCT SURVEY");
        jLabel1.setBounds(380 , 30 , 250 , 30);
        jLabel1.setFont(new Font("Algerian" , Font.BOLD , 25));
//        jLabel1.setBackground(Color.cyan);
//        jLabel1.setOpaque(true);
        jLabel1.setForeground(Color.white);

//        ---------------------  qts 1 ------------------------------------------

        jLabelQts1 = new JLabel();
        jLabelQts1.setText("1} What is the condition of product on arrival?");
        jLabelQts1.setBounds(30 , 100 , 400 , 30);
        jLabelQts1.setFont(new Font("Times New Roman", Font.BOLD , 20));
        jLabelQts1.setBackground(null);
        jLabelQts1.setOpaque(true);
        jLabelQts1.setForeground(Color.WHITE);

        poorBtn = new JRadioButton("Poor");
        poorBtn.setBounds(50 , 150 , 60 , 30);
        poorBtn.setFocusable(false);
        poorBtn.setBackground(null);
        poorBtn.addActionListener(this);

        goodBtn = new JRadioButton("Good");
        goodBtn.setBounds(130 , 150 , 60 , 30);
        goodBtn.setFocusable(false);
        goodBtn.setBackground(null);
        goodBtn.addActionListener(this);

        veryGoodBtn = new JRadioButton("Very Good");
        veryGoodBtn.setBounds(210 , 150 , 110 , 30);
        veryGoodBtn.setFocusable(false);
        veryGoodBtn.setBackground(null);
        veryGoodBtn.addActionListener(this);

        excellentBtn = new JRadioButton("Excellent");
        excellentBtn.setBounds(340 , 150 , 100 , 30);
        excellentBtn.setFocusable(false);
        excellentBtn.setBackground(null);
        excellentBtn.addActionListener(this);

        group1 = new ButtonGroup();
        group1.add(poorBtn);
        group1.add(goodBtn);
        group1.add(veryGoodBtn);
        group1.add(excellentBtn);

//        ------------------------------  qts 2 ---------------------------

        jLabelQts2 = new JLabel();
        jLabelQts2.setText("2} What is working condition of the product?");
        jLabelQts2.setBounds(30 , 200 , 400 , 30);
        jLabelQts2.setFont(new Font("Times New Roman", Font.BOLD, 20));
        jLabelQts2.setBackground(null);
        jLabelQts2.setOpaque(true);
        jLabelQts2.setForeground(Color.WHITE);

        badCond = new JRadioButton("Bad");
        badCond.setBounds(50 , 240 , 60 , 30);
        badCond.setFocusable(false);
        badCond.setBackground(null);
        badCond.addActionListener(this);

        goodCond = new JRadioButton("Good");
        goodCond.setBounds(130 , 240 , 70 , 30);
        goodCond.setFocusable(false);
        goodCond.setBackground(null);
        goodCond.addActionListener(this);

        bestCond = new JRadioButton("Best");
        bestCond.setBounds(210 , 240 , 70 , 30);
        bestCond.setFocusable(false);
        bestCond.setBackground(null);
        bestCond.addActionListener(this);

        group2 = new ButtonGroup();
        group2.add(badCond);
        group2.add(goodCond);
        group2.add(bestCond);

//         ----------------------------- qts 3 ----------------------------------------

        jLabelQts3 = new JLabel();
        jLabelQts3.setText("3} How satisfied are you with our product?");
        jLabelQts3.setBounds(30 , 280 , 400 , 30);
        jLabelQts3.setFont(new Font("Times New Roman", Font.BOLD , 20));
        jLabelQts3.setBackground(null);
        jLabelQts3.setOpaque(true);
        jLabelQts3.setForeground(Color.WHITE);

        showExp = new JLabel("Default");
        showExp.setBounds(370, 320, 150 , 30);
        showExp.setFont(new Font("Times New Roman", Font.BOLD , 18));
        showExp.setForeground(Color.YELLOW);

        jPanelSlider = new JPanel();
        jPanelSlider.setBounds(50 , 320 , 300 , 50);
        jPanelSlider.setBackground(null);

        jSlider = new JSlider(0, 10 , 0);
        jSlider.setBounds(50 , 340 , 400 , 50);
        jSlider.setPaintTicks(true);
        jSlider.setMinorTickSpacing(1);

        jSlider.setPaintTrack(true);
        jSlider.setMajorTickSpacing(2);
        jSlider.setPaintLabels(true);

        jSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                a = jSlider.getValue();

                if (0 < a && a <= 2){
                    showExp.setText("Ok");
                }
                if (2 < a && a <= 4){
                    showExp.setText("Good");
                }
                if (4 < a && a <= 6){
                    showExp.setText("Very Good");
                }
                if (6 < a && a <= 8){
                    showExp.setText("Better");
                }
                if (8 < a && a <= 10){
                    showExp.setText("Excellent");
                }
            }
        });

//      ----------------------------- qts 4 ----------------------------------------

        jLabelQts4 = new JLabel();
        jLabelQts4.setText("4} What improvements would you suggest for our product?");
        jLabelQts4.setBounds(460 , 100 , 550 , 30);
        jLabelQts4.setFont(new Font("Times New Roman", Font.BOLD , 20));
        jLabelQts4.setBackground(null);
        jLabelQts4.setOpaque(true);
        jLabelQts4.setForeground(Color.WHITE);

        jTextArea1 = new JTextArea();
        jTextArea1.setBounds(500 , 150 , 400 , 100);
        jTextArea1.setFont(new Font("Times New Roman",Font.BOLD, 18));

//        ------------------------------  qts 5 --------------------------------------

        jLabelQts5 = new JLabel();
        jLabelQts5.setText("5} What is the experience with our product?");
        jLabelQts5.setBounds(460 , 280 , 550 , 30);
        jLabelQts5.setFont(new Font("Times New Roman", Font.BOLD , 20));
        jLabelQts5.setBackground(null);
        jLabelQts5.setOpaque(true);
        jLabelQts5.setForeground(Color.WHITE);

        String [] experience = {"Not Satisfied", "Satisfied" , "Excellent"};
        comboBox = new JComboBox<>(experience);
        comboBox.setBounds(500 , 320 , 200 , 30);

//        ------------------------------ qts 6 ---------------------------------------

        jLabelQts6 = new JLabel();
        jLabelQts6.setText("6} On which field do you want us to improve:");
        jLabelQts6.setBounds(30 , 400 , 400 , 30);
        jLabelQts6.setFont(new Font("Times New Roman", Font.BOLD , 20));
        jLabelQts6.setBackground(null);
        jLabelQts6.setOpaque(true);
        jLabelQts6.setForeground(Color.WHITE);

        jCheckBox1 = new JCheckBox("Packaging");
        jCheckBox1.setBounds(50 , 430 , 150 , 30);
        jCheckBox1.setBackground(null);
        jCheckBox1.setFocusable(false);
        jCheckBox1.addItemListener(this);

        jCheckBox2 = new JCheckBox("Delivery");
        jCheckBox2.setBounds(250 , 430 , 130 , 30);
        jCheckBox2.setBackground(null);
        jCheckBox2.setFocusable(false);
        jCheckBox2.addItemListener(this);

        jCheckBox3 = new JCheckBox("Product Reliability");
        jCheckBox3.setBounds(420 , 430 , 150 , 30);
        jCheckBox3.setBackground(null);
        jCheckBox3.setFocusable(false);
        jCheckBox3.addItemListener(this);

        jCheckBox4 = new JCheckBox("Product Cost");
        jCheckBox4.setBounds(50 , 460 , 150 , 30);
        jCheckBox4.setBackground(null);
        jCheckBox4.setFocusable(false);
        jCheckBox4.addItemListener(this);

        jCheckBox5 = new JCheckBox("Discounts");
        jCheckBox5.setBounds(250 , 460 , 130 , 30);
        jCheckBox5.setBackground(null);
        jCheckBox5.setFocusable(false);
        jCheckBox5.addItemListener(this);

//        ---------------------------------------------------------------------------------

//        jButtonNext = new JButton("Next ->");
//        jButtonNext.setBounds(650 , 500 , 100 , 30);
//        jButtonNext.setFocusable(false);
//        jButtonNext.addActionListener(this);

        jButtonSubmit = new JButton("Submit Survey");
        jButtonSubmit.setBounds(400 , 550 , 130 , 30);
        jButtonSubmit.setFocusable(false);
        jButtonSubmit.addActionListener(this);

        jPanel = new JPanel();
        jPanel.setBounds(0, 0, 1000 , 80);
        jPanel.setBackground(new Color(22 , 123 , 123));

        this.setSize(1000 , 650);
        this.setTitle("Product Survey Form");
        this.setIconImage(imageIconLogo.getImage());
        this.getContentPane().setBackground(new Color(123 , 123 , 123));
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        this.add(jLabel1);
        this.add(jLabelQts1);
        this.add(jLabelQts2);
        this.add(jLabelQts3);
        this.add(jLabelQts4);

        this.add(poorBtn);
        this.add(goodBtn);
        this.add(veryGoodBtn);
        this.add(excellentBtn);

        this.add(badCond);
        this.add(goodCond);
        this.add(bestCond);

//        this.add(jSlider);
        this.add(jPanelSlider);
        jPanelSlider.add(jSlider);
        this.add(showExp);

        this.add(jTextArea1);
//        this.add(jButtonNext);

        this.add(jLabelQts5);
        this.add(comboBox);

        this.add(jLabelQts6);
        this.add(jCheckBox1);
        this.add(jCheckBox2);
        this.add(jCheckBox3);
        this.add(jCheckBox4);
        this.add(jCheckBox5);

        this.add(jButtonSubmit);

        this.add(jPanel);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private static final String url = "jdbc:mysql://localhost:3306/userresponse";
    private static final String username = "root";
    private static final String password = "20sd0128";

    public void connection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try {
            Connection connection1 = DriverManager.getConnection(url,username ,password);
            String query = "INSERT INTO responseinfo (prod_condition, work_condition, prod_satisfaction, suggestion, experience, packaging, delivery, prod_reliable, prod_cost, discounts) VALUES (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement1 = connection1.prepareStatement(query);
            preparedStatement1.setString(1, choice6);
            preparedStatement1.setString(2, choice7);
            preparedStatement1.setString(3, choice8);
            preparedStatement1.setString(4, choice9);
            preparedStatement1.setString(5, choice10);

            preparedStatement1.setString(6, choice1);
            preparedStatement1.setString(7, choice2);
            preparedStatement1.setString(8, choice3);
            preparedStatement1.setString(9, choice4);
            preparedStatement1.setString(10, choice5);

            int rowsAffected = preparedStatement1.executeUpdate();

            if (rowsAffected > 0){
                System.out.println("data inserted");
            }
            else {
                System.out.println("data not inserted");
            }

        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        SurveyForm1 obj = new SurveyForm1();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        -------------------------------------------------------------------
            if (e.getSource() == poorBtn){
                choice6 = "poor";
            }
            if (e.getSource() == goodBtn){
                choice6 = "good";
            }
            if (e.getSource() == veryGoodBtn){
                choice6 = "very good";
            }
            if (e.getSource() == excellentBtn){
                choice6 = "excellent";
            }

//        ----------------------------------------------------------
        if (e.getSource() == badCond){
            choice7 = badCond.getText();
        }
        if (e.getSource() == goodCond){
            choice7 = goodCond.getText();
        }
        if (e.getSource() == bestCond){
            choice7 = bestCond.getText();
        }

//  ---------------------------------------------------------------
        choice8 = showExp.getText();
//  --------------------------------------------------------------
        choice9 = jTextArea1.getText();
//  ------------------------------------------------------------
        choice10 = (String)comboBox.getSelectedItem();
//  --------------------------------------------------------------------
        if (e.getSource() == jButtonSubmit){
            JOptionPane.showMessageDialog(null , "Thankyou for your response" ,
                    "Product Survey", JOptionPane.PLAIN_MESSAGE);

            connection();

        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == jCheckBox1){
            choice1 = "Checked";
        }
        if (e.getSource() == jCheckBox2){
            choice2 = "Checked";
        }
        if (e.getSource() == jCheckBox3){
            choice3 = "Checked";
        }
        if (e.getSource() == jCheckBox4){
            choice4 = "Checked";
        }
        if (e.getSource() == jCheckBox5){
            choice5 = "Checked";
        }
    }
}
