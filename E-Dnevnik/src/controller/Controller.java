package controller;

import model.DataManager;
import model.StudentCredentials;
import model.ProfessorCredentials;

import java.util.ArrayList;

public class Controller {

    private DataManager<StudentCredentials> studentDataManager;
    private DataManager<ProfessorCredentials> teacherDataManager;

    private static Controller instance;

    public Controller() {
        this.studentDataManager = new DataManager<>();
        this.teacherDataManager = new DataManager<>();
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public <E> void addEntity(E data) {
        if (data instanceof StudentCredentials) {
            studentDataManager.addEntity((StudentCredentials) data);
        } else if (data instanceof ProfessorCredentials) {
            teacherDataManager.addEntity((ProfessorCredentials) data);
        } else {
            System.out.println("Invalid data type in method addEntity(E data).");
        }
    }

    public <E> void removeEntity(E data) {
        if (data instanceof StudentCredentials) {
            studentDataManager.removeEntity((StudentCredentials) data);
        } else if (data instanceof ProfessorCredentials) {
            teacherDataManager.removeEntity((ProfessorCredentials) data);
        } else {
            System.out.println("Invalid data type in method removeEntity(E data).");
        }
    }

    public void removeLastAddedEntity(Class<?> dataType) {
        if (dataType.equals(StudentCredentials.class)) {
            studentDataManager.removeLastAddedEntity();
        } else if (dataType.equals(ProfessorCredentials.class)) {
            teacherDataManager.removeLastAddedEntity();
        } else {
            System.out.println("Invalid data type in method removeLastAddedEntity(Class<?> dataType).");
        }
    }

    public ArrayList<StudentCredentials> getStudentData() {
        return studentDataManager.getData();
    }

    public ArrayList<ProfessorCredentials> getTeacherData() {
        return teacherDataManager.getData();
    }

    public void logOut() {
        System.out.println("Logging out...");
    }

}