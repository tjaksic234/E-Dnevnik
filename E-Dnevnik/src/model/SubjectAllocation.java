package model;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class SubjectAllocation {

    protected HashMap<Credentials, ArrayList<String>> subjectAllocationMap;

    protected SubjectAllocation() {
        this.subjectAllocationMap = new HashMap<>();
    }

    public abstract void addSubjectToProfessor(Credentials professor, ArrayList<String> subjects);

    public abstract void removeSubjectFromProfessor(Credentials professor, ArrayList<String> subjects);

    public abstract HashMap<Credentials, ArrayList<String>> getSubjectAllocationMap();

    public abstract void setSubjectAllocationMap(HashMap<Credentials, ArrayList<String>> subjectAllocationMap);
}
