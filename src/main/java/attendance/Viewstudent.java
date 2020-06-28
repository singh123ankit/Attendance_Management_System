package attendance;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JOptionPane;
import java.sql.*;
public class Viewstudent extends JFrame implements ActionListener{
     JTextField tf1 = new JTextField();
     JTextField tf2 = new JTextField();
     JTextField tf3 = new JTextField();
     JTextField tf4 = new JTextField();
     JTextField tf5 = new JTextField();
     JTextField tf6 = new JTextField();
     JPanel p1 = new JPanel();
     JPanel p2 = new JPanel();
     JLabel enter = new JLabel("Enter Roll Number :");
     JButton b3 = new JButton("SEARCH");
     final String driver = "com.mysql.cj.jdbc.Driver";
     final String url = "jdbc:mysql://localhost:3306/attendance";
     final String uname = "root";
     final String pass = "poonam1612";
    public Viewstudent() {
        Image img1 = Toolkit.getDefaultToolkit().getImage("C:\\Users\\singh\\Downloads\attendance.png");
        this.setIconImage(img1);
        Color c = new Color(0,153,153);
        Container c1 = this.getContentPane();
        this.setLayout(null);
        c1.setBackground(c);
        JLabel lb1 = new JLabel("View Student");
        lb1.setBounds(530,20,400,90);
        lb1.setForeground(Color.white);
        lb1.setFont(new Font("Times New Roman",Font.PLAIN,51));
        JLabel lb2 = new JLabel("Name");
        JLabel lb3 = new JLabel("Stream");
        JLabel lb4 = new JLabel("Session");
        JLabel lb5 = new JLabel("Mobile Number");
        lb2.setFont(new Font("Helvetica",Font.PLAIN,41));
        lb3.setFont(new Font("Helvetica",Font.PLAIN,41));
        lb4.setFont(new Font("Helvetica",Font.PLAIN,41));
        lb5.setFont(new Font("Helvetica",Font.PLAIN,41));
        lb2.setBounds(20,10,400,80);
        lb3.setBounds(20,100,400,80);
        lb4.setBounds(20,190,400,80);
        lb5.setBounds(20,280,400,80);
        lb2.setForeground(Color.white);
        lb3.setForeground(Color.white);
        lb4.setForeground(Color.white);
        lb5.setForeground(Color.white);
        tf1.setBounds(500,30,410,40);
        tf3.setBounds(500,115,410,40);
        tf4.setBounds(500,200,410,40);
        tf5.setBounds(500,300,410,40);
        tf1.setFont(new Font("Tahoma",Font.PLAIN,30));
        tf3.setFont(new Font("Tahoma",Font.PLAIN,30));
        tf4.setFont(new Font("Tahoma",Font.PLAIN,30));
        tf5.setFont(new Font("Tahoma",Font.PLAIN,30));
        tf6.setBounds(500,60,410,40);
        tf6.setFont(new Font("Tahoma",Font.PLAIN,30));
        JButton b2 = new JButton("CLEAR");
        b2.setBounds(570,420,250,70);
        b2.setBackground(new Color(0,51,102));
        b2.setForeground(Color.white);
        b2.setFont(new Font("Tahoma",Font.PLAIN,41));
        b3.setForeground(Color.white);
        b3.setFont(new Font("Tahoma",Font.PLAIN,41));
        b3.setBounds(990,36,250,75);
        b3.setBackground(new Color(0,204,153));
        p1.setLayout(null);
        p2.setLayout(null);
        p1.setBounds(30,110,1330,150);
        p2.setBounds(30,280,1330,660);
        p1.setBackground(new Color(153,51,102));
        p2.setBackground(new Color(153,51,102));
        p1.setVisible(true);
        p2.setVisible(true);
        enter.setBounds(20,35,400,90);
        enter.setForeground(Color.white);
        enter.setFont(new Font("Times New Roman",Font.PLAIN,41));
        p1.add(enter);
        p1.add(tf6);
        p1.add(b3);
        p2.add(lb2);
        p2.add(lb3);
        p2.add(lb4);
        p2.add(lb5);
        p2.add(tf1);
        p2.add(tf3);
        p2.add(tf4);
        p2.add(tf5);
        p2.add(b2);
        this.add(lb1);
        this.add(p1);
        this.add(p2);
        b2.addActionListener(this);
        b3.addActionListener(this);
   }
    public void actionPerformed(ActionEvent ae{
         String str1 = ae.getActionCommand();
         String str2 = tf1.getText();
         String str3 = tf3.getText();
         String str4 = tf4.getText();
         String str5 = tf5.getText();
         String str8 = tf6.getText();
        if(str1.equals("CLEAR")) {
            tf1.setText("");
            tf3.setText("");
            tf4.setText("");
            tf5.setText("");
            tf6.setText("");
        }
         try {
             Class.forName(driver);
             Connection con = DriverManager.getConnection(url,uname,pass);
             Statement sta = con.createStatement();
             ResultSet rs = sta.executeQuery("Select * from student");
             if(str1.equals("SEARCH")){
                 while(rs.next()){
                     if(str8.equals(rs.getString(2))){
                         tf1.setText(rs.getString(1));
                         tf3.setText(rs.getString(3));
                         tf4.setText(rs.getString(4));
                         tf5.setText(rs.getString(5));
                     }
                     
         }
                 con.close();
             }
         }
         catch(Exception e){
             JOptionPane.showMessageDialog(this, e);
             }
    }
         
}


