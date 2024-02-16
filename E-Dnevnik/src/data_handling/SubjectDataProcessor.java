package data_handling;

import java.util.HashMap;

public interface SubjectDataProcessor {

    HashMap<String,String> readFromFile(String pathToFile);

    void listAllRecords(HashMap<String,String> dataRecord);

}
