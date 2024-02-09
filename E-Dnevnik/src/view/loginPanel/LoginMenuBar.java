package view.loginPanel;

import listeners.MenuBarEventListener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginMenuBar extends JMenuBar implements ActionListener {

    private JMenu menu;
    private JMenuItem adminMenuItem;
    private JMenuItem exitItem;

    private MenuBarEventListener menuBarEventListener;

    public LoginMenuBar() {
        initComps();
        layoutComps();
    }

    private void initComps() {
        menu = new JMenu("Menu");

        adminMenuItem = new JMenuItem("Admin");
        adminMenuItem.addActionListener(this);
        adminMenuItem.setActionCommand("admin");

        exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(this);
        exitItem.setActionCommand("exit");


    }

    private void layoutComps() {
        menu.add(adminMenuItem);
        menu.add(exitItem);
        add(menu);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (menuBarEventListener != null) {
            menuBarEventListener.menuBarEventOccurred(e.getActionCommand());
        }
    }

    public void setMenuBarEventListener(MenuBarEventListener menuBarEventListener) {
        this.menuBarEventListener = menuBarEventListener;
    }
}
