package view.adminPanel;

import controller.Controller;
import model.StudentCredentials;
import model.ProfessorCredentials;
import view.loginPanel.LoginFrame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class AdminFrame extends JFrame {

    private AdminPanel adminPanel;
    private AdminMenuBar adminMenuBar;
    private OverviewPopup overviewPopup;
    private SubjectEditorPopup subjectEditorPopup;

    private final String JSON_FILE_PATH = "C:\\Users\\jaksa\\Desktop\\NOOP - PROJEKT\\E-Dnevnik\\E-Dnevnik\\src\\data_files\\subjects.json";

    private final Controller controller = Controller.getInstance();

    public AdminFrame() {
        setTitle("ADMIN PANEL");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(true);

        initializeComponents();
        layoutComponents();
        activateComponents();
    }

    private void initializeComponents() {
        adminPanel = new AdminPanel();
        adminMenuBar = new AdminMenuBar();
        overviewPopup = new OverviewPopup();
        subjectEditorPopup = new SubjectEditorPopup();
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
            if (actionCommand.equals("logOut")) {
                int option = JOptionPane.showConfirmDialog(AdminFrame.this, "Are you sure you want to log out?", "Log Out", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {
                    new LoginFrame();
                    controller.logOut();
                    update();
                    dispose();
                }
            }
            if (actionCommand.equals("student_overview")) {
                overviewPopup.showOverview(controller.getStudentData(), "Student Overview");
            }
            if (actionCommand.equals("professor_overview")) {
                overviewPopup.showOverview(controller.getTeacherData(), "Professor Overview");
            }
            if (actionCommand.equals("startEditor")) {
                HashMap<String, String> data = controller.readFromFile(JSON_FILE_PATH);
                subjectEditorPopup.teacherDataUpdate(controller.getTeacherData());
                subjectEditorPopup.fillTable(controller.getTeacherData());
                subjectEditorPopup.fillJList(data);
                subjectEditorPopup.show(this, 100, -50);
            }
        });
        adminPanel.setAdminPanelEventListener(actionCommand -> {
            if (actionCommand.getActionCommand().equals("register_student")) {
                String name = actionCommand.getName();
                String surname = actionCommand.getSurname();
                String uniqueID = actionCommand.getUniqueID();
                if (!validValueCheck(name, surname, uniqueID)) {
                    System.out.println("Issue with student registration.");
                }  else {
                    controller.addEntity(new StudentCredentials(name, surname, uniqueID));
                    JOptionPane.showMessageDialog(this, "Student registered successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    System.out.println(controller.getStudentData());
                    resetFields();
                }
            }
            if (actionCommand.getActionCommand().equals("undo_student")) {
                if (controller.getStudentData().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "No students to remove.", "Undo", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    controller.removeLastAddedEntity(StudentCredentials.class);
                    JOptionPane.showMessageDialog(this, "Last student removed.", "Undo", JOptionPane.INFORMATION_MESSAGE);
                    System.out.println(controller.getStudentData());
                }
            }
            if (actionCommand.getActionCommand().equals("register_professor")) {
                String name = actionCommand.getName();
                String surname = actionCommand.getSurname();
                String uniqueID = actionCommand.getUniqueID();
                if (!validValueCheck(name, surname, uniqueID)) {
                    System.out.println("Issue with professor registration.");
                } else {
                    controller.addEntity(new ProfessorCredentials(name, surname, uniqueID));
                    JOptionPane.showMessageDialog(this, "Professor registered successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    System.out.println(controller.getTeacherData());
                    resetFields();
                }
            }
            if (actionCommand.getActionCommand().equals("undo_professor")) {
                if (controller.getTeacherData().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "No professors to remove.", "Undo", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    controller.removeLastAddedEntity(ProfessorCredentials.class);
                    JOptionPane.showMessageDialog(this, "Last added professor removed.", "Undo", JOptionPane.INFORMATION_MESSAGE);
                    System.out.println(controller.getTeacherData());
                }
            }
        });
        subjectEditorPopup.setSubjectEditorActionListener(actionCommand -> {
            if (actionCommand.getActionCommand().equals("assign")) {
                controller.addSubjectToProfessor(actionCommand.getProfessor(), actionCommand.getSubjects());
                System.out.println("////////////////////////////////////////////////");
                System.out.println(controller.getSubjectAllocationMap());
            }
            if (actionCommand.getActionCommand().equals("undo")) {
                controller.removeSubjectFromProfessor(actionCommand.getProfessor(), actionCommand.getSubjects());
            }
        });
    }

    private boolean validValueCheck(String name, String surname, String uniqueID) {
        if (name.isEmpty() || surname.isEmpty() || uniqueID.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (!isValidName(name) || !isValidName(surname)) {
            JOptionPane.showMessageDialog(this, "Invalid name or surname format.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (isIDInUse(uniqueID)) {
            JOptionPane.showMessageDialog(this, "ID already in use.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            return true;
        }
    }

    private boolean isValidName(String name) {
        return name.matches("[a-zA-Z]+");
    }

    private boolean isIDInUse(String uniqueID) {
        return controller.getStudentData().stream().anyMatch(student -> student.getUniqueID().equals(uniqueID)) ||
                controller.getTeacherData().stream().anyMatch(teacher -> teacher.getUniqueID().equals(uniqueID));
    }

    private void resetFields() {
        adminPanel.resetFields();
    }

    public void update() {
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println("Data created in " + getClass().getSimpleName() + " :");
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println("Student Data:");
        System.out.println(controller.getStudentData());
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println("Teacher Data:");
        System.out.println(controller.getTeacherData());
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - -");
    }


}
