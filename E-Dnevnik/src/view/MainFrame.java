package view;

import view.loginPanel.LoginMenuBar;
import view.loginPanel.LoginPanel;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private LoginPanel loginPanel;
    private LoginMenuBar loginMenuBar;


    private final String ADMIN_USERNAME = "123";
    private final String ADMIN_PASSWORD = "123";

    public MainFrame() {
        setTitle("e-Student");
        setSize(550, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(true);

        initComps();
        layoutComps();
        activateComps();
    }


    private void initComps() {
        loginPanel = new LoginPanel();
        loginMenuBar = new LoginMenuBar();
    }

    private void layoutComps() {
        add(loginPanel, BorderLayout.CENTER);
        setJMenuBar(loginMenuBar);
    }

    private void activateComps() {
        loginMenuBar.setMenuBarEventListener(actionCommand -> {
            if (actionCommand.equals("admin")) {
                JTextField usernameField = new JTextField();
                JPasswordField passwordField = new JPasswordField();
                JPanel panel = new JPanel(new GridLayout(2, 2));
                panel.add(new JLabel("Enter admin username:"));
                panel.add(usernameField);
                panel.add(new JLabel("Enter admin password:"));
                panel.add(passwordField);
                int option = JOptionPane.showConfirmDialog(null, panel, "Admin Login", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {
                    String username = usernameField.getText();
                    String password = new String(passwordField.getPassword());
                    if (ADMIN_USERNAME.equals(username) && ADMIN_PASSWORD.equals(password)) {
                        JOptionPane.showMessageDialog(MainFrame.this, "Admin access granted.");
                    } else {
                        JOptionPane.showMessageDialog(MainFrame.this, "Incorrect admin credentials.");
                    }
                }
            } else if (actionCommand.equals("exit")) {
                int action = JOptionPane.showConfirmDialog(MainFrame.this, "Are you sure you want to exit?", "Exit", JOptionPane.OK_CANCEL_OPTION);
                if (action == JOptionPane.OK_OPTION) {
                    System.exit(0);
                }
            }
        });

    }

}
