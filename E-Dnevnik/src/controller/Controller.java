package controller;

import model.DataManager;
import model.StudentCredentials;
import model.TeacherCredentials;
import observer.ObservablePanelHelper;

import java.util.ArrayList;

public class Controller extends ObservablePanelHelper {

    private DataManager<StudentCredentials> studentDataManager;
    private DataManager<TeacherCredentials> teacherDataManager;

    public Controller() {
        this.studentDataManager = new DataManager<>();
        this.teacherDataManager = new DataManager<>();
    }

    public <E> void addEntity(E data) {
        if (data instanceof StudentCredentials) {
            studentDataManager.addEntity((StudentCredentials) data);
        } else if (data instanceof TeacherCredentials) {
            teacherDataManager.addEntity((TeacherCredentials) data);
        } else {
            System.out.println("Invalid data type.");
        }
        notifyObservers();
    }

    public <E> void removeEntity(E data) {
        if (data instanceof StudentCredentials) {
            studentDataManager.removeEntity((StudentCredentials) data);
        } else if (data instanceof TeacherCredentials) {
            teacherDataManager.removeEntity((TeacherCredentials) data);
        } else {
            System.out.println("Invalid data type.");
        }
        notifyObservers();
    }

    public ArrayList<StudentCredentials> getStudentData() {
        return studentDataManager.getData();
    }

    public ArrayList<TeacherCredentials> getTeacherData() {
        return teacherDataManager.getData();
    }

}