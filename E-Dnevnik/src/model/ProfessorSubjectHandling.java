package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ProfessorSubjectHandling extends SubjectAllocation {

    @Override
    public void addSubjectToProfessor(Credentials professor, ArrayList<String> subjects) {
        Credentials existingProfessor = null;
        for (Map.Entry<Credentials, ArrayList<String>> entry : subjectAllocationMap.entrySet()) {
            if (entry.getKey().getUniqueID().equals(professor.getUniqueID())) {
                existingProfessor = entry.getKey();
                break;
            }
        }

        if (existingProfessor != null) {
            ArrayList<String> professorSubjects = subjectAllocationMap.get(existingProfessor);
            for (String subject : subjects) {
                if (!professorSubjects.contains(subject)) {
                    professorSubjects.add(subject);
                }
            }
        } else {
            ArrayList<String> professorSubjects = new ArrayList<>(subjects);
            subjectAllocationMap.put(professor, professorSubjects);
        }
    }


    @Override
    public void removeSubjectFromProfessor(Credentials professor, ArrayList<String> subjects) {

        String ID = professor.getUniqueID();
        for (Map.Entry<Credentials, ArrayList<String>> entry : subjectAllocationMap.entrySet()) {
            if (entry.getKey().getUniqueID().equals(ID)) {
                ArrayList<String> professorSubjects = entry.getValue();
                if (!professorSubjects.isEmpty()) {
                    for (String subjectToRemove : subjects) {
                        professorSubjects.remove(subjectToRemove);
                    }
                    System.out.println("Remaining subjects of the professor: ");
                    System.out.println(professorSubjects);
                } else {
                    System.out.println("The professor's subject list is empty.");
                }
            }
        }
    }

    @Override
    public HashMap<Credentials, ArrayList<String>> getSubjectAllocationMap() {
        return subjectAllocationMap;
    }

    @Override
    public void setSubjectAllocationMap(HashMap<Credentials, ArrayList<String>> subjectAllocationMap) {
        this.subjectAllocationMap = subjectAllocationMap;
    }
}
