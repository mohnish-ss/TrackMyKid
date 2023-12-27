package ICS3URFinalProject;

import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SignInScreenGUI extends JFrame implements ActionListener {
    private JButton signInButton;
    private JButton signUpButton;
    private JLabel userLabel;
    private JLabel passLabel;
    private static JTextField userInput;
    private static JPasswordField passInput;
    private JLabel textLabel;
    private JLabel userVerifyLabel;
    private JLabel passVerifyLabel;
    private JLabel appTitle;
    private JButton forgotPass;

    public SignInScreenGUI() {
        this.setBounds(380, 230, 740, 257);
        this.setLayout((LayoutManager) null);
        Font f = new Font("Muli", 0, 13);
        Color fontColor = new Color(242, 242, 242);
        Color buttonColor = new Color(54, 53, 53);
        this.forgotPass = new JButton("Forgot Password?");
        this.signInButton = new JButton("Sign In");
        this.signUpButton = new JButton("sign up!");
        this.userLabel = new JLabel("Username");
        this.passLabel = new JLabel("Password");
        userInput = new JTextField();
        passInput = new JPasswordField();
        this.textLabel = new JLabel("Don't have an account?");
        this.userVerifyLabel = new JLabel();
        this.passVerifyLabel = new JLabel();
        this.appTitle = new JLabel("Child Coordinator");
        this.forgotPass.setBounds(243, 175, 215, 25);
        this.signInButton.setBounds(243, 145, 215, 25);
        this.signUpButton.setBounds(390, 115, 85, 25);
        this.userLabel.setBounds(245, 55, 100, 25);
        this.passLabel.setBounds(245, 85, 100, 25);
        userInput.setBounds(315, 55, 145, 25);
        passInput.setBounds(315, 85, 145, 25);
        this.textLabel.setBounds(245, 115, 160, 25);
        this.userVerifyLabel.setBounds(465, 55, 150, 25);
        this.passVerifyLabel.setBounds(465, 85, 150, 25);
        this.appTitle.setBounds(0, 18, 715, 25);
        this.appTitle.setHorizontalAlignment(0);
        this.forgotPass.addActionListener(this);
        this.signInButton.addActionListener(this);
        this.signUpButton.addActionListener(this);
        this.forgotPass.setFont(f);
        this.signInButton.setFont(f);
        this.signUpButton.setFont(f);
        this.userLabel.setFont(f);
        this.passLabel.setFont(f);
        userInput.setFont(f);
        passInput.setFont(f);
        this.textLabel.setFont(f);
        this.userVerifyLabel.setFont(f);
        this.passVerifyLabel.setFont(f);
        this.appTitle.setFont(new Font("Muli", 0, 16));
        this.forgotPass.setBorderPainted(false);
        this.forgotPass.setOpaque(true);
        this.forgotPass.setBackground(buttonColor);
        this.forgotPass.setForeground(fontColor);
        this.signInButton.setBorderPainted(false);
        this.signInButton.setOpaque(true);
        this.signInButton.setBackground(buttonColor);
        this.signInButton.setForeground(fontColor);
        this.signUpButton.setForeground(new Color(51, 102, 204));
        this.signUpButton.setBackground(new Color(51, 62, 88));
        this.signUpButton.setBorderPainted(false);
        this.userLabel.setForeground(fontColor);
        this.passLabel.setForeground(fontColor);
        this.textLabel.setForeground(fontColor);
        this.appTitle.setForeground(fontColor);
        this.getContentPane().setBackground(new Color(51, 62, 88));
        this.add(this.forgotPass);
        this.add(this.signInButton);
        this.add(this.signUpButton);
        this.add(this.userLabel);
        this.add(this.passLabel);
        this.add(userInput);
        this.add(passInput);
        this.add(this.textLabel);
        this.add(this.userVerifyLabel);
        this.add(this.passVerifyLabel);
        this.add(this.appTitle);
        this.setVisible(true);
        this.setDefaultCloseOperation(3);
    }

    public static String getUsername() {
        return userInput.getText();
    }

    public static String getPassword() {
        return passInput.getText();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.forgotPass) {
            new ForgotPasswordGUI();
            this.setVisible(false);
        }

        if (e.getSource() == this.signUpButton) {
            new SignUpScreenGUI();
            this.setVisible(false);
        }

        if (e.getSource() == this.signInButton) {
            try {
                FileReader fr = new FileReader(userInput.getText() + ".txt");
                BufferedReader br = new BufferedReader(fr);
                String password = br.readLine().substring(6);
                this.userVerifyLabel.setText("");
                if (password.equals(passInput.getText())) {
                    new HomeScreenGUI();
                    this.setVisible(false);
                } else {
                    this.passVerifyLabel.setForeground(Color.red);
                    this.passVerifyLabel.setText("Invalid Credentials");
                }
            } catch (IOException var6) {
                this.passVerifyLabel.setText("");
                this.userVerifyLabel.setForeground(Color.red);
                this.userVerifyLabel.setText("Username not found");
            }
        }

    }

    public static void main(String[] args) {
        new SignInScreenGUI();
    }
}
