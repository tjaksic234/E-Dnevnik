package view.adminPanel;

import controller.Controller;
import observer.Observer;

import javax.swing.*;
import java.awt.*;

public class AdminFrame extends JFrame implements Observer {

    private AdminPanel adminPanel;
    private AdminMenuBar adminMenuBar;

    private Controller controller;

    public AdminFrame() {
        setTitle("ADMIN PANEL");
        setSize(550, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(true);

        initializeComponents();
        layoutComponents();
        activateComponents();
    }

    private void initializeComponents() {
        controller = new Controller();
        adminPanel = new AdminPanel();
        adminMenuBar = new AdminMenuBar();
        controller.addObserver(this);
    }

    private void layoutComponents() {
        add(adminPanel, BorderLayout.CENTER);
        setJMenuBar(adminMenuBar);
    }

    private void activateComponents() {
        adminMenuBar.setMenuBarEventListener(actionCommand -> {
            if (actionCommand.equals("exit")) {
                int option = JOptionPane.showConfirmDialog(AdminFrame.this, "Are you sure you want to exit?", "Exit", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {
                    System.exit(0);
                }
            }
        });
    }


    @Override
    public void update() {
        System.out.println("AdminFrame received update from Controller.");
    }
}
