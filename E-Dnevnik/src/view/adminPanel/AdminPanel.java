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

        // Add text inside the placeholder information border
        JLabel placeholderLabel = new JLabel("This is a placeholder for FAQs.");
        placeholderLabel.setHorizontalAlignment(SwingConstants.CENTER);
        leftPanel.add(placeholderLabel, BorderLayout.CENTER);

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

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        studentNameField.setPreferredSize(new Dimension(130, 25));  // Adjust width
        studentPanel.add(studentNameField, gbc);
        gbc.gridy++;
        studentSurnameField.setPreferredSize(new Dimension(130, 25));  // Adjust width
        studentPanel.add(studentSurnameField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        registerStudentButton.setPreferredSize(new Dimension(150, 30));  // Adjust size
        studentPanel.add(registerStudentButton, gbc);

        gbc.gridy++;
        undoStudentButton.setPreferredSize(new Dimension(150, 30));  // Adjust size
        studentPanel.add(undoStudentButton, gbc);

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

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        professorNameField.setPreferredSize(new Dimension(130, 25));  // Adjust width
        professorPanel.add(professorNameField, gbc);
        gbc.gridy++;
        professorSurnameField.setPreferredSize(new Dimension(130, 25));  // Adjust width
        professorPanel.add(professorSurnameField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        registerProfessorButton.setPreferredSize(new Dimension(150, 30));  // Adjust size
        professorPanel.add(registerProfessorButton, gbc);

        gbc.gridy++;
        undoProfessorButton.setPreferredSize(new Dimension(150, 30));  // Adjust size
        professorPanel.add(undoProfessorButton, gbc);

        JPanel rightPanel = new JPanel(new GridLayout(2, 1, 0, 10));
        rightPanel.add(studentPanel);
        rightPanel.add(professorPanel);

        setLayout(new BorderLayout());
        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (adminPanelActionListener != null) {
            String name = studentNameField.getText();
            String surname = studentSurnameField.getText();
            AdminPanelEvent adminPanelEvent = new AdminPanelEvent(this, name, surname, e.getActionCommand());
            adminPanelActionListener.adminPanelEventOccured(adminPanelEvent);
        }
    }

    public void setAdminPanelEventListener(AdminPanelActionListener adminPanelActionListener) {
        this.adminPanelActionListener = adminPanelActionListener;
    }
}
