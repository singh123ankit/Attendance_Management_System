package attendance;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Homepage extends JFrame implements ActionListener {
    JMenuBar mb;
    JMenuItem save,update,delete,view,take,calc;
  public Homepage(){
    Image img = Toolkit.getDefaultToolkit().getImage("C:\\Users\\singh\\Downloads\attendance.png");
    ImageIcon img2 = new ImageIcon("C:\\Users\\singh\\Downloads\\attendance2.png");
    this.setIconImage(img);
    Color c = new Color(0,153,153);
    Container c1 = this.getContentPane();
    c1.setBackground(c);
    setLayout(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    mb = new JMenuBar();
    JMenu menu = new JMenu("Menu");
    menu.setFont(new Font("Helvetica",Font.PLAIN,31));
    JMenu student = new JMenu("Student");
    student.setFont(new Font("Helvetica",Font.PLAIN,31));
    JMenu attendance = new JMenu("Attendance");
    attendance.setFont(new Font("Helvetica",Font.PLAIN,31));
    save = new JMenuItem("Save");
    save.setFont(new Font("Helvetica",Font.PLAIN,27));
    update = new JMenuItem("Update");
    update.setFont(new Font("Helvetica",Font.PLAIN,27));
    delete = new JMenuItem("Delete");
    delete.setFont(new Font("Helvetica",Font.PLAIN,27));
    view = new JMenuItem("View");
    view.setFont(new Font("Helvetica",Font.PLAIN,27));
    take = new JMenuItem("Take Attendance");
    take.setFont(new Font("Helvetica",Font.PLAIN,27));
    calc = new JMenuItem("Calculate");
    calc.setFont(new Font("Helvetica",Font.PLAIN,27));
    mb.setVisible(true);
    setJMenuBar(mb);
    mb.add(menu);
    mb.add(student);
    mb.add(attendance);
    menu.add(save);
    menu.add(update);
    menu.add(delete);
    student.add(view);
    attendance.add(take);
    attendance.add(calc);
    JLabel lb1 = new JLabel();
    lb1.setVisible(true);
    lb1.setIcon(img2);
    lb1.setBounds(590,330,600,500);
    this.add(lb1);
    save.addActionListener(this);
    update.addActionListener(this);
    delete.addActionListener(this);
    view.addActionListener(this);
    take.addActionListener(this);
    calc.addActionListener(this);
  }
  public void actionPerformed(ActionEvent ae){
      if(save.isArmed()){
          Addstudent as = new Addstudent();
          as.setSize(1400,900);
          as.setLocationRelativeTo(null);
          as.setTitle("Attendance Management System");
          as.setResizable(false);
          as.setVisible(true);
          as.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      
}
     if(update.isArmed()){
          Updatestudent us = new Updatestudent();
          us.setSize(1400,1000);
          us.setLocationRelativeTo(null);
          us.setTitle("Attendance Management System");
          us.setResizable(false);
          us.setVisible(true);
          us.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
  }
     if(delete.isArmed()){
          Deletestudent ds = new Deletestudent();
          ds.setSize(1400,1000);
          ds.setLocationRelativeTo(null);
          ds.setTitle("Attendance Management System");
          ds.setResizable(false);
          ds.setVisible(true);
          ds.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
  }
      if(view.isArmed()){
          Viewstudent vs = new Viewstudent();
          vs.setSize(1400,900);
          vs.setLocationRelativeTo(null);
          vs.setTitle("Attendance Management System");
          vs.setResizable(false);
          vs.setVisible(true);
          vs.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      }
       if(take.isArmed()){
          Takeattendance ta = new Takeattendance();
          ta.setSize(1400,1000);
          ta.setLocationRelativeTo(null);
          ta.setTitle("Attendance Management System");
          ta.setResizable(false);
          ta.setVisible(true);
          ta.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      }
       if(calc.isArmed()){
          Calculate ca = new Calculate();
          ca.setSize(1400,1000);
          ca.setLocationRelativeTo(null);
          ca.setTitle("Attendance Management System");
          ca.setResizable(false);
          ca.setVisible(true);
          ca.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      }
 
}
}
 