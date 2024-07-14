import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class SurveyForm2 extends JFrame implements ActionListener {
    ImageIcon imageIconLogo;
    JLabel jLabel1 , jLabelQts5 , jLabelQts6;
    JPanel jPanel1;
    JComboBox comboBox;
    JCheckBox jCheckBox1 , jCheckBox2 , jCheckBox3 , jCheckBox4 , jCheckBox5 , jCheckBox6;
    JButton jButtonPrevious , jButtonSubmit;

//---------------------------------------------------------------------------------------
    SurveyForm2 (){
        imageIconLogo = new ImageIcon("survey.png");

        jLabel1 = new JLabel("PRODUCT SURVEY");
        jLabel1.setBounds(280 , 30 , 250 , 30);
        jLabel1.setFont(new Font("Algerian" , Font.BOLD , 25));
//        jLabel1.setBackground(Color.cyan);
//        jLabel1.setOpaque(true);
        jLabel1.setForeground(Color.white);

//        ------------------------------------ qts 5 -----------------------------------

        jLabelQts5 = new JLabel();
        jLabelQts5.setText("5} On a scale of experience, how satisfied are you with our product?");
        jLabelQts5.setBounds(50 , 100 , 550 , 30);
        jLabelQts5.setFont(new Font("Times New Roman", Font.TRUETYPE_FONT , 20));
        jLabelQts5.setBackground(null);
        jLabelQts5.setOpaque(true);
        jLabelQts5.setForeground(Color.WHITE);

        String [] experience = {"Not Satisfied" , "Satisfied" , "Nice"};
        comboBox = new JComboBox<>(experience);
        comboBox.setBounds(70 , 150 , 200 , 30);

//        ---------------------------------------- qts 6 -----------------------------------

        jLabelQts6 = new JLabel();
        jLabelQts6.setText("6} On which field do you want us to improve:");
        jLabelQts6.setBounds(50 , 250 , 400 , 30);
        jLabelQts6.setFont(new Font("Times New Roman", Font.TRUETYPE_FONT , 20));
        jLabelQts6.setBackground(null);
        jLabelQts6.setOpaque(true);
        jLabelQts6.setForeground(Color.WHITE);

        jCheckBox1 = new JCheckBox("Packaging");
        jCheckBox1.setBounds(70 , 300 , 150 , 30);
        jCheckBox1.setBackground(null);
        jCheckBox1.setFocusable(false);

        jCheckBox2 = new JCheckBox("Delivery");
        jCheckBox2.setBounds(250 , 300 , 130 , 30);
        jCheckBox2.setBackground(null);
        jCheckBox2.setFocusable(false);

        jCheckBox3 = new JCheckBox("Product Reliability");
        jCheckBox3.setBounds(420 , 300 , 150 , 30);
        jCheckBox3.setBackground(null);
        jCheckBox3.setFocusable(false);

        jCheckBox4 = new JCheckBox("Product Cost");
        jCheckBox4.setBounds(70 , 350 , 150 , 30);
        jCheckBox4.setBackground(null);
        jCheckBox4.setFocusable(false);

        jCheckBox5 = new JCheckBox("Discounts");
        jCheckBox5.setBounds(250 , 350 , 130 , 30);
        jCheckBox5.setBackground(null);
        jCheckBox5.setFocusable(false);

        jCheckBox6 = new JCheckBox("Your over all service is good");
        jCheckBox6.setBounds(420 , 350 , 190 , 30);
        jCheckBox6.setBackground(null);
        jCheckBox6.setFocusable(false);

        jPanel1 = new JPanel();
        jPanel1.setBounds(0 , 0 , 800 , 80);
        jPanel1.setBackground(new Color(22 , 123, 123));

        jButtonPrevious = new JButton("<- Previous");
        jButtonPrevious.setBounds(30 , 500 , 100 , 30);
        jButtonPrevious.setFocusable(false);
        jButtonPrevious.addActionListener(this);

        jButtonSubmit = new JButton("Submit Response");
        jButtonSubmit.setBounds(300 , 500 , 180 , 30);
        jButtonSubmit.setFocusable(false);
        jButtonSubmit.addActionListener(this);

        this.setSize(800 , 600);
        this.setTitle("Product Survey Form");
        this.setIconImage(imageIconLogo.getImage());
        this.getContentPane().setBackground(new Color(123 , 123 , 123));
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        this.add(jLabel1);
        this.add(jPanel1);
        this.add(jLabelQts5);
        this.add(jLabelQts6);

        this.add(comboBox);

        this.add(jCheckBox1);
        this.add(jCheckBox2);
        this.add(jCheckBox3);
        this.add(jCheckBox4);
        this.add(jCheckBox5);
        this.add(jCheckBox6);

        this.add(jButtonPrevious);
        this.add(jButtonSubmit);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public static void main(String[] args) {
        SurveyForm2 obj = new SurveyForm2();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jButtonPrevious){
            SurveyForm1 obj = new SurveyForm1();
        }
        if (e.getSource() == jButtonSubmit){
            this.dispose();
        }
        if (e.getSource() == jButtonSubmit){
            JOptionPane.showMessageDialog(null , "Thank you for your response", "Product Survey",JOptionPane.PLAIN_MESSAGE);
        }
    }
}
