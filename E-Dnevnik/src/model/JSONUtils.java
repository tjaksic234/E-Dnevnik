package model;


import com.google.gson.*;


import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

public class JSONUtils implements SubjectDataProcessor {

    @Override
    public HashMap<String, String> readFromFile(String pathToFile) {
        HashMap<String, String> dataMap = new HashMap<>();

        try (Reader reader = new FileReader(pathToFile)) {
            Gson gson = new Gson();
            JsonElement jsonElement = gson.fromJson(reader, JsonElement.class);

            // Check if the JSON element is an object
            if (jsonElement.isJsonObject()) {
                JsonObject jsonObject = jsonElement.getAsJsonObject();

                // Check if the "subjects" key exists
                if (jsonObject.has("subjects")) {
                    JsonArray subjectsArray = jsonObject.getAsJsonArray("subjects");

                    // Iterate over the elements in the "subjects" array
                    for (JsonElement element : subjectsArray) {
                        // Convert each element to a JSON object
                        JsonObject subjectObject = element.getAsJsonObject();
                        // Iterate over the entries in the JSON object
                        for (var entry : subjectObject.entrySet()) {
                            // Store each entry in the HashMap
                            dataMap.put(entry.getKey(), entry.getValue().getAsString());
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dataMap;
    }


    @Override
    public void listAllRecords(HashMap<String, String> dataRecord) {
        System.out.println("Listing all subjects from the JSON file.");
        for (Map.Entry<String, String> entry : dataRecord.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
