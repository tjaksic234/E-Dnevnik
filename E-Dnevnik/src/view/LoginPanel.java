package view;

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

    public void reset() {
        studentUsernameField.setText("");
        studentPasswordField.setText("");
        teacherUsernameField.setText("");
        teacherPasswordField.setText("");
    }

    public void checkFields() {
        if (studentUsernameField.getText().isEmpty() || studentPasswordField.getPassword().length == 0) {
            studentSignInButton.setEnabled(false);
        } else {
            studentSignInButton.setEnabled(true);
        }

        if (teacherUsernameField.getText().isEmpty() || teacherPasswordField.getPassword().length == 0) {
            teacherSignInButton.setEnabled(false);
        } else {
            teacherSignInButton.setEnabled(true);
        }
    }
}
