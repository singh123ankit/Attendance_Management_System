package attendance;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JOptionPane;
import java.sql.*;
public class Addstudent extends JFrame implements ActionListener{
     JTextField tf1 = new JTextField();
     JTextField tf2 = new JTextField();
     JTextField tf3 = new JTextField();
     JTextField tf4 = new JTextField();
     JTextField tf5 = new JTextField();
     final String driver = "com.mysql.cj.jdbc.Driver";
     final String url = "jdbc:mysql://localhost:3306/attendance";
     final String uname = "root";
     final String pass = "poonam1612";
    public Addstudent() {
        Image img1 = Toolkit.getDefaultToolkit().getImage("C:\\Users\\singh\\Downloads\attendance.png");
        this.setIconImage(img1);
        Color c = new Color(0,153,153);
        Container c1 = this.getContentPane();
        this.setLayout(null);
        c1.setBackground(c);
        JLabel lb1 = new JLabel("Student Details");
        lb1.setBounds(530,50,400,90);
        lb1.setForeground(Color.white);
        lb1.setFont(new Font("Times New Roman",Font.PLAIN,51));
        JLabel lb2 = new JLabel("Name");
        JLabel lb3 = new JLabel("Roll Number");
        JLabel lb4 = new JLabel("Stream");
        JLabel lb5 = new JLabel("Session");
        JLabel lb6 = new JLabel("Mobile Number");
        lb2.setFont(new Font("Helvetica",Font.PLAIN,41));
        lb3.setFont(new Font("Helvetica",Font.PLAIN,41));
        lb4.setFont(new Font("Helvetica",Font.PLAIN,41));
        lb5.setFont(new Font("Helvetica",Font.PLAIN,41));
        lb6.setFont(new Font("Helvetica",Font.PLAIN,41));
        lb2.setBounds(140,150,400,90);
        lb3.setBounds(140,260,400,90);
        lb4.setBounds(140,370,400,90);
        lb5.setBounds(140,480,400,90);
        lb6.setBounds(140,590,400,90);
        lb2.setForeground(Color.white);
        lb3.setForeground(Color.white);
        lb4.setForeground(Color.white);
        lb5.setForeground(Color.white);
        lb6.setForeground(Color.white);
        tf1.setBounds(500,180,410,40);
        tf2.setBounds(500,290,410,40);
        tf3.setBounds(500,400,410,40);
        tf4.setBounds(500,510,410,40);
        tf5.setBounds(500,620,410,40);
        tf1.setFont(new Font("Tahoma",Font.PLAIN,30));
        tf2.setFont(new Font("Tahoma",Font.PLAIN,30));
        tf3.setFont(new Font("Tahoma",Font.PLAIN,30));
        tf4.setFont(new Font("Tahoma",Font.PLAIN,30));
        tf5.setFont(new Font("Tahoma",Font.PLAIN,30));
        JButton b1 = new JButton("SAVE");
        JButton b2 = new JButton("CLEAR");
        b1.setBounds(450,730,250,70);
        b1.setBackground(new Color(0,51,102));
        b1.setForeground(Color.white);
        b1.setFont(new Font("Tahoma",Font.PLAIN,41));
        b2.setBounds(750,730,250,70);
        b2.setBackground(new Color(0,51,102));
        b2.setForeground(Color.white);
        b2.setFont(new Font("Tahoma",Font.PLAIN,41));
        this.add(lb1);
        this.add(lb2);
        this.add(lb3);
        this.add(lb4);
        this.add(lb5);
        this.add(lb6);
        this.add(tf1);
        this.add(tf2);
        this.add(tf3);
        this.add(tf4);
        this.add(tf5);
        this.add(b1);
        this.add(b2);
        b1.addActionListener(this);
        b2.addActionListener(this);
   }
    public void actionPerformed(ActionEvent ae{
         String str1 = ae.getActionCommand();
         String str2 = tf1.getText();
         String str3 = tf2.getText();
         String str4 = tf3.getText();
         String str5 = tf4.getText();
         String str6 = tf5.getText();
         String str7 = "insert into student values (?,?,?,?,?)";
         try{
         Class.forName(driver);
         Connection con = DriverManager.getConnection(url,uname,pass);
         PreparedStatement rms = con.prepareStatement(str7);
         if(str1.equals("SAVE")){
             int a = JOptionPane.showConfirmDialog(this,"Do You Want to Save","Close Window",JOptionPane.YES_NO_OPTION);
             if(a==JOptionPane.YES_OPTION){
             rms.setString(1,str2);
             rms.setString(2,str3);
             rms.setString(3,str4);
             rms.setString(4,str5);
             rms.setString(5,str6);
             rms.executeUpdate();
             JOptionPane.showMessageDialog(this,"Insertion Successfull");
             con.close();
             }
         }
        if(str1.equals("CLEAR")) {
            tf1.setText("");
            tf2.setText("");
            tf3.setText("");
            tf4.setText("");
            tf5.setText("");
        }
    }
         catch(Exception e){
             JOptionPane.showMessageDialog(this,e);
         }
}
}

