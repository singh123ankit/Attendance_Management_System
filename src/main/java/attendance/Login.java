package attendance;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JOptionPane;
import java.sql.*;
public class Login extends JFrame implements ActionListener{
     JPasswordField pwd = new JPasswordField();
     JTextField tf1 = new JTextField();
     final String driver = "com.mysql.cj.jdbc.Driver";
     final String url = "jdbc:mysql://localhost:3306/attendance";
     final String uname = "root";
     final String pass = "poonam1612";
  public Login(){
    Image img1 = Toolkit.getDefaultToolkit().getImage("C:\\Users\\singh\\Downloads\attendance.png");
    ImageIcon img = new ImageIcon("C:\\Users\\singh\\Downloads\login1.jpg");
    this.setIconImage(img1);
    Color c = new Color(0,153,153);
    Container c1 = this.getContentPane();
    this.setLayout(null);
    c1.setBackground(c);
    JLabel lb1 = new JLabel("LOGIN");
    lb1.setBounds(620,250,400,90);
    lb1.setForeground(Color.white);
    lb1.setFont(new Font("Tahoma",Font.PLAIN,51));
    JLabel lb2 = new JLabel();
    lb2.setIcon(img);
    lb2.setBounds(570,5,250,260);
    lb2.setVisible(true);
    JLabel lb3 = new JLabel("User Name");
    JLabel lb4 = new JLabel("Password");
    lb3.setFont(new Font("Helvetica",Font.PLAIN,41));
    lb4.setFont(new Font("Helvetica",Font.PLAIN,41));
    lb3.setBounds(480,430,350,70);
    lb4.setBounds(480,540,350,70);
    lb3.setForeground(Color.white);
    lb4.setForeground(Color.white);
    tf1.setBounds(710,448,380,40);
    pwd.setBounds(710,559,380,40);
    tf1.setFont(new Font("Tahoma",Font.PLAIN,30));
    pwd.setFont(new Font("Tahoma",Font.PLAIN,30));
    JButton b1 = new JButton("SUBMIT");
    b1.setBounds(580,690,250,70);
    b1.setBackground(new Color(0,51,102));
    b1.setForeground(Color.white);
    b1.setFont(new Font("Tahoma",Font.PLAIN,41));
    this.add(lb1);
    this.add(lb2);
    this.add(lb3);
    this.add(lb4);
    this.add(tf1);
    this.add(pwd);
    this.add(b1);
    b1.addActionListener(this);
  }
  @Override
  public void actionPerformed(ActionEvent ae) throws Exception{
      String str1 = ae.getActionCommand();
      String str2 = tf1.getText();
      String str3 = pwd.getText();
      String str4 = "select * from admin";
      Class.forName(driver);
          Connection con = DriverManager.getConnection(url,uname,pass);
          Statement sta = con.createStatement();
          ResultSet rs = sta.executeQuery(str4);
      if(str1.equals("SUBMIT"))
      {
          rs.next();
          String str5 = rs.getString(1);
          String str6 = rs.getString(2);
          if(str2.equals(str5) && str3.equals(str6)){
              dispose();
              Homepage hp = new Homepage();
              hp.setSize(1400,900);
              hp.setLocationRelativeTo(null);
              hp.setTitle("Attendance Management System");
              hp.setResizable(false);
              hp.setVisible(true);
              hp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          }
          else{
             JOptionPane.showMessageDialog(this,"Incorrect Data Entered.Please Try Again!");
          
             }
      }
      con.close();
  }
 
}