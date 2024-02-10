package view.adminPanel;

import listeners.MenuBarEventListener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminMenuBar extends JMenuBar implements ActionListener {

    private JMenu optionsMenu;
    private JMenuItem importDataItem;
    private JMenuItem exportDataItem;
    private JMenuItem logOutItem;
    private JMenuItem exitItem;

    private JMenu subjectMenu;
    private JMenuItem startEditorItem;

    private JMenu overviewMenu;
    private JMenuItem studentOverviewItem;
    private JMenuItem professorOverviewItem;

    private MenuBarEventListener menuBarEventListener;


    public AdminMenuBar() {
        initComps();
        layoutComps();
    }


    private void initComps() {
        optionsMenu = new JMenu("Options");
        importDataItem = new JMenuItem("Import Data");
        exportDataItem = new JMenuItem("Export Data");
        logOutItem = new JMenuItem("Log Out");
        exitItem = new JMenuItem("Exit");

        importDataItem.addActionListener(this);
        importDataItem.setActionCommand("importData");

        exportDataItem.addActionListener(this);
        exportDataItem.setActionCommand("exportData");

        logOutItem.addActionListener(this);
        logOutItem.setActionCommand("logOut");

        exitItem.addActionListener(this);
        exitItem.setActionCommand("exit");

        subjectMenu = new JMenu("Subjects");
        startEditorItem = new JMenuItem("Start Editor");

        startEditorItem.addActionListener(this);
        startEditorItem.setActionCommand("startEditor");

        overviewMenu = new JMenu("Overview");
        studentOverviewItem = new JMenuItem("Student Overview");
        professorOverviewItem = new JMenuItem("Professor Overview");

        studentOverviewItem.addActionListener(this);
        studentOverviewItem.setActionCommand("studentOverview");

        professorOverviewItem.addActionListener(this);
        professorOverviewItem.setActionCommand("professorOverview");
    }

    private void layoutComps() {
        optionsMenu.add(importDataItem);
        optionsMenu.add(exportDataItem);
        optionsMenu.add(logOutItem);
        optionsMenu.add(exitItem);

        subjectMenu.add(startEditorItem);

        overviewMenu.add(studentOverviewItem);
        overviewMenu.add(professorOverviewItem);

        add(optionsMenu);
        add(subjectMenu);
        add(overviewMenu);
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
