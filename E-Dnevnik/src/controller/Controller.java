package controller;

import model.JSONUtils;
import model.SubjectDataProcessor;
import model.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Controller {

    private final DataManager<StudentCredentials> studentDataManager;
    private final DataManager<ProfessorCredentials> teacherDataManager;
    private final SubjectAllocation professorSubjectHandling;
    private final SubjectDataProcessor subjectDataProcessor;

    private static Controller instance;

    public Controller() {
        this.studentDataManager = new DataManager<>();
        this.teacherDataManager = new DataManager<>();
        this.professorSubjectHandling = new ProfessorSubjectHandling();
        this.subjectDataProcessor = new JSONUtils();
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    // Data management methods for student and teacher credentials

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
    public void setStudentData(ArrayList<StudentCredentials> data) {
        studentDataManager.setData(data);
    }

    public ArrayList<ProfessorCredentials> getTeacherData() {
        return teacherDataManager.getData();
    }
    public void setTeacherData(ArrayList<ProfessorCredentials> data) {
        teacherDataManager.setData(data);
    }

    // Subject allocation methods for assigning subjects to professors

    public void addSubjectToProfessor(ProfessorCredentials professor, ArrayList<String> subjects) {
        professorSubjectHandling.addSubjectToProfessor(professor, subjects);
    }

    public void removeSubjectFromProfessor(ProfessorCredentials professor, ArrayList<String> subjects) {
        professorSubjectHandling.removeSubjectFromProfessor(professor, subjects);
    }

    public void setSubjectAllocationMap(HashMap<Credentials, ArrayList<String>> subjectAllocationMap) {
        professorSubjectHandling.setSubjectAllocationMap(subjectAllocationMap);
    }

    public HashMap<Credentials, ArrayList<String>> getSubjectAllocationMap() {
        return professorSubjectHandling.getSubjectAllocationMap();
    }

    // Data processing methods for reading and listing subject data from files

    public HashMap<String, String> readFromFile(String pathToFile) {
        return subjectDataProcessor.readFromFile(pathToFile);
    }

    public void listAllRecords(HashMap<String, String> dataRecord) {
        subjectDataProcessor.listAllRecords(dataRecord);
    }

}