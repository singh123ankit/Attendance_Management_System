package attendance;
import java.awt.*;
import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;
public class Welcome extends JFrame{
  public Welcome(){
    Image img = Toolkit.getDefaultToolkit().getImage("C:\\Users\\singh\\Downloads\attendance.png");
    this.setIconImage(img);
    Color c = new Color(0,153,153);
    Container c1 = this.getContentPane();
    c1.setBackground(c);
    setLayout(null);
    JLabel lb1 = new JLabel("Welcome");
    JLabel lb2 = new JLabel("Attendance Management System");
    lb1.setBounds(525,330,350,190);
    lb1.setForeground(Color.white);
    lb1.setFont(new Font("Garamond",Font.BOLD,71));
    lb2.setBounds(120,100,1150,250);
    lb2.setForeground(Color.white);
    lb2.setFont(new Font("Times New Roman",Font.BOLD,81));
    this.add(lb1);
    this.add(lb2);
    Timer time = new Timer();
    time.schedule(new TimerTask(){
        public void run(){
            dispose();
            Login lg = new Login();
            lg.setVisible(true);
            lg.setSize(1400,900);
            lg.setLocationRelativeTo(null);
            lg.setTitle("Attendance Management System");
            lg.setResizable(false);
            lg.setVisible(true);
            lg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    },1000);
  }
  public static void main(String args[]){
      Welcome w = new Welcome();
      w.setSize(1400,900);
      w.setLocationRelativeTo(null);
      w.setTitle("Attendance Management System");
      w.setResizable(false);
      w.setVisible(true);
      w.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  }
}