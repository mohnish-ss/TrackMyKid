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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SetHomeworkScreenGUI extends JFrame implements ActionListener {
    private JComboBox childList;
    private JLabel selectChildLabel;
    private JLabel subjectLabel;
    private JComboBox subjectList;
    private JComboBox timeList;
    private JLabel timeLabel;
    private JButton startHomeworkButton;
    private JButton homePageButton;
    private static int homeworkTime;
    private static String childName;
    private static String subject;

    public SetHomeworkScreenGUI() {
        this.setBounds(380, 230, 755, 250);
        this.setLayout((LayoutManager) null);
        Font f = new Font("Muli", 0, 13);
        Color fontColor = new Color(242, 242, 242);
        Color buttonColor = new Color(54, 53, 53);
        String[] subjectItems = new String[] { "Math", "English", "Science", "Art", "French", "Health", "Music",
                "Tech" };
        String[] timeItems = new String[] { "10", "20", "30", "40", "50", "60" };
        this.childList = new JComboBox();
        this.selectChildLabel = new JLabel("Select Child");
        this.subjectLabel = new JLabel("Subject");
        this.subjectList = new JComboBox(subjectItems);
        this.timeList = new JComboBox(timeItems);
        this.timeLabel = new JLabel("Time (minutes)");
        this.startHomeworkButton = new JButton("Start Homework");
        this.homePageButton = new JButton("Home Page");
        this.childList.setBounds(360, 40, 120, 25);
        this.selectChildLabel.setBounds(280, 40, 70, 25);
        this.subjectLabel.setBounds(303, 70, 50, 25);
        this.subjectList.setBounds(360, 70, 120, 25);
        this.timeList.setBounds(360, 100, 120, 25);
        this.timeLabel.setBounds(260, 100, 110, 25);
        this.startHomeworkButton.setBounds(290, 140, 150, 25);
        this.homePageButton.setBounds(605, 10, 115, 25);
        this.startHomeworkButton.addActionListener(this);
        this.homePageButton.addActionListener(this);
        this.childList.setFont(f);
        this.selectChildLabel.setFont(f);
        this.subjectLabel.setFont(f);
        this.subjectList.setFont(f);
        this.timeLabel.setFont(f);
        this.timeList.setFont(f);
        this.startHomeworkButton.setFont(f);
        this.homePageButton.setFont(f);
        this.selectChildLabel.setForeground(fontColor);
        this.subjectLabel.setForeground(fontColor);
        this.timeLabel.setForeground(fontColor);
        this.startHomeworkButton.setForeground(fontColor);
        this.startHomeworkButton.setBorderPainted(false);
        this.startHomeworkButton.setOpaque(true);
        this.startHomeworkButton.setBackground(buttonColor);
        this.homePageButton.setForeground(fontColor);
        this.homePageButton.setBorderPainted(false);
        this.homePageButton.setOpaque(true);
        this.homePageButton.setBackground(buttonColor);
        this.getContentPane().setBackground(new Color(51, 62, 88));

        try {
            FileReader fr = new FileReader(SignInScreenGUI.getUsername() + ".txt");
            BufferedReader br = new BufferedReader(fr);
            int lines = this.lineCounter(SignInScreenGUI.getUsername() + ".txt");
            String[] file = new String[lines];
            String temp = br.readLine();

            int i;
            for (i = 0; i < lines; ++i) {
                file[i] = temp;
                temp = br.readLine();
            }

            for (i = 2; i < file.length; i += 5) {
                if (file[i].length() != 0) {
                    this.childList.addItem(file[i].substring(6));
                }
            }
        } catch (IOException var12) {
            System.out.println(var12);
        }

        this.add(this.childList);
        this.add(this.selectChildLabel);
        this.add(this.subjectLabel);
        this.add(this.subjectList);
        this.add(this.timeLabel);
        this.add(this.timeList);
        this.add(this.startHomeworkButton);
        this.add(this.homePageButton);
        this.setVisible(true);
        this.setDefaultCloseOperation(3);
    }

    public static int getHomeworkTime() {
        return homeworkTime;
    }

    public static String getChildName() {
        return childName;
    }

    public static String getSubject() {
        return subject;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.homePageButton) {
            new HomeScreenGUI();
            this.setVisible(false);
        }

        if (e.getSource() == this.startHomeworkButton) {
            homeworkTime = Integer.parseInt((String) this.timeList.getSelectedItem());
            childName = (String) this.childList.getSelectedItem();
            subject = (String) this.subjectList.getSelectedItem();
            new ChildTimerScreenGUI();
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
