package listeners.adminPanelListeners;


import model.Credentials;
import model.ProfessorCredentials;

import java.util.ArrayList;
import java.util.EventObject;

public class SubjectEditorEvent extends EventObject {

    private ProfessorCredentials professor;
    private ArrayList<String> subjects;

    private String actionCommand;


    public SubjectEditorEvent(Object source, ProfessorCredentials professor, ArrayList<String> subjects, String actionCommand) {
        super(source);
        this.professor = professor;
        this.subjects = subjects;
        this.actionCommand = actionCommand;
    }

    public ProfessorCredentials getProfessor() {
        return professor;
    }

    public ArrayList<String> getSubjects() {
        return subjects;
    }

    public String getActionCommand() {
        return actionCommand;
    }

    @Override
    public String toString() {
        return "SubjectEditorEvent{" +
                "professor=" + professor +
                ", subjects=" + subjects +
                '}';
    }
}
