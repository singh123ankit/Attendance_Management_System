package attendance;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.table.*;
public class Takeattendance extends JFrame implements ActionListener,ItemListener {
     JComboBox box1,box2,box3;
     JTextField tf1 = new JTextField();
     JTextField tf2 = new JTextField();
     JButton but = new JButton("SAVE");
     JTable tab;
     final String driver = "com.mysql.cj.jdbc.Driver";
     final String url = "jdbc:mysql://localhost:3306/attendance";
     final String uname = "root";
     final String pass = "poonam1612";
     public Takeattendance() {
        Image img1 = Toolkit.getDefaultToolkit().getImage("C:\\Users\\singh\\Downloads\attendance.png");
        this.setIconImage(img1);
        Color c = new Color(0,153,153);
        Container c1 = this.getContentPane();
        this.setLayout(null);
        c1.setBackground(c);
        JLabel lb1 = new JLabel("Take Attendance");
        lb1.setBounds(530,6,400,90);
        lb1.setForeground(Color.white);
        lb1.setFont(new Font("Times New Roman",Font.PLAIN,51));
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(10,80,1373,190);
        p1.setBackground(new Color(153,51,102));
        p1.setVisible(true);
        p2.setLayout(null);
        p2.setBounds(10,280,1373,610);
        p2.setBackground(new Color(153,51,102));
        p2.setVisible(true);
        JLabel lb2 = new JLabel("DAY");
        lb2.setBounds(10,10,400,70);
        lb2.setForeground(Color.white);
        lb2.setFont(new Font("Helvetica",Font.PLAIN,41));
        JLabel lb3 = new JLabel("MONTH");
        lb3.setBounds(500,10,400,70);
        lb3.setForeground(Color.white);
        lb3.setFont(new Font("Helvetica",Font.PLAIN,41));
        JLabel lb4 = new JLabel("YEAR");
        lb4.setBounds(1110,10,400,70);
        lb4.setForeground(Color.white);
        lb4.setFont(new Font("Helvetica",Font.PLAIN,41));
        JLabel lb5 = new JLabel("DATE");
        lb5.setBounds(10,100,400,70);
        lb5.setForeground(Color.white);
        lb5.setFont(new Font("Helvetica",Font.PLAIN,41));
        JLabel lb6 = new JLabel("STREAM");
        lb6.setBounds(860,100,400,70);
        lb6.setForeground(Color.white);
        lb6.setFont(new Font("Helvetica",Font.PLAIN,41));
        JLabel lb7 = new JLabel("ROLL NUMBER");
        lb7.setBounds(10,1,350,80);
        lb7.setForeground(Color.white);
        lb7.setFont(new Font("Arial",Font.BOLD,38));
        JLabel lb8 = new JLabel("NAME");
        lb8.setBounds(500,1,350,80);
        lb8.setForeground(Color.white);
        lb8.setFont(new Font("Arial",Font.BOLD,38));
        JLabel lb9 = new JLabel("PRESENT/ABSENT");
        lb9.setBounds(990,1,400,80);
        lb9.setForeground(Color.white);
        lb9.setFont(new Font("Arial",Font.BOLD,38));
        String day[] = {"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        box1 = new JComboBox(day);
        box1.setBounds(100,20,90,50);
        String month[] = {"01","02","03","04","05","06","07","08","09","10","11","12"};
        box2 = new JComboBox(month);
        box2.setBounds(660,20,90,50);
        String year[] = {"2020","2021","2022","2023","2024","2025","2026","2027","2028","2029","2030"};
        box3 = new JComboBox(year);
        box3.setBounds(1230,20,90,50);
        tf1.setBounds(140,110,280,50);
        tf1.setFont(new Font("Tahoma",Font.PLAIN,34));
        tf2.setBounds(1050,110,280,50);
        tf2.setFont(new Font("Tahoma",Font.PLAIN,34));
        DefaultTableModel model = new DefaultTableModel(){
        public Class getColumnClass(int column)
        {
        switch(column)
        {
        case 0:
          return String.class;
        case 1:
          return String.class;
        case 2:
          return Boolean.class;
        default:
          return String.class;
        }
        }
        };
        model.addColumn("Roll Number");
        model.addColumn("Name");
        model.addColumn("Present/Absent");
         try{
             Class.forName(driver);
             Connection con = DriverManager.getConnection(url,uname,pass);
             Statement sta = con.createStatement();
             ResultSet rs = sta.executeQuery("Select roll_number,name from student");
                 while(rs.next()){
                   model.addRow(new Object[]{rs.getString(2),rs.getString(1),false});
         }
                 con.close();
         }
         catch(Exception e){
             JOptionPane.showMessageDialog(this, e);
             }
        tab = new JTable(model);
        JScrollPane pg = new JScrollPane(tab);
        tab.setBorder(BorderFactory.createLineBorder(Color.green,2));
        tab.setFont(new Font("Arial",Font.BOLD,20));
        tab.setGridColor(Color.red);
        tab.setRowHeight(30);
        tab.setBounds(10,55,1350,540);
        but.setBounds(610,900,250,58);
        but.setBackground(new Color(0,51,102));
        but.setForeground(Color.white);
        but.setFont(new Font("Tahoma",Font.PLAIN,37));
        this.add(lb1);
        this.add(p1);
        this.add(p2);
        p1.add(lb2);
        p1.add(box1);
        p1.add(lb3);
        p1.add(box2);
        p1.add(lb4);
        p1.add(box3);
        p1.add(lb5);
        p1.add(tf1);
        p1.add(lb6);
        p1.add(tf2);
        p2.add(tab);
        p2.add(pg);
        p2.add(lb7);
        p2.add(lb8);
        p2.add(lb9);
        c1.add(but);
        box1.addItemListener(this);
        box2.addItemListener(this);
        box3.addItemListener(this);
        but.addActionListener(this);
       }
     public void itemStateChanged(ItemEvent ie){
         String str1 =(String) box1.getSelectedItem();
         String str2 =(String) box2.getSelectedItem();
         String str3 =(String) box3.getSelectedItem();
         tf1.setText(str3+"-"+str2+"-"+str1); 
     }
     public void actionPerformed(ActionEvent ae){
         String str1 = ae.getActionCommand();
         int rows = tab.getRowCount();
         String str2 = "insert into t_attendance values(?,?,?,?,?)"; 
         try{
         Class.forName(driver);
         Connection con = DriverManager.getConnection(url,uname,pass);
         PreparedStatement rms = con.prepareStatement(str2);
         if(str1.equals("SAVE")){
             int a = JOptionPane.showConfirmDialog(this,"Do You Want to Save","Close Window",JOptionPane.YES_NO_OPTION);
             if(a==JOptionPane.YES_OPTION){
             for(int i=0;i<rows;i++){
                 String str3 = (String)tab.getValueAt(i,0);
                 String str4 = (String)tab.getValueAt(i,1);
                 String str5 = tf2.getText();
                 String str6 = tf1.getText();
                 boolean str7 = (boolean)tab.getValueAt(i,2);
                 rms.setString(1,str3);
                 rms.setString(2,str4);
                 rms.setString(3,str5);
                 rms.setString(4,str6);
                 rms.setBoolean(5,str7);
                 rms.executeUpdate();
             }
             JOptionPane.showMessageDialog(this,"Insertion Successfull");
             con.close();
             }
     }
         }
catch(Exception e){
    JOptionPane.showMessageDialog(this,ae);
}
     }
}
