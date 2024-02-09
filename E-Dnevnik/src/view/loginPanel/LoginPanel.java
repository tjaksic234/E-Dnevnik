package view.loginPanel;

import javax.swing.*;
import java.awt.*;

public class LoginPanel extends JPanel {

    private JLabel studentTitleLabel;
    private JLabel teacherTitleLabel;
    private JLabel studentUsernameLabel;
    private JLabel studentPasswordLabel;
    private JLabel teacherUsernameLabel;
    private JLabel teacherPasswordLabel;
    private JTextField studentUsernameField;
    private JPasswordField studentPasswordField;
    private JTextField teacherUsernameField;
    private JPasswordField teacherPasswordField;
    private JButton studentSignInButton;
    private JButton teacherSignInButton;

    public LoginPanel() {
        setBackground(new Color(105,105,105));

        initComps();
        layoutComps();
        activateComps();
    }

    private void initComps() {
        studentTitleLabel = new JLabel("Students");
        teacherTitleLabel = new JLabel("Teachers");
        studentUsernameLabel = new JLabel("Username:");
        studentPasswordLabel = new JLabel("Password:");
        teacherUsernameLabel = new JLabel("Username:");
        teacherPasswordLabel = new JLabel("Password:");
        studentUsernameField = new JTextField();
        studentPasswordField = new JPasswordField();
        teacherUsernameField = new JTextField();
        teacherPasswordField = new JPasswordField();
        studentSignInButton = new JButton("Sign-in");
        teacherSignInButton = new JButton("Sign-in");


        studentSignInButton.setBackground(new Color(105,105,105));
        teacherSignInButton.setBackground(new Color(105,105,105));



        studentSignInButton.setForeground(Color.WHITE);
        teacherSignInButton.setForeground(Color.WHITE);

        studentSignInButton.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        teacherSignInButton.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        studentTitleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        teacherTitleLabel.setFont(new Font("Arial", Font.BOLD, 20));


        studentTitleLabel.setForeground(Color.WHITE);
        teacherTitleLabel.setForeground(Color.WHITE);

        studentUsernameLabel.setForeground(Color.WHITE);
        teacherUsernameLabel.setForeground(Color.WHITE);

        studentPasswordLabel.setForeground(Color.WHITE);
        teacherPasswordLabel.setForeground(Color.WHITE);
    }

    private void layoutComps() {
        setLayout(new GridLayout(0, 2, 10, 10));

        add(studentTitleLabel);
        add(teacherTitleLabel);
        add(studentUsernameLabel);
        add(teacherUsernameLabel);
        add(studentUsernameField);
        add(teacherUsernameField);
        add(studentPasswordLabel);
        add(teacherPasswordLabel);
        add(studentPasswordField);
        add(teacherPasswordField);
        add(studentSignInButton);
        add(teacherSignInButton);
    }



    public void activateComps() {
        studentSignInButton.addActionListener(e -> {
            String username = studentUsernameField.getText();
            String password = new String(studentPasswordField.getPassword());
            if (checkStudentCredentials(username, password)) {
                JOptionPane.showMessageDialog(this, "Student access granted.");
                reset();
            } else {
                JOptionPane.showMessageDialog(this, "Incorrect student credentials.");
            }
        });

        teacherSignInButton.addActionListener(e -> {
            String username = teacherUsernameField.getText();
            String password = new String(teacherPasswordField.getPassword());
            if (checkTeacherCredentials(username, password)) {
                JOptionPane.showMessageDialog(this, "Teacher access granted.");
                reset();
            } else {
                JOptionPane.showMessageDialog(this, "Incorrect teacher credentials.");
            }
        });
    }

    public void reset() {
        studentUsernameField.setText("");
        studentPasswordField.setText("");
        teacherUsernameField.setText("");
        teacherPasswordField.setText("");
    }

    private boolean checkStudentCredentials(String username, String password) {
        return username.equals("student") && password.equals("student");
    }

    private boolean checkTeacherCredentials(String username, String password) {
        return username.equals("teacher") && password.equals("teacher");
    }
}
