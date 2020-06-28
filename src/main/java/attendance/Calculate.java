package attendance;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.table.*;
public class Calculate extends JFrame implements ActionListener {
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JTextField tf1 = new JTextField("yyyy-mm-dd");
        JTextField tf2 = new JTextField("yyyy-mm-dd");
        JTable tab;
        JButton b1,b2;
        DefaultTableModel model;
        final String driver = "com.mysql.cj.jdbc.Driver";
        final String url = "jdbc:mysql://localhost:3306/attendance";
        final String uname = "root";
        final String pass = "poonam1612";
        public Calculate(){
             Image img1 = Toolkit.getDefaultToolkit().getImage("C:\\Users\\singh\\Downloads\attendance.png");
             this.setIconImage(img1);
             Color c = new Color(0,153,153);
             Container c1 = this.getContentPane();
             this.setLayout(null);
             c1.setBackground(c);
             JLabel lb1 = new JLabel("Calculate Attendance %");
             lb1.setBounds(500,6,500,90);
             lb1.setForeground(Color.white);
             lb1.setFont(new Font("Times New Roman",Font.PLAIN,51));
             p1.setLayout(null);
             p1.setBounds(10,80,1373,190);
             p1.setBackground(new Color(153,51,102));
             p1.setVisible(true);
             p2.setLayout(null);
             p2.setBounds(10,280,1373,610);
             p2.setBackground(new Color(153,51,102));
             p2.setVisible(true);
             JLabel lb2 = new JLabel("START DATE");
             lb2.setBounds(10,10,400,70);
             lb2.setForeground(Color.white);
             lb2.setFont(new Font("Helvetica",Font.PLAIN,41));
             JLabel lb3 = new JLabel("END DATE");
             lb3.setBounds(860,10,400,70);
             lb3.setForeground(Color.white);
             lb3.setFont(new Font("Helvetica",Font.PLAIN,41));
             tf1.setBounds(290,20,240,45);
             tf1.setFont(new Font("Tahoma",Font.PLAIN,34));
             tf2.setBounds(1100,20,240,45);
             tf2.setFont(new Font("Tahoma",Font.PLAIN,34));
             b1 = new JButton("OK");
             b2 = new JButton("CLEAR");
             b1.setBounds(320,110,250,70);
             b1.setBackground(new Color(0,51,102));
             b1.setForeground(Color.white);
             b1.setFont(new Font("Tahoma",Font.PLAIN,41));
             b2.setBounds(810,110,250,70);
             b2.setBackground(new Color(0,51,102));
             b2.setForeground(Color.white);
             b2.setFont(new Font("Tahoma",Font.PLAIN,41));
            model = new DefaultTableModel(){
            public Class getColumnClass(int column)
            {
            switch(column)
            {
            case 0:
              return String.class;
            case 1:
              return String.class;
            case 2:
              return Integer.class;
            default:
              return String.class;
            }
            }
            };
            model.addColumn("Roll Number");
            model.addColumn("Name");
            model.addColumn("Attendance");
            tab = new JTable(model);
            JScrollPane pg = new JScrollPane(tab);
            tab.setBorder(BorderFactory.createLineBorder(Color.green,2));
            tab.setFont(new Font("Arial",Font.BOLD,20));
            tab.setGridColor(Color.red);
            tab.setRowHeight(30);
            tab.setBounds(10,55,1350,540);
            JLabel lb4 = new JLabel("NAME");
            lb4.setBounds(10,1,350,80);
            lb4.setForeground(Color.white);
            lb4.setFont(new Font("Arial",Font.BOLD,38));
            JLabel lb5 = new JLabel("ROLL NUMBER");
            lb5.setBounds(500,1,350,80);
            lb5.setForeground(Color.white);
            lb5.setFont(new Font("Arial",Font.BOLD,38));
            JLabel lb6 = new JLabel("ATTENDANCE %");
            lb6.setBounds(990,1,400,80);
            lb6.setForeground(Color.white);
            lb6.setFont(new Font("Arial",Font.BOLD,38));
             this.add(p1);
             this.add(p2);
             this.add(lb1);
             p1.add(lb2);
             p1.add(lb3);
             p1.add(tf1);
             p1.add(tf2);
             p1.add(b1);
             p1.add(b2);
             p2.add(tab);
             p2.add(lb4);
             p2.add(lb5);
             p2.add(lb6);
             b1.addActionListener(this);
             b2.addActionListener(this);
        }
            public void actionPerformed(ActionEvent ae){
             String str3 = ae.getActionCommand();
             if(str3.equals("OK")){
             try{
             String str1 = tf1.getText();
             String str2 = tf2.getText();
             Class.forName(driver);
             Connection con = DriverManager.getConnection(url,uname,pass);
             Statement sta1 = con.createStatement();
             Statement sta2 = con.createStatement();
             Statement sta3 = con.createStatement();
             ResultSet rs1 = sta1.executeQuery("Select roll_number,name from student");
             ResultSet rs2 = sta2.executeQuery("select count(distinct date) from t_attendance");
             ResultSet rs3 = sta3.executeQuery("select sum(status) from t_attendance group by roll_number");
             rs2.next();
             int count = Integer.parseInt(rs2.getString(1));
             System.out.println(count);
                 while(rs1.next()&&rs3.next()){
                   model.addRow(new Object[]{rs1.getString(2),rs1.getString(1),(rs3.getInt(1)/count)*100+"%"});
         }
                 rs1.close();
                 rs2.close();
                 rs3.close();
                 con.close();
         }
         catch(Exception e){
             JOptionPane.showMessageDialog(this, e);
             }
             }
            if(str3.equals("CLEAR")) {
            tf1.setText("");
            tf2.setText("");
        }
            }
            
       
}
