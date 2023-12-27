package ICS3URFinalProject;

import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SignUpScreenGUI extends JFrame implements ActionListener {
    private JButton CreateAccountButton;
    private JTextField usernameInput;
    private JPasswordField passwordInput;
    private JPasswordField passwordVerifyInput;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JLabel verifyPassLabel;
    private JLabel usernameCheck;
    private JLabel passwordCheck;
    private JLabel passwordVerifyCheck;
    private JLabel emailLabel;
    private JTextField emailInput;
    private boolean passBool;
    private boolean userBool;
    private JButton backButton;

    public SignUpScreenGUI() {
        this.setBounds(380, 230, 755, 250);
        this.setLayout((LayoutManager) null);
        Font f = new Font("Muli", 0, 13);
        Color fontColor = new Color(242, 242, 242);
        Color buttonColor = new Color(54, 53, 53);
        this.emailInput = new JTextField();
        this.emailLabel = new JLabel("E-mail");
        this.CreateAccountButton = new JButton("Create Account");
        this.usernameInput = new JTextField();
        this.passwordInput = new JPasswordField();
        this.passwordVerifyInput = new JPasswordField();
        this.usernameLabel = new JLabel("Username");
        this.passwordLabel = new JLabel("Password");
        this.verifyPassLabel = new JLabel("Verify Password");
        this.usernameCheck = new JLabel();
        this.passwordCheck = new JLabel();
        this.passwordVerifyCheck = new JLabel();
        this.backButton = new JButton("Back");
        this.emailLabel.setBounds(265, 40, 80, 25);
        this.emailInput.setBounds(320, 40, 160, 25);
        this.CreateAccountButton.setBounds(250, 175, 230, 25);
        this.usernameInput.setBounds(320, 70, 160, 25);
        this.passwordInput.setBounds(320, 100, 160, 25);
        this.passwordVerifyInput.setBounds(320, 130, 160, 25);
        this.usernameLabel.setBounds(245, 70, 80, 25);
        this.passwordLabel.setBounds(245, 100, 80, 25);
        this.verifyPassLabel.setBounds(210, 130, 140, 25);
        this.usernameCheck.setBounds(490, 70, 120, 25);
        this.passwordCheck.setBounds(490, 100, 200, 25);
        this.passwordVerifyCheck.setBounds(490, 130, 400, 25);
        this.backButton.setBounds(625, 10, 100, 25);
        this.CreateAccountButton.addActionListener(this);
        this.backButton.addActionListener(this);
        this.passwordVerifyCheck.setFont(f);
        this.passwordVerifyInput.setFont(f);
        this.verifyPassLabel.setFont(f);
        this.usernameCheck.setFont(f);
        this.passwordCheck.setFont(f);
        this.usernameInput.setFont(f);
        this.passwordInput.setFont(f);
        this.usernameLabel.setFont(f);
        this.passwordLabel.setFont(f);
        this.CreateAccountButton.setFont(f);
        this.emailLabel.setFont(f);
        this.emailInput.setFont(f);
        this.backButton.setFont(f);
        this.verifyPassLabel.setForeground(fontColor);
        this.usernameLabel.setForeground(fontColor);
        this.passwordLabel.setForeground(fontColor);
        this.CreateAccountButton.setForeground(fontColor);
        this.emailLabel.setForeground(fontColor);
        this.backButton.setForeground(fontColor);
        this.CreateAccountButton.setBorderPainted(false);
        this.CreateAccountButton.setOpaque(true);
        this.CreateAccountButton.setBackground(buttonColor);
        this.backButton.setBorderPainted(false);
        this.backButton.setOpaque(true);
        this.backButton.setBackground(buttonColor);
        this.getContentPane().setBackground(new Color(51, 62, 88));
        this.add(this.passwordVerifyCheck);
        this.add(this.passwordVerifyInput);
        this.add(this.verifyPassLabel);
        this.add(this.usernameCheck);
        this.add(this.passwordCheck);
        this.add(this.usernameInput);
        this.add(this.passwordInput);
        this.add(this.usernameLabel);
        this.add(this.passwordLabel);
        this.add(this.CreateAccountButton);
        this.add(this.emailLabel);
        this.add(this.emailInput);
        this.add(this.backButton);
        this.setVisible(true);
        this.setDefaultCloseOperation(3);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.backButton) {
            new SignInScreenGUI();
            this.setVisible(false);
        }

        if (e.getSource() == this.CreateAccountButton) {
            this.passwordCheck.setText("");
            this.usernameCheck(this.usernameInput.getText());
            this.passwordCheck(this.passwordInput.getText(), this.passwordVerifyInput.getText());
        }

        if (e.getSource() == this.CreateAccountButton && this.passBool && this.userBool) {
            try {
                FileWriter fw = new FileWriter(this.usernameInput.getText() + ".txt");
                PrintWriter pw = new PrintWriter(fw);
                pw.println("Pass: " + this.passwordInput.getText());
                pw.print("Email: " + this.emailInput.getText());
                pw.close();
            } catch (IOException var4) {
                System.out.println(var4);
            }

            new SignInScreenGUI();
            this.setVisible(false);
        }

    }

    public void usernameCheck(String userName) {
        if (userName.length() >= 6 && !userName.contains(" ")) {
            this.usernameCheck.setForeground(Color.green);
            this.usernameCheck.setText("Username valid");
            this.userBool = true;
        } else {
            this.usernameCheck.setForeground(Color.red);
            this.usernameCheck.setText("Username invalid");
            this.userBool = false;
        }

    }

    public void passwordCheck(String password, String verifyPassword) {
        boolean isValid = isPasswordValid(password) && password.equals(verifyPassword);

        if (isValid) {
            setPasswordCheckLabels(Color.green, "Password is valid", Color.green, "Passwords match");
            passBool = true;
        } else {
            if (!isPasswordValid(password)) {
                setPasswordCheckLabels(Color.red, "Password invalid", null, null);
            } else {
                setPasswordCheckLabels(Color.green, "Password is valid", Color.red, "Passwords do not match");
            }
            passBool = false;
        }
    }

    private void setPasswordCheckLabels(Color passwordColor, String passwordText, Color verifyColor,
            String verifyText) {
        passwordCheck.setForeground(passwordColor);
        passwordCheck.setText(passwordText);

        if (verifyColor != null && verifyText != null) {
            passwordVerifyCheck.setForeground(verifyColor);
            passwordVerifyCheck.setText(verifyText);
        }
    }

    private boolean isPasswordValid(String password) {
        return password.length() >= 8 && containsUpperCase(password) && containsLowerCase(password)
                && containsDigit(password);
    }

    private boolean containsUpperCase(String str) {
        for (char c : str.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }

    private boolean containsLowerCase(String str) {
        for (char c : str.toCharArray()) {
            if (Character.isLowerCase(c)) {
                return true;
            }
        }
        return false;
    }

    private boolean containsDigit(String str) {
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }
}
