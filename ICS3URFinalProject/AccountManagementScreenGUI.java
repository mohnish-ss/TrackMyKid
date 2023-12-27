package ICS3URFinalProject;

import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AccountManagementScreenGUI extends JFrame implements ActionListener {
    private JButton changePasswordButton;
    private JTextField passInput;
    private JTextField passVerifyInput;
    private JLabel changePassLabel;
    private JLabel verifyPassLabel;
    private JLabel verifyLabel1;
    private JLabel verifyLabel2;
    private JButton homePageButton;
    private boolean passBool = false;
    private boolean passVerifyBool = false;

    public AccountManagementScreenGUI() {
        this.setBounds(380, 230, 755, 250);
        this.setLayout((LayoutManager) null);
        Font f = new Font("Muli", 0, 13);
        Color fontColor = new Color(242, 242, 242);
        Color buttonColor = new Color(54, 53, 53);
        this.changePasswordButton = new JButton("Change Password");
        this.passInput = new JTextField();
        this.passVerifyInput = new JTextField();
        this.changePassLabel = new JLabel("Change Password");
        this.verifyPassLabel = new JLabel("Verify Password");
        this.verifyLabel1 = new JLabel();
        this.verifyLabel2 = new JLabel();
        this.homePageButton = new JButton("Home Page");
        this.changePasswordButton.setBounds(295, 135, 170, 25);
        this.passInput.setBounds(340, 70, 150, 25);
        this.passVerifyInput.setBounds(340, 100, 150, 25);
        this.changePassLabel.setBounds(223, 70, 110, 25);
        this.verifyPassLabel.setBounds(233, 100, 100, 25);
        this.verifyLabel1.setBounds(495, 70, 160, 25);
        this.verifyLabel2.setBounds(495, 100, 160, 25);
        this.homePageButton.setBounds(605, 10, 115, 25);
        this.changePasswordButton.setFont(f);
        this.passInput.setFont(f);
        this.passVerifyInput.setFont(f);
        this.changePassLabel.setFont(f);
        this.verifyPassLabel.setFont(f);
        this.verifyLabel1.setFont(f);
        this.verifyLabel2.setFont(f);
        this.homePageButton.setFont(f);
        this.homePageButton.setBorderPainted(false);
        this.homePageButton.setOpaque(true);
        this.homePageButton.setBackground(buttonColor);
        this.changePasswordButton.setForeground(fontColor);
        this.changePasswordButton.setBorderPainted(false);
        this.changePasswordButton.setOpaque(true);
        this.changePasswordButton.setBackground(buttonColor);
        this.changePassLabel.setForeground(fontColor);
        this.verifyPassLabel.setForeground(fontColor);
        this.verifyLabel1.setForeground(fontColor);
        this.verifyLabel2.setForeground(fontColor);
        this.homePageButton.setForeground(fontColor);
        this.getContentPane().setBackground(new Color(51, 62, 88));
        this.add(this.changePasswordButton);
        this.add(this.passInput);
        this.add(this.passVerifyInput);
        this.add(this.changePassLabel);
        this.add(this.verifyPassLabel);
        this.add(this.verifyLabel1);
        this.add(this.verifyLabel2);
        this.add(this.homePageButton);
        this.homePageButton.addActionListener(this);
        this.changePasswordButton.addActionListener(this);
        this.setVisible(true);
        this.setDefaultCloseOperation(3);
    }

    public void passwordCheck(String passWord, String verifyPass) {
        boolean cap = false;
        boolean low = false;
        boolean dig = false;

        for (int i = 0; i < passWord.length(); ++i) {
            if (Character.isDigit(passWord.charAt(i))) {
                dig = true;
            } else if (Character.isUpperCase(passWord.charAt(i))) {
                cap = true;
            } else if (Character.isLowerCase(passWord.charAt(i))) {
                low = true;
            }
        }

        if (passWord.length() >= 8 && cap && low && dig && passWord.equals(verifyPass)) {
            setVerificationLabels(Color.green, "Password is valid", Color.green, "Passwords match");
            passBool = true;
            passVerifyBool = true;
        } else if (passWord.length() >= 8 && cap && low && dig && !passWord.equals(verifyPass)) {
            setVerificationLabels(Color.green, "Password is valid", Color.red, "Passwords do not match");
            passBool = true;
            passVerifyBool = false;
        } else {
            setVerificationLabels(Color.red, "Password is invalid", null, null);
            passBool = false;
            passVerifyBool = false;
        }
    }

    private void setVerificationLabels(Color color1, String text1, Color color2, String text2) {
        verifyLabel1.setForeground(color1);
        verifyLabel1.setText(text1);

        if (color2 != null && text2 != null) {
            verifyLabel2.setForeground(color2);
            verifyLabel2.setText(text2);
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.homePageButton) {
            new HomeScreenGUI();
            this.setVisible(false);
        }

        if (e.getSource() == this.changePasswordButton) {
            this.passwordCheck(this.passInput.getText(), this.passVerifyInput.getText());
            if (this.passBool && this.passVerifyBool) {
                this.verifyLabel1.setForeground(Color.green);
                this.verifyLabel1.setText("Password is valid");
                this.verifyLabel2.setForeground(Color.green);
                this.verifyLabel2.setText("Passwords match");
            }

            if (!this.passBool && this.passVerifyBool) {
                this.verifyLabel1.setForeground(Color.green);
                this.verifyLabel1.setText("Password is valid");
                this.verifyLabel2.setForeground(Color.red);
                this.verifyLabel2.setText("Passwords do not match");
            }

            if (!this.passBool && !this.passVerifyBool) {
                this.verifyLabel1.setForeground(Color.red);
                this.verifyLabel1.setText("Password is invalid");
            }

            if (e.getSource() == this.changePasswordButton && this.passBool && this.passVerifyBool) {
                try {
                    int lines = this.lineCounter(SignInScreenGUI.getUsername() + ".txt");
                    String[] file = new String[lines];
                    FileReader fr = new FileReader(SignInScreenGUI.getUsername() + ".txt");
                    BufferedReader br = new BufferedReader(fr);
                    String temp = br.readLine();

                    for (int i = 0; i < lines; ++i) {
                        file[i] = temp;
                        temp = br.readLine();
                    }

                    file[0] = "Pass: " + this.passInput.getText();
                    FileWriter fw = new FileWriter(SignInScreenGUI.getUsername() + ".txt");
                    PrintWriter pw = new PrintWriter(fw);

                    for (int i = 0; i < lines; ++i) {
                        pw.println(file[i]);
                    }

                    pw.close();
                    br.close();
                } catch (IOException var10) {
                    System.out.println("Error" + String.valueOf(var10));
                }

                new SignInScreenGUI();
                this.setVisible(false);
            }
        }

    }

    public int lineCounter(String file) {
        int lines = 0;

        try {
            FileReader fr = new FileReader(SignInScreenGUI.getUsername() + ".txt");
            BufferedReader br = new BufferedReader(fr);

            for (String temp = br.readLine(); temp != null; temp = br.readLine()) {
                ++lines;
            }

            br.close();
        } catch (IOException var6) {
            System.out.println("Error" + String.valueOf(var6));
        }

        return lines;
    }
}
