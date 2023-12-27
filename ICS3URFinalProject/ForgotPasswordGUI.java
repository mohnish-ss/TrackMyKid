package ICS3URFinalProject;
import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.mail.MessagingException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ForgotPasswordGUI extends JFrame implements ActionListener {
   private JButton SendEmailButton;
   private JTextField emailInput;
   private JTextField codeInput;
   private JLabel verifyCodeLabel;
   private JLabel emailLabel;
   private JButton backButton;
   private JButton submitCodeButton;
   private JLabel codeOutput;
   private static JLabel emailStatus;
   private JLabel username;
   private JTextField usernameInput;
   private static String user = "";

   public ForgotPasswordGUI() {
      this.setBounds(380, 230, 755, 210);
      this.setLayout((LayoutManager)null);
      Font f = new Font("Muli", 0, 13);
      Color fontColor = new Color(242, 242, 242);
      Color buttonColor = new Color(54, 53, 53);
      this.username = new JLabel("Username");
      this.usernameInput = new JTextField();
      this.codeOutput = new JLabel();
      emailStatus = new JLabel();
      this.emailLabel = new JLabel("E-mail");
      this.SendEmailButton = new JButton("Send Verification Code");
      this.emailInput = new JTextField();
      this.codeInput = new JTextField();
      this.verifyCodeLabel = new JLabel("Verification Code");
      this.backButton = new JButton("Back");
      this.submitCodeButton = new JButton("Submit Code");
      this.usernameInput.setBounds(295, 40, 180, 25);
      this.username.setBounds(220, 40, 110, 25);
      emailStatus.setBounds(680, 70, 100, 25);
      this.codeOutput.setBounds(295, 130, 180, 25);
      this.emailInput.setBounds(295, 70, 180, 25);
      this.codeInput.setBounds(295, 100, 180, 25);
      this.emailLabel.setBounds(240, 70, 110, 25);
      this.verifyCodeLabel.setBounds(178, 100, 150, 25);
      this.SendEmailButton.setBounds(485, 70, 180, 25);
      this.submitCodeButton.setBounds(485, 100, 180, 25);
      this.backButton.setBounds(605, 10, 115, 25);
      this.usernameInput.setFont(f);
      this.username.setFont(f);
      this.username.setForeground(fontColor);
      emailStatus.setFont(f);
      emailStatus.setForeground(fontColor);
      this.codeOutput.setFont(f);
      this.submitCodeButton.setFont(f);
      this.emailInput.setFont(f);
      this.codeInput.setFont(f);
      this.emailLabel.setFont(f);
      this.verifyCodeLabel.setFont(f);
      this.SendEmailButton.setFont(f);
      this.backButton.setFont(f);
      this.submitCodeButton.setOpaque(true);
      this.submitCodeButton.setBackground(buttonColor);
      this.submitCodeButton.setBorderPainted(false);
      this.submitCodeButton.setForeground(fontColor);
      this.backButton.setBorderPainted(false);
      this.backButton.setOpaque(true);
      this.backButton.setBackground(buttonColor);
      this.SendEmailButton.setForeground(fontColor);
      this.SendEmailButton.setBorderPainted(false);
      this.SendEmailButton.setOpaque(true);
      this.SendEmailButton.setBackground(buttonColor);
      this.codeOutput.setForeground(fontColor);
      this.emailLabel.setForeground(fontColor);
      this.verifyCodeLabel.setForeground(fontColor);
      this.backButton.setForeground(fontColor);
      this.getContentPane().setBackground(new Color(51, 62, 88));
      this.add(this.usernameInput);
      this.add(this.username);
      this.add(emailStatus);
      this.add(this.codeOutput);
      this.add(this.submitCodeButton);
      this.add(this.backButton);
      this.add(this.SendEmailButton);
      this.add(this.verifyCodeLabel);
      this.add(this.emailLabel);
      this.add(this.codeInput);
      this.add(this.emailInput);
      this.submitCodeButton.addActionListener(this);
      this.SendEmailButton.addActionListener(this);
      this.backButton.addActionListener(this);
      this.setVisible(true);
      this.setDefaultCloseOperation(3);
   }

   public static void setEmailStatus(String status) {
      emailStatus.setText(status);
   }

   public static String generateRandomCode() {
      Random rand = new Random();
      int number = rand.nextInt(1000000);
      char letter = (char)(rand.nextInt(27) + 64);
      String code = "" + number;
      return code + letter;
   }

   public void actionPerformed(ActionEvent e) {
      if (e.getSource() == this.SendEmailButton) {
         user = this.usernameInput.getText();

         try {
            ForgotPasswordMailSender.sendMail(this.emailInput.getText());
         } catch (MessagingException var3) {
            System.out.println(var3);
         }
      }

      if (e.getSource() == this.submitCodeButton) {
         if (this.codeInput.getText().equals("")) {
            this.codeOutput.setForeground(new Color(242, 242, 242));
            this.codeOutput.setText("Send a code to your E-mail");
         } else if (this.codeInput.getText().equals(ForgotPasswordMailSender.getCodeSent())) {
            ForgotPasswordMailSender.resetCode();
            new ChangePasswordGUI();
            this.setVisible(false);
         } else {
            this.codeOutput.setForeground(Color.RED);
            this.codeOutput.setText("Incorrect Code");
         }
      }

      if (e.getSource() == this.backButton) {
         new SignInScreenGUI();
         this.setVisible(false);
      }

   }

   public static String getUsername() {
      return user;
   }
}
