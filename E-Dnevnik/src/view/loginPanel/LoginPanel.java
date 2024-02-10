package view.loginPanel;

import javax.swing.*;
import java.awt.*;

public class LoginPanel extends JPanel {

    private JLabel studentTitleLabel;
    private JLabel professorTitleLabel;
    private JLabel studentUsernameLabel;
    private JLabel studentPasswordLabel;
    private JLabel professorUsernameLabel;
    private JLabel professorPasswordLabel;
    private JTextField studentUsernameField;
    private JPasswordField studentPasswordField;
    private JTextField professorUsernameField;
    private JPasswordField professorPasswordField;
    private JButton studentSignInButton;
    private JButton professorSignInButton;

    public LoginPanel() {

        initComps();
        layoutComps();
        activateComps();
    }

    private void initComps() {
        studentTitleLabel = new JLabel("Students");
        professorTitleLabel = new JLabel("Professors");
        studentUsernameLabel = new JLabel("Username:");
        studentPasswordLabel = new JLabel("Password:");
        professorUsernameLabel = new JLabel("Username:");
        professorPasswordLabel = new JLabel("Password:");
        studentUsernameField = new JTextField();
        studentPasswordField = new JPasswordField();
        professorUsernameField = new JTextField();
        professorPasswordField = new JPasswordField();
        studentSignInButton = new JButton("Sign-in");
        professorSignInButton = new JButton("Sign-in");


        studentSignInButton.setBackground(new Color(105,105,105));
        professorSignInButton.setBackground(new Color(105,105,105));



        studentSignInButton.setForeground(Color.WHITE);
        professorSignInButton.setForeground(Color.WHITE);

        studentSignInButton.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        professorSignInButton.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        studentTitleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        professorTitleLabel.setFont(new Font("Arial", Font.BOLD, 20));


        studentTitleLabel.setForeground(Color.WHITE);
        professorTitleLabel.setForeground(Color.WHITE);

        studentUsernameLabel.setForeground(Color.WHITE);
        professorUsernameLabel.setForeground(Color.WHITE);

        studentPasswordLabel.setForeground(Color.WHITE);
        professorPasswordLabel.setForeground(Color.WHITE);
    }

    private void layoutComps() {
        setLayout(new GridLayout(0, 2, 10, 10));

        add(studentTitleLabel);
        add(professorTitleLabel);
        add(studentUsernameLabel);
        add(professorUsernameLabel);
        add(studentUsernameField);
        add(professorUsernameField);
        add(studentPasswordLabel);
        add(professorPasswordLabel);
        add(studentPasswordField);
        add(professorPasswordField);
        add(studentSignInButton);
        add(professorSignInButton);
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

        professorSignInButton.addActionListener(e -> {
            String username = professorUsernameField.getText();
            String password = new String(professorPasswordField.getPassword());
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
        professorUsernameField.setText("");
        professorPasswordField.setText("");
    }

    private boolean checkStudentCredentials(String username, String password) {
        return username.equals("student") && password.equals("student");
    }

    private boolean checkTeacherCredentials(String username, String password) {
        return username.equals("teacher") && password.equals("teacher");
    }
}
