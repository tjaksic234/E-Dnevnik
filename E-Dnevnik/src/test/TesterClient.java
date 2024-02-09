package test;

import model.DataManager;
import model.StudentCredentials;
import model.TeacherCredentials;

public class TesterClient {
    public static void main(String[] args) {

        DataManager<StudentCredentials> dataManager = new DataManager<>();

        StudentCredentials studentCredentials1 = new StudentCredentials("teo","jaksic");
        StudentCredentials studentCredentials2 = new StudentCredentials("ante","panjkota");

        dataManager.addEntity(studentCredentials1);
        dataManager.addEntity(studentCredentials1);
        dataManager.addEntity(studentCredentials2);

        for (StudentCredentials studentCredentials : dataManager.getData()) {
            System.out.println(studentCredentials.getName() + " " + studentCredentials.getSurname());
        }

        DataManager<TeacherCredentials> teacherCredentialsDataManager = new DataManager<>();
        TeacherCredentials teacherCredentials = new TeacherCredentials("joj","ajme");
        teacherCredentialsDataManager.addEntity(teacherCredentials);
        teacherCredentialsDataManager.removeEntity(teacherCredentials);
        teacherCredentialsDataManager.removeEntity(teacherCredentials);
        System.out.println(teacherCredentialsDataManager.getData().size());
    }
}
