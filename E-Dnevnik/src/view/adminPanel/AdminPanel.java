package view.adminPanel;

import model.Credentials;

import javax.swing.*;
import java.awt.*;
import java.util.Stack;

public class AdminPanel extends JPanel {

    private JTextField studentNameField;
    private JTextField studentSurnameField;
    private JTextField professorNameField;
    private JTextField professorSurnameField;
    private JButton registerStudentButton;
    private JButton registerProfessorButton;
    private JButton undoStudentButton;
    private JButton undoProfessorButton;

    private final Stack<Credentials> studentCredentials = new Stack<>();
    private final Stack<Credentials> professorCredentials = new Stack<>();

    public AdminPanel() {

        initializeComponents();
        layoutComponents();
        activateComponents();
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

    private void activateComponents() {
        registerStudentButton.addActionListener(e -> {
            String name = studentNameField.getText();
            String surname = studentSurnameField.getText();
            if (name.isEmpty() || surname.isEmpty()) {
                JOptionPane.showMessageDialog(AdminPanel.this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(AdminPanel.this, "Student registered successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        registerProfessorButton.addActionListener(e -> {
            String name = professorNameField.getText();
            String surname = professorSurnameField.getText();
            if (name.isEmpty() || surname.isEmpty()) {
                JOptionPane.showMessageDialog(AdminPanel.this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(AdminPanel.this, "Professor registered successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        undoStudentButton.addActionListener(e -> {
            if (studentCredentials.isEmpty()) {
                JOptionPane.showMessageDialog(AdminPanel.this, "No student to undo.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                studentCredentials.pop();
                JOptionPane.showMessageDialog(AdminPanel.this, "Last added student removed.", "Undo", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        undoProfessorButton.addActionListener(e -> {
            if (professorCredentials.isEmpty()) {
                JOptionPane.showMessageDialog(AdminPanel.this, "No professor to undo.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                professorCredentials.pop();
                JOptionPane.showMessageDialog(AdminPanel.this, "Last added professor removed.", "Undo", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

}
