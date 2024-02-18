package view.loginPanel;

import listeners.loginPanelListeners.LoginPanelEvent;
import listeners.loginPanelListeners.LoginPanelEventListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class LoginPanel extends JPanel implements ActionListener{

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

    private LoginPanelEventListener loginPanelEventListener;


    public LoginPanel() {

        initComps();
        layoutComps();
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

        // Add action listeners
        studentSignInButton.addActionListener(this);
        studentSignInButton.setActionCommand("student");
        professorSignInButton.addActionListener(this);
        professorSignInButton.setActionCommand("professor");

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

    public void setLoginPanelActionListener(LoginPanelEventListener loginPanelEventListener) {
        this.loginPanelEventListener = loginPanelEventListener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (loginPanelEventListener != null) {
            String userName;
            String password;
            if (e.getActionCommand().equals("student")) {
                userName = studentUsernameField.getText();
                password = String.valueOf(studentPasswordField.getPassword());
            } else if (e.getActionCommand().equals("professor")) {
                userName = professorUsernameField.getText();
                password = String.valueOf(professorPasswordField.getPassword());
            } else {
                throw new IllegalStateException("Unexpected value: " + e.getActionCommand());
            }
            LoginPanelEvent loginPanelEvent = new LoginPanelEvent(this, userName, password, e.getActionCommand());
            loginPanelEventListener.loginPanelEventOccurred(loginPanelEvent);
        }
    }

}
