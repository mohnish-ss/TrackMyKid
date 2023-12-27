package ICS3URFinalProject;
import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class ChildTimerScreenGUI extends JFrame implements ActionListener {
   private int minutes = SetHomeworkScreenGUI.getHomeworkTime();
   private JLabel childNameLabel;
   private JLabel timerTextField;

   public ChildTimerScreenGUI() {
      this.setBounds(0, 0, 400, 100);
      this.setLayout((LayoutManager)null);
      Font f = new Font("Muli", 0, 13);
      Color fontColor = new Color(242, 242, 242);
      String var10003 = SetHomeworkScreenGUI.getChildName().strip();
      this.childNameLabel = new JLabel(var10003 + "'s timer for " + SetHomeworkScreenGUI.getSubject() + " homework");
      this.timerTextField = new JLabel();
      this.childNameLabel.setHorizontalAlignment(0);
      this.timerTextField.setHorizontalAlignment(0);
      this.childNameLabel.setBounds(0, 10, 400, 25);
      this.timerTextField.setBounds(0, 35, 400, 25);
      this.timerTextField.setText(this.minutes + " minutes remaining");
      Timer t = new Timer(60000, this);
      t.start();
      this.childNameLabel.setFont(f);
      this.timerTextField.setFont(f);
      this.childNameLabel.setForeground(fontColor);
      this.timerTextField.setForeground(fontColor);
      this.getContentPane().setBackground(new Color(51, 62, 88));
      this.add(this.childNameLabel);
      this.add(this.timerTextField);
      this.setVisible(true);
   }

   public void actionPerformed(ActionEvent e) {
      --this.minutes;
      if (this.minutes > 0) {
         this.timerTextField.setText(this.minutes + " minutes remaining");
      } else {
         this.setVisible(false);
      }

   }
}
