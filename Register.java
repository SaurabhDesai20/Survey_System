import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Arrays;
import java.util.Objects;

public class Register extends JFrame implements ActionListener {
    JLabel jl1 , jl2 , jlUser , jLabelUserName , jLabelPassword , jLabelshow;
    JPasswordField jPassword;
    JTextField jTextField1 ;
    JButton jButtonLogin  , jButtonProceed, jHide_Show_btn;
    JPanel jPanel1;
    ImageIcon imageIconUser , imageIconShow , imageIconHide , imageIconLogo;

//    ------------------------------ database connection------------------------

//    static String storeName , storePassword;
//    static String name1;
//    static String password1;

    Register(){
        jl1 = new JLabel();
        jl1.setText("Register Into Account");
        jl1.setFont(new Font("Times New Roman" , Font.BOLD , 25));
        jl1.setBounds(300 , 100 , 300 , 30);
//        jl1.setBackground(Color.cyan);
//        jl1.setOpaque(true);

        imageIconUser = new ImageIcon("profile.png");
        imageIconHide = new ImageIcon("hide.png");
        imageIconShow = new ImageIcon("show.png");
        imageIconLogo = new ImageIcon("login.png");

        jl2 = new JLabel();
        jl2.setIcon(imageIconUser);

        jlUser = new JLabel("USER");
        jlUser.setFont(new Font("Times New Roman" , Font.BOLD , 22));
        jlUser.setBounds(50 , 170 , 80 , 30);
        jlUser.setBackground(new Color(22, 123, 123));
        jlUser.setOpaque(true);
        jlUser.setForeground(Color.white);

        jLabelUserName = new JLabel("Username : ");
        jLabelUserName.setBounds(250 , 200 , 110 , 30);
        jLabelUserName.setFont(new Font("Roboto" , Font.PLAIN , 20));
//        jLabelUserName.setBackground(Color.cyan);
//        jLabelUserName.setOpaque(true);

        jTextField1 = new JTextField();
        jTextField1.setBounds(370 , 200 , 200 , 30);
        jTextField1.setFont(new Font("Times New Roman" , Font.BOLD , 18));
//        storeName = jTextField1.getText();

//        jLabelshow = new JLabel(storeName);
//        jLabelshow.setBounds(400 , 400 , 200 , 30);

        jLabelPassword = new JLabel("Password : ");
        jLabelPassword.setBounds(250 , 270 , 110 , 30);
        jLabelPassword.setFont(new Font("Roboto" , Font.PLAIN , 20));
//        jLabelPassword.setBackground(Color.cyan);
//        jLabelPassword.setOpaque(true);

        jPassword = new JPasswordField();
        jPassword.setBounds(370 , 270 , 200 , 30);
        jPassword.setEchoChar('*');
        jPassword.setFont(new Font("Times New Roman", Font.BOLD, 18));
//        storePassword = Arrays.toString(jPassword.getPassword());

        jHide_Show_btn = new JButton();
        jHide_Show_btn.setIcon(imageIconShow);
        jHide_Show_btn.setBounds(580 , 270 , 60 , 30);
        jHide_Show_btn.setFocusable(false);

        jHide_Show_btn.addActionListener(new ActionListener() {
            int i = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                i++;
                if (i % 2 != 0){
                    jHide_Show_btn.setIcon(imageIconHide);
                    jPassword.setEchoChar((char) 0);
                }
                if (i % 2 == 0){
                    jHide_Show_btn.setIcon(imageIconShow);
                    jPassword.setEchoChar('*');
                }
            }
        });

        jButtonLogin = new JButton("Login");
        jButtonLogin.setBounds(350 , 330 , 100 , 40);
        jButtonLogin.setFocusable(false);
        jButtonLogin.setFont(new Font("Roboto" , Font.BOLD , 15));
        jButtonLogin.addActionListener(this);

        jButtonProceed = new JButton("Proceed to survey");
        jButtonProceed.setBounds(300 , 390 , 200 , 40);
        jButtonProceed.setFocusable(false);
        jButtonProceed.addActionListener(this);

        jPanel1 = new JPanel();
        jPanel1.setBounds(0 , 0 , 180 , 500);
        jPanel1.setBackground(new Color(22, 123, 123));

//        ------------------------  Frame -----------------------------------
        this.setSize(800, 500);
        this.setTitle("Account Login");
        this.setIconImage(imageIconLogo.getImage());
        this.getContentPane().setBackground(new Color(123 , 123 , 123));
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        this.add(jl1);
        this.add(jlUser);
        this.add(jLabelUserName);
        this.add(jLabelPassword);
        this.add(jTextField1);
        this.add(jPassword);
        this.add(jButtonLogin);
        this.add(jHide_Show_btn);
        this.add(jPanel1);
//
//        this.add(jLabelshow);
        jPanel1.add(jl2);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private static final String url = "jdbc:mysql://localhost:3306/userdatabase";
    private static final String username = "root";
    private static final String password = "20sd0128";

    static String storeName , storePassword;
    static String name1;
    static String password1;

    public static void main(String[] args) {
        Register obj = new Register();
//        -------------------------------------------------------------------------------
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try {
            Connection connection1 = DriverManager.getConnection(url, username , password);
            Statement statement1 = connection1.createStatement();
            String query = "select * from usertable";
            ResultSet resultSet1 = statement1.executeQuery(query);

            while (resultSet1.next()){
                name1 = resultSet1.getString("name");
                password1 = resultSet1.getString("password");
//                System.out.println("Name : "+name1);
//                System.out.println("Password : "+password1);
            }

        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
//   ----------------------------------------------------------------------------------------

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jButtonLogin){
            storeName = jTextField1.getText();
            storePassword = jPassword.getText();

            System.out.println("new Name : "+storeName);
            System.out.println("new pswd : "+storePassword);

//            while ()

//            this.remove(jButtonLogin);
//            this.add(jButtonProceed);

//            while (){

            if (Objects.equals(name1, storeName) && Objects.equals(password1, storePassword)) {
                JOptionPane.showMessageDialog(null , "Login Successful" , "Survey login" , JOptionPane.PLAIN_MESSAGE);
                jButtonLogin.setEnabled(false);
                this.add(jButtonProceed);
            }
            else {
                JOptionPane.showMessageDialog(null, "Invalid Login", "Survey Login", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        if (e.getSource() == jButtonProceed){
            SurveyForm1 obj = new SurveyForm1();
        }
    }
}
