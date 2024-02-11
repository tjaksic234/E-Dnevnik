package view.adminPanel;

import listeners.AdminPanelActionListener;
import listeners.AdminPanelEvent;
import model.Credentials;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class AdminPanel extends JPanel implements ActionListener {

    private JTextField studentNameField;
    private JTextField studentSurnameField;
    private JTextField professorNameField;
    private JTextField professorSurnameField;
    private JButton registerStudentButton;
    private JButton registerProfessorButton;
    private JButton undoStudentButton;
    private JButton undoProfessorButton;

    private JTextField studentUniqueIdField;
    private JTextField professorUniqueIdField;
    private JLabel studentUniqueIdLabel;
    private JLabel professorUniqueIdLabel;

    private AdminPanelActionListener adminPanelActionListener;

    public AdminPanel() {

        initializeComponents();
        layoutComponents();
    }

    private void initializeComponents() {
        Font labelFont = new Font("Arial", Font.BOLD, 14);

        studentNameField = new JTextField(20);
        studentSurnameField = new JTextField(20);
        professorNameField = new JTextField(20);
        professorSurnameField = new JTextField(20);

        registerStudentButton = new JButton("          Register          ");
        registerProfessorButton = new JButton("          Register          ");
        undoStudentButton = new JButton("            Undo             ");
        undoProfessorButton = new JButton("            Undo             ");

        studentUniqueIdField = new JTextField(20);
        studentUniqueIdLabel = new JLabel("Unique ID:");
        professorUniqueIdField = new JTextField(20);
        professorUniqueIdLabel = new JLabel("Unique ID:");

        // Styling buttons
        registerStudentButton.setBackground(new Color(0, 153, 51));
        registerProfessorButton.setBackground(new Color(0, 153, 51));
        undoStudentButton.setBackground(new Color(255, 0, 0));
        undoProfessorButton.setBackground(new Color(255, 0, 0));

        registerStudentButton.setForeground(Color.WHITE);
        registerProfessorButton.setForeground(Color.WHITE);
        undoStudentButton.setForeground(Color.WHITE);
        undoProfessorButton.setForeground(Color.WHITE);

        // Styling text fields
        studentNameField.setFont(labelFont);
        studentSurnameField.setFont(labelFont);
        professorNameField.setFont(labelFont);
        professorSurnameField.setFont(labelFont);

        // Adjusting preferred sizes
        studentNameField.setPreferredSize(new Dimension(200, 30));
        studentSurnameField.setPreferredSize(new Dimension(200, 30));
        professorNameField.setPreferredSize(new Dimension(200, 30));
        professorSurnameField.setPreferredSize(new Dimension(200, 30));

        registerStudentButton.setPreferredSize(new Dimension(150, 40));
        registerProfessorButton.setPreferredSize(new Dimension(150, 40));
        undoStudentButton.setPreferredSize(new Dimension(150, 40));
        undoProfessorButton.setPreferredSize(new Dimension(150, 40));


        // Add action listener to buttons
        registerStudentButton.addActionListener(this);
        registerStudentButton.setActionCommand("register_student");
        registerProfessorButton.addActionListener(this);
        registerProfessorButton.setActionCommand("register_professor");
        undoStudentButton.addActionListener(this);
        undoStudentButton.setActionCommand("undo_student");
        undoProfessorButton.addActionListener(this);
        undoProfessorButton.setActionCommand("undo_professor");
    }

    private void layoutComponents() {
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BorderLayout());
        leftPanel.setBorder(BorderFactory.createTitledBorder("FAQs"));
        leftPanel.setPreferredSize(new Dimension(200, getHeight()));

        JTextArea textArea = new JTextArea(
                "This is the admin panel, which serves as the control center for managing student and professor data. Here's how to use it:\n\n"
                        + "1. Student Registration:\n"
                        + "   - Enter the student's name, surname, and unique ID in the respective fields.\n"
                        + "   - Click the 'Register' button to add the student to the system.\n"
                        + "   - To undo the last student registration, click the 'Undo' button.\n\n"
                        + "2. Professor Registration:\n"
                        + "   - Enter the professor's name, surname, and unique ID in the respective fields.\n"
                        + "   - Click the 'Register' button to add the professor to the system.\n"
                        + "   - To undo the last professor registration, click the 'Undo' button.\n\n"
                        + "Note: All fields must be filled, and the unique ID must not be already in use.\n"
                        + "The left panel provides information and FAQs related to this admin panel.\n"
                        + "Use the 'Exit' option from the menu to close the application, and 'Log Out' to return to the login screen.\n\n"
                        + "Menu Options (CSV Format):\n"
                        + "   - Import Data: Allows importing CSV data into the application.\n"
                        + "   - Export Data: Enables exporting data to a CSV file.\n"
                        + "   - Log Out: Logs out the current user from the admin panel.\n"
                        + "   - Exit: Closes the application.\n\n"
                        + "Subject Menu:\n"
                        + "   - Start Editor: Initiates an editor for managing subjects.\n\n"
                        + "Overview Menu:\n"
                        + "   - Student Overview: Displays an overview of student data.\n"
                        + "   - Professor Overview: Displays an overview of professor data.\n"
        );
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        leftPanel.add(new JScrollPane(textArea), BorderLayout.CENTER);
        JPanel studentPanel = new JPanel();
        studentPanel.setLayout(new GridBagLayout());
        studentPanel.setBorder(BorderFactory.createTitledBorder("Student Registration"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        studentPanel.add(new JLabel("Name:"), gbc);
        gbc.gridy++;
        studentPanel.add(new JLabel("Surname:"), gbc);

        // Unique ID for student
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        studentUniqueIdLabel = new JLabel("Unique ID:");
        studentPanel.add(studentUniqueIdLabel, gbc);

        gbc.gridx = 1;
        studentUniqueIdField = new JTextField(20);
        studentPanel.add(studentUniqueIdField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        studentPanel.add(registerStudentButton, gbc); // Register button in the first column
        gbc.gridy++;
        studentPanel.add(undoStudentButton, gbc); // Undo button in the second column

        gbc.gridx = 1; // Move to the second column
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        studentNameField.setPreferredSize(new Dimension(200, 25));  // Adjust width and height
        studentPanel.add(studentNameField, gbc);
        gbc.gridy++;
        studentSurnameField.setPreferredSize(new Dimension(200, 25));  // Adjust width and height
        studentPanel.add(studentSurnameField, gbc);

        JPanel professorPanel = new JPanel();
        professorPanel.setLayout(new GridBagLayout());
        professorPanel.setBorder(BorderFactory.createTitledBorder("Professor Registration"));
        gbc = new GridBagConstraints(); // Reset GridBagConstraints for the professor panel

        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 0;
        gbc.gridy = 0;
        professorPanel.add(new JLabel("Name:"), gbc);
        gbc.gridy++;
        professorPanel.add(new JLabel("Surname:"), gbc);

        // Unique ID for professor
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        professorUniqueIdLabel = new JLabel("Unique ID:");
        professorPanel.add(professorUniqueIdLabel, gbc);

        gbc.gridx = 1;
        professorUniqueIdField = new JTextField(20);
        professorPanel.add(professorUniqueIdField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        professorPanel.add(registerProfessorButton, gbc); // Register button in the first column
        gbc.gridy++;
        professorPanel.add(undoProfessorButton, gbc); // Undo button in the second column

        gbc.gridx = 1; // Move to the second column
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        professorNameField.setPreferredSize(new Dimension(200, 25));  // Adjust width and height
        professorPanel.add(professorNameField, gbc);
        gbc.gridy++;
        professorSurnameField.setPreferredSize(new Dimension(200, 25));  // Adjust width and height
        professorPanel.add(professorSurnameField, gbc);

        JPanel rightPanel = new JPanel(new GridLayout(2, 1, 0, 10));
        rightPanel.add(studentPanel);
        rightPanel.add(professorPanel);

        setLayout(new BorderLayout());
        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.CENTER);
    }

    public void resetFields() {
        studentNameField.setText("");
        studentSurnameField.setText("");
        professorNameField.setText("");
        professorSurnameField.setText("");
        studentUniqueIdField.setText("");
        professorUniqueIdField.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (adminPanelActionListener != null) {
            String name;
            String surname;
            String uniqueID;
            if (e.getActionCommand().equals("register_student")) {
                name = studentNameField.getText();
                surname = studentSurnameField.getText();
                uniqueID = studentUniqueIdField.getText();
            } else if (e.getActionCommand().equals("register_professor")) {
                name = professorNameField.getText();
                surname = professorSurnameField.getText();
                uniqueID = professorUniqueIdField.getText();
            } else if (e.getActionCommand().equals("undo_student")) {

                name = e.getActionCommand();
                surname = e.getActionCommand();
                uniqueID = e.getActionCommand();

            } else if (e.getActionCommand().equals("undo_professor")) {

                name = e.getActionCommand();
                surname = e.getActionCommand();
                uniqueID = e.getActionCommand();

            } else {
                throw new IllegalStateException("Unexpected value: " + e.getActionCommand());
            }

            AdminPanelEvent adminPanelEvent = new AdminPanelEvent(this, name, surname, uniqueID, e.getActionCommand());
            adminPanelActionListener.adminPanelEventOccured(adminPanelEvent);
        }
    }

    public void setAdminPanelEventListener(AdminPanelActionListener adminPanelActionListener) {
        this.adminPanelActionListener = adminPanelActionListener;
    }
}
