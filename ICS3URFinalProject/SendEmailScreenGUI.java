package ICS3URFinalProject;
import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.mail.MessagingException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class SendEmailScreenGUI extends JFrame implements ActionListener {
   private JLabel editEmailLabel;
   private static JLabel emailStatusLabel;
   private JTextArea emailTextBox;
   private JButton sendButton;
   private JButton backButton;
   private String reason;
   private static String emailText;

   public SendEmailScreenGUI() throws IOException {
      this.setBounds(380, 230, 755, 280);
      this.setLayout((LayoutManager)null);
      Font f = new Font("Muli", 0, 13);
      Color fontColor = new Color(242, 242, 242);
      Color buttonColor = new Color(54, 53, 53);
      this.editEmailLabel = new JLabel("Edit E-mail");
      this.emailTextBox = new JTextArea(5, 5);
      this.sendButton = new JButton("Send");
      this.backButton = new JButton("Home Page");
      emailStatusLabel = new JLabel("Waiting");
      this.reason = HomeScreenGUI.getReason();
      if (this.reason.equals("Sick")) {
         this.reason = " are sick.";
      }

      if (this.reason.equals("Doctor")) {
         this.reason = " have a doctor's appointment.";
      }

      if (this.reason.equals("Sport")) {
         this.reason = " have a sports event.";
      }

      this.emailTextBox.setLineWrap(true);
      this.emailTextBox.setWrapStyleWord(true);
      JTextArea var10000 = this.emailTextBox;
      String var10001 = HomeScreenGUI.getChildName();
      var10000.setText("Dear Sir/Madam,\n\nMy child " + var10001 + " in grade " + HomeScreenGUI.getGrade() + " from " + HomeScreenGUI.getTeacher() + "'s class, will not be able to attend school today because they" + this.reason + "\n\nRegards,\n\n" + SignInScreenGUI.getUsername());
      this.editEmailLabel.setBounds(330, 15, 80, 25);
      this.emailTextBox.setBounds(60, 50, 600, 140);
      this.sendButton.setBounds(280, 210, 80, 25);
      emailStatusLabel.setBounds(380, 210, 100, 25);
      this.backButton.setBounds(605, 10, 115, 25);
      this.sendButton.addActionListener(this);
      this.backButton.addActionListener(this);
      this.editEmailLabel.setFont(f);
      emailStatusLabel.setFont(f);
      this.emailTextBox.setFont(f);
      this.sendButton.setFont(f);
      this.backButton.setFont(f);
      this.editEmailLabel.setForeground(fontColor);
      emailStatusLabel.setForeground(fontColor);
      this.emailTextBox.setForeground(fontColor);
      this.emailTextBox.setBackground(buttonColor);
      this.sendButton.setForeground(fontColor);
      this.sendButton.setBorderPainted(false);
      this.sendButton.setOpaque(true);
      this.sendButton.setBackground(buttonColor);
      this.backButton.setForeground(fontColor);
      this.backButton.setBorderPainted(false);
      this.backButton.setOpaque(true);
      this.backButton.setBackground(buttonColor);
      this.getContentPane().setBackground(new Color(51, 62, 88));
      this.add(this.editEmailLabel);
      this.add(emailStatusLabel);
      this.add(this.emailTextBox);
      this.add(this.sendButton);
      this.add(this.backButton);
      this.setVisible(true);
      this.setDefaultCloseOperation(3);
   }

   public static String getEmailText() {
      return emailText;
   }

   public static void setEmailStatus(String status) {
      emailStatusLabel.setText(status);
   }

   public void actionPerformed(ActionEvent e) {
      if (e.getSource() == this.backButton) {
         new HomeScreenGUI();
         this.setVisible(false);
      }

      if (e.getSource() == this.sendButton) {
         emailText = this.emailTextBox.getText();

         try {
            MailSenderClass.sendMail(HomeScreenGUI.getAttendanceEmail());
         } catch (IOException var3) {
            System.out.println(var3);
         } catch (MessagingException var4) {
            System.out.println(var4);
         }
      }

   }
}
