package ICS3URFinalProject;

import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class HomeScreenGUI extends JFrame implements ActionListener {
    private JButton addChildButton;
    private JButton setHomeworkButton;
    private JLabel selectChildLabel;
    private JLabel childrenLabel;
    private JButton manageButton;
    private JButton signOutButton;
    private JComboBox childSelectBox;
    private JLabel sendEmailLabel;
    private JButton sickEmailButton;
    private JButton doctorEmailButton;
    private JButton sportEmailButton;
    private JTextArea childTextArea;
    private JButton deleteButton;
    private JComboBox childSelectBoxDelete;
    private static String childName;
    private static String reason;
    private JLabel deleteChildLabel;

    public HomeScreenGUI() {
        this.setBounds(380, 230, 755, 250);
        this.setLayout((LayoutManager) null);
        Font f = new Font("Muli", 0, 13);
        Color fontColor = new Color(242, 242, 242);
        Color buttonColor = new Color(54, 53, 53);
        this.addChildButton = new JButton("Add Child");
        this.setHomeworkButton = new JButton("Set Homework");
        this.selectChildLabel = new JLabel("Select Child");
        this.childrenLabel = new JLabel("Children");
        this.manageButton = new JButton("Manage");
        this.signOutButton = new JButton("Sign Out");
        this.childSelectBox = new JComboBox();
        this.childSelectBoxDelete = new JComboBox();
        this.sendEmailLabel = new JLabel("Send E-mail");
        this.sickEmailButton = new JButton("Sick");
        this.doctorEmailButton = new JButton("Doctor");
        this.sportEmailButton = new JButton("Sport");
        this.childTextArea = new JTextArea(5, 5);
        this.deleteButton = new JButton("Delete");
        this.deleteChildLabel = new JLabel("Delete Child");
        this.addChildButton.setBounds(235, 70, 150, 25);
        this.setHomeworkButton.setBounds(235, 40, 150, 25);
        this.selectChildLabel.setBounds(405, 45, 100, 25);
        this.childrenLabel.setBounds(100, 15, 100, 25);
        this.manageButton.setBounds(615, 10, 100, 25);
        this.signOutButton.setBounds(615, 40, 100, 25);
        this.childSelectBox.setBounds(480, 45, 125, 25);
        this.sendEmailLabel.setBounds(470, 15, 100, 25);
        this.sickEmailButton.setBounds(405, 85, 200, 25);
        this.doctorEmailButton.setBounds(405, 120, 200, 25);
        this.sportEmailButton.setBounds(405, 155, 200, 25);
        this.childTextArea.setBounds(25, 45, 190, 140);
        this.deleteButton.setBounds(233, 160, 150, 25);
        this.childSelectBoxDelete.setBounds(235, 130, 150, 25);
        this.deleteChildLabel.setBounds(235, 100, 150, 25);
        this.deleteChildLabel.setHorizontalAlignment(0);
        this.addChildButton.setFont(f);
        this.setHomeworkButton.setFont(f);
        this.selectChildLabel.setFont(f);
        this.childrenLabel.setFont(f);
        this.manageButton.setFont(f);
        this.signOutButton.setFont(f);
        this.childSelectBox.setFont(f);
        this.childSelectBoxDelete.setFont(f);
        this.sendEmailLabel.setFont(f);
        this.sickEmailButton.setFont(f);
        this.doctorEmailButton.setFont(f);
        this.sportEmailButton.setFont(f);
        this.childTextArea.setFont(f);
        this.deleteButton.setFont(f);
        this.deleteChildLabel.setFont(f);
        this.deleteChildLabel.setForeground(fontColor);
        this.selectChildLabel.setForeground(fontColor);
        this.setHomeworkButton.setForeground(fontColor);
        this.setHomeworkButton.setBorderPainted(false);
        this.setHomeworkButton.setOpaque(true);
        this.setHomeworkButton.setBackground(buttonColor);
        this.addChildButton.setForeground(fontColor);
        this.addChildButton.setBorderPainted(false);
        this.addChildButton.setOpaque(true);
        this.addChildButton.setBackground(buttonColor);
        this.childrenLabel.setForeground(fontColor);
        this.manageButton.setForeground(fontColor);
        this.manageButton.setBorderPainted(false);
        this.manageButton.setOpaque(true);
        this.manageButton.setBackground(buttonColor);
        this.signOutButton.setForeground(fontColor);
        this.signOutButton.setBorderPainted(false);
        this.signOutButton.setOpaque(true);
        this.signOutButton.setBackground(buttonColor);
        this.sendEmailLabel.setForeground(fontColor);
        this.sickEmailButton.setForeground(fontColor);
        this.sickEmailButton.setBorderPainted(false);
        this.sickEmailButton.setOpaque(true);
        this.sickEmailButton.setBackground(buttonColor);
        this.sportEmailButton.setForeground(fontColor);
        this.sportEmailButton.setBorderPainted(false);
        this.sportEmailButton.setOpaque(true);
        this.sportEmailButton.setBackground(buttonColor);
        this.doctorEmailButton.setForeground(fontColor);
        this.doctorEmailButton.setBorderPainted(false);
        this.doctorEmailButton.setOpaque(true);
        this.doctorEmailButton.setBackground(buttonColor);
        this.childTextArea.setForeground(fontColor);
        this.childTextArea.setBackground(buttonColor);
        this.deleteButton.setForeground(fontColor);
        this.deleteButton.setOpaque(true);
        this.deleteButton.setBorderPainted(false);
        this.deleteButton.setBackground(buttonColor);
        this.getContentPane().setBackground(new Color(51, 62, 88));
        this.add(this.deleteChildLabel);
        this.add(this.addChildButton);
        this.add(this.setHomeworkButton);
        this.add(this.selectChildLabel);
        this.add(this.childrenLabel);
        this.add(this.manageButton);
        this.add(this.signOutButton);
        this.add(this.childSelectBox);
        this.add(this.sendEmailLabel);
        this.add(this.sickEmailButton);
        this.add(this.doctorEmailButton);
        this.add(this.sportEmailButton);
        this.add(this.childTextArea);
        this.add(this.childSelectBoxDelete);
        this.add(this.deleteButton);
        this.addChildButton.addActionListener(this);
        this.deleteButton.addActionListener(this);
        this.sportEmailButton.addActionListener(this);
        this.doctorEmailButton.addActionListener(this);
        this.sickEmailButton.addActionListener(this);
        this.signOutButton.addActionListener(this);
        this.manageButton.addActionListener(this);
        this.setHomeworkButton.addActionListener(this);

        try {
            FileReader fr = new FileReader(SignInScreenGUI.getUsername() + ".txt");
            BufferedReader br = new BufferedReader(fr);
            int lines = lineCounter(SignInScreenGUI.getUsername() + ".txt");
            String[] file = new String[lines];
            String temp = br.readLine();

            int i;
            for (i = 0; i < lines; ++i) {
                file[i] = temp;
                temp = br.readLine();
            }

            for (i = 2; i < file.length; i += 5) {
                if (file[i].length() != 0) {
                    this.childSelectBox.addItem(file[i].substring(6));
                    this.childSelectBoxDelete.addItem(file[i].substring(6));
                    this.childTextArea.append(file[i].substring(6) + "\n");
                }
            }
        } catch (IOException var10) {
            System.out.println(var10);
        }

        this.setVisible(true);
        this.setDefaultCloseOperation(3);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.sickEmailButton) {
            reason = "Sick";
            childName = (String) this.childSelectBox.getSelectedItem();

            try {
                new SendEmailScreenGUI();
            } catch (IOException var13) {
                System.out.println(var13);
            }

            this.setVisible(false);
        }

        if (e.getSource() == this.doctorEmailButton) {
            reason = "Doctor";
            childName = (String) this.childSelectBox.getSelectedItem();

            try {
                new SendEmailScreenGUI();
            } catch (IOException var12) {
                System.out.println(var12);
            }

            this.setVisible(false);
        }

        if (e.getSource() == this.sportEmailButton) {
            reason = "Sport";
            childName = (String) this.childSelectBox.getSelectedItem();

            try {
                new SendEmailScreenGUI();
            } catch (IOException var11) {
                System.out.println(var11);
            }

            this.setVisible(false);
        }

        if (e.getSource() == this.manageButton) {
            new AccountManagementScreenGUI();
            this.setVisible(false);
        }

        if (e.getSource() == this.signOutButton) {
            new SignInScreenGUI();
            this.setVisible(false);
        }

        if (e.getSource() == this.addChildButton) {
            new AddChildScreenGUI();
            this.setVisible(false);
        }

        if (e.getSource() == this.setHomeworkButton) {
            new SetHomeworkScreenGUI();
            this.setVisible(false);
        }

        if (e.getSource() == this.deleteButton) {
            try {
                FileReader fr = new FileReader(SignInScreenGUI.getUsername() + ".txt");
                BufferedReader br = new BufferedReader(fr);
                int lines = lineCounter(SignInScreenGUI.getUsername() + ".txt");
                String[] file = new String[lines];
                String temp = br.readLine();

                int nameIndex;
                for (nameIndex = 0; nameIndex < lines; ++nameIndex) {
                    file[nameIndex] = temp;
                    temp = br.readLine();
                }

                br.close();
                nameIndex = 0;

                for (int i = 2; i < file.length; i += 5) {
                    if (file[i].equals("Name: " + String.valueOf(this.childSelectBoxDelete.getSelectedItem()))) {
                        nameIndex = i;
                        break;
                    }
                }

                file[nameIndex] = "";
                file[nameIndex + 1] = "";
                file[nameIndex + 2] = "";
                file[nameIndex + 3] = "";
                file[nameIndex + 4] = "";
                FileWriter fw = new FileWriter(SignInScreenGUI.getUsername() + ".txt");
                PrintWriter pw = new PrintWriter(fw);

                for (int i = 0; i < file.length; ++i) {
                    if (!file[i].equals("")) {
                        pw.println(file[i]);
                    }
                }

                pw.close();
                new HomeScreenGUI();
                this.setVisible(false);
            } catch (IOException var14) {
                System.out.println(var14);
            }
        }

    }

    public static String getReason() {
        return reason;
    }

    public static String getChildName() {
        return childName.strip();
    }

    public static String getAttendanceEmail() throws IOException {
        int emailIndex = 0;
        int lines = lineCounter(SignInScreenGUI.getUsername() + ".txt");
        String[] file = new String[lines];

        try {
            FileReader fr = new FileReader(SignInScreenGUI.getUsername() + ".txt");
            BufferedReader br = new BufferedReader(fr);
            String temp = br.readLine();

            for (int i = 0; i < lines; ++i) {
                file[i] = temp;
                if (file[i].equals("Name: " + childName)) {
                    emailIndex = i + 4;
                }

                temp = br.readLine();
            }
        } catch (FileNotFoundException var7) {
            System.out.println(var7);
        }

        return file[emailIndex].substring(12).strip();
    }

    public static String getGrade() throws IOException {
        int gradeIndex = 0;
        int lines = lineCounter(SignInScreenGUI.getUsername() + ".txt");
        String[] file = new String[lines];

        try {
            FileReader fr = new FileReader(SignInScreenGUI.getUsername() + ".txt");
            BufferedReader br = new BufferedReader(fr);
            String temp = br.readLine();

            for (int i = 0; i < lines; ++i) {
                file[i] = temp;
                if (file[i].equals("Name: " + childName)) {
                    gradeIndex = i + 1;
                }

                temp = br.readLine();
            }
        } catch (FileNotFoundException var7) {
            System.out.println(var7);
        }

        return file[gradeIndex].substring(7);
    }

    public static String getTeacher() throws IOException {
        int teacherIndex = 0;
        int lines = lineCounter(SignInScreenGUI.getUsername() + ".txt");
        String[] file = new String[lines];

        try {
            FileReader fr = new FileReader(SignInScreenGUI.getUsername() + ".txt");
            BufferedReader br = new BufferedReader(fr);
            String temp = br.readLine();

            for (int i = 0; i < lines; ++i) {
                file[i] = temp;
                if (file[i].equals("Name: " + childName)) {
                    teacherIndex = i + 3;
                }

                temp = br.readLine();
            }
        } catch (FileNotFoundException var7) {
            System.out.println(var7);
        }

        return file[teacherIndex].substring(10);
    }

    public static int lineCounter(String file) {
        int lines = 0;

        try {
            FileReader fr = new FileReader(SignInScreenGUI.getUsername() + ".txt");
            BufferedReader br = new BufferedReader(fr);

            for (String temp = br.readLine(); temp != null; temp = br.readLine()) {
                ++lines;
            }

            br.close();
        } catch (IOException var5) {
            System.out.println("Error" + String.valueOf(var5));
        }

        return lines;
    }
}
