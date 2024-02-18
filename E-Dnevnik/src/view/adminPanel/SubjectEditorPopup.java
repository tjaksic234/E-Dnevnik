package view.adminPanel;

import listeners.adminPanelListeners.SubjectEditorEventListener;
import listeners.adminPanelListeners.SubjectEditorEvent;
import model.ProfessorCredentials;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class SubjectEditorPopup extends JPopupMenu implements ActionListener {

    private JList<String> subjectList;
    private JTable table;
    private DefaultTableModel tableModel;
    private JScrollPane listScrollPane;
    private JScrollPane tableScrollPane;
    private JButton assignButton;
    private JButton undoButton;
    private JButton exitButton;
    private JPanel buttonPanel;

    private ArrayList<ProfessorCredentials> data;

    private SubjectEditorEventListener subjectEditorEventListener;

    public SubjectEditorPopup() {
        initComps();
        layoutComps();
    }

    private void initComps() {
        subjectList = new JList<>();
        table = new JTable();
        tableModel = new DefaultTableModel();
        listScrollPane = new JScrollPane(subjectList);
        tableScrollPane = new JScrollPane(table);
        assignButton = new JButton("Assign");
        undoButton = new JButton("Undo");
        exitButton = new JButton("Exit");
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        assignButton.addActionListener(this);
        assignButton.setActionCommand("assign");

        undoButton.addActionListener(this);
        undoButton.setActionCommand("undo");

        exitButton.addActionListener(this);
        exitButton.setActionCommand("exit");


    }

    private void layoutComps() {
        // Add the JTable to a scroll pane
        tableScrollPane = new JScrollPane(table);

        // Add the JList to a scroll pane
        listScrollPane = new JScrollPane(subjectList);

        // Add the scroll panes to the popup menu
        add(tableScrollPane, BorderLayout.WEST);
        add(listScrollPane, BorderLayout.CENTER);

        // Add buttons to the button panel
        buttonPanel.add(assignButton);
        buttonPanel.add(undoButton);
        buttonPanel.add(exitButton); // Add the exit button

        // Add the button panel to the bottom of the popup menu
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public void fillJList(HashMap<String, String> data) {
        DefaultListModel<String> model = new DefaultListModel<>();
        for (String key : data.keySet()) {
            model.addElement(data.get(key));
        }
        subjectList.setModel(model);
    }

    public void fillTable(ArrayList<ProfessorCredentials> data) {
        String[] columnNames = {"Name", "Surname", "Unique ID"};



        // Set the column names in the table model
        tableModel.setColumnIdentifiers(columnNames);

        // Clear any existing data from the table model
        tableModel.setRowCount(0);

        // Add data from the ArrayList to the table model
        for (ProfessorCredentials professor : data) {
            Object[] rowData = {professor.getName(), professor.getSurname(), professor.getUniqueID()};
            tableModel.addRow(rowData);
        }

        // Set the table model to the JTable
        table.setModel(tableModel);

        table.setDefaultEditor(Object.class, null);
    }

    private ProfessorCredentials getSelectedProfessor(int rowIndex) {
        // Check if the row index is valid
        if (rowIndex >= 0 && rowIndex < tableModel.getRowCount()) {
            // Get the data from the table model at the specified row index
            String name = tableModel.getValueAt(rowIndex, 0).toString();
            String surname = tableModel.getValueAt(rowIndex, 1).toString();
            String uniqueID = tableModel.getValueAt(rowIndex, 2).toString();
            // Create and return a new ProfessorCredentials object
            return new ProfessorCredentials(name, surname, uniqueID);
        } else {
            // Return null or handle the case when the row index is invalid
            return null;
        }
    }

    public void teacherDataUpdate(ArrayList<ProfessorCredentials> data) {
        this.data = data;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int selectedRow = table.getSelectedRow();
        ProfessorCredentials professor = getSelectedProfessor(selectedRow);
        ArrayList<String> selectedSubjects = null;
        if (!subjectList.getSelectedValuesList().isEmpty()) {
            selectedSubjects = (ArrayList<String>) subjectList.getSelectedValuesList();
        }
        if (e.getActionCommand().equals("assign")) {
            if (selectedSubjects != null && selectedRow != -1 && professor != null) {
                professor.setPassword(data.get(selectedRow).getPassword());
                SubjectEditorEvent event = new SubjectEditorEvent(this, professor, selectedSubjects, e.getActionCommand());
                subjectEditorEventListener.subjectEditorEventOccurred(event);
            }
        }
        if (e.getActionCommand().equals("undo")) {
            if (selectedRow != -1 && professor != null && selectedSubjects != null) {
                SubjectEditorEvent event = new SubjectEditorEvent(this, professor, selectedSubjects, e.getActionCommand());
                subjectEditorEventListener.subjectEditorEventOccurred(event);
            }

        }
        if (e.getActionCommand().equals("exit")) {
            System.out.println("Exiting subject editor panel.");
            setVisible(false);
        }
    }

    public void setSubjectEditorActionListener(SubjectEditorEventListener subjectEditorEventListener) {
        this.subjectEditorEventListener = subjectEditorEventListener;
    }
}
