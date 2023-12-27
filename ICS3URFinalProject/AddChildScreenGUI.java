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

public class AddChildScreenGUI extends JFrame implements ActionListener {
    private JLabel nameLabel;
    private JLabel gradeLabel;
    private JLabel schoolLabel;
    private JLabel teacherLabel;
    private JLabel attendanceEmailLabel;
    private JTextField nameInput;
    private JTextField gradeInput;
    private JTextField schoolInput;
    private JTextField teacherInput;
    private JTextField attendanceInput;
    private JButton addChildButton;
    private JLabel addChildLabel;
    private JButton homePageButton;

    public AddChildScreenGUI() {
        this.setBounds(380, 230, 755, 295);
        this.setLayout((LayoutManager) null);
        Font f = new Font("Muli", 0, 13);
        Color fontColor = new Color(242, 242, 242);
        Color buttonColor = new Color(54, 53, 53);
        this.nameLabel = new JLabel("Name");
        this.gradeLabel = new JLabel("Grade");
        this.schoolLabel = new JLabel("School");
        this.teacherLabel = new JLabel("Homeroom Teacher");
        this.attendanceEmailLabel = new JLabel("Attendance E-mail");
        this.nameInput = new JTextField(5);
        this.gradeInput = new JTextField(5);
        this.schoolInput = new JTextField(5);
        this.teacherInput = new JTextField(5);
        this.attendanceInput = new JTextField(5);
        this.addChildButton = new JButton("Add");
        this.addChildLabel = new JLabel("Add a Child");
        this.homePageButton = new JButton("Home Page");
        this.nameLabel.setBounds(278, 60, 50, 25);
        this.gradeLabel.setBounds(275, 90, 55, 25);
        this.schoolLabel.setBounds(273, 120, 45, 25);
        this.teacherLabel.setBounds(195, 150, 140, 20);
        this.attendanceEmailLabel.setBounds(200, 180, 140, 30);
        this.nameInput.setBounds(330, 60, 180, 25);
        this.gradeInput.setBounds(330, 90, 180, 25);
        this.schoolInput.setBounds(330, 120, 180, 25);
        this.teacherInput.setBounds(330, 150, 180, 25);
        this.attendanceInput.setBounds(330, 180, 180, 25);
        this.addChildButton.setBounds(330, 215, 180, 25);
        this.addChildLabel.setBounds(330, 25, 90, 25);
        this.homePageButton.setBounds(605, 10, 115, 25);
        this.nameLabel.setFont(f);
        this.gradeLabel.setFont(f);
        this.schoolLabel.setFont(f);
        this.teacherLabel.setFont(f);
        this.attendanceEmailLabel.setFont(f);
        this.nameInput.setFont(f);
        this.gradeInput.setFont(f);
        this.schoolInput.setFont(f);
        this.teacherInput.setFont(f);
        this.attendanceInput.setFont(f);
        this.addChildButton.setFont(f);
        this.addChildLabel.setFont(f);
        this.homePageButton.setFont(f);
        this.nameLabel.setForeground(fontColor);
        this.gradeLabel.setForeground(fontColor);
        this.schoolLabel.setForeground(fontColor);
        this.teacherLabel.setForeground(fontColor);
        this.attendanceEmailLabel.setForeground(fontColor);
        this.addChildLabel.setForeground(fontColor);
        this.addChildButton.setForeground(fontColor);
        this.addChildButton.setBorderPainted(false);
        this.addChildButton.setOpaque(true);
        this.addChildButton.setBackground(buttonColor);
        this.homePageButton.setForeground(fontColor);
        this.homePageButton.setBorderPainted(false);
        this.homePageButton.setOpaque(true);
        this.homePageButton.setBackground(buttonColor);
        this.getContentPane().setBackground(new Color(51, 62, 88));
        this.add(this.nameLabel);
        this.add(this.gradeLabel);
        this.add(this.schoolLabel);
        this.add(this.teacherLabel);
        this.add(this.attendanceEmailLabel);
        this.add(this.nameInput);
        this.add(this.gradeInput);
        this.add(this.schoolInput);
        this.add(this.teacherInput);
        this.add(this.attendanceInput);
        this.add(this.addChildButton);
        this.add(this.addChildLabel);
        this.add(this.homePageButton);
        this.addChildButton.addActionListener(this);
        this.homePageButton.addActionListener(this);
        this.setVisible(true);
        this.setDefaultCloseOperation(3);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.homePageButton) {
            new HomeScreenGUI();
            this.setVisible(false);
        }

        if (e.getSource() == this.addChildButton) {
            try {
                int lines = this.lineCounter(SignInScreenGUI.getUsername() + ".txt");
                String[] file = new String[lines + 5];
                FileReader fr = new FileReader(SignInScreenGUI.getUsername() + ".txt");
                BufferedReader br = new BufferedReader(fr);
                String temp = br.readLine();

                for (int i = 0; i < lines; ++i) {
                    file[i] = temp;
                    temp = br.readLine();
                }

                br.close();
                file[lines] = "Name: " + this.nameInput.getText();
                file[lines + 1] = "Grade: " + this.gradeInput.getText();
                file[lines + 2] = "School: " + this.schoolInput.getText();
                file[lines + 3] = "Homeroom: " + this.teacherInput.getText();
                file[lines + 4] = "Attendance: " + this.attendanceInput.getText();
                FileWriter fw = new FileWriter(SignInScreenGUI.getUsername() + ".txt");
                PrintWriter pw = new PrintWriter(fw);

                for (int i = 0; i < lines + 5; ++i) {
                    pw.println(file[i]);
                }

                pw.close();
            } catch (IOException var10) {
                System.out.println("Error " + String.valueOf(e));
            }

            new HomeScreenGUI();
            this.setVisible(false);
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
