package data_handling;

import model.Credentials;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVStrategy implements SaveLoadStrategy {

    private static final String HEADER = "Name,Surname,Username,Password,Email,UniqueID";

    @Override
    public <E> void save(E content, String filePath) {
        if (content instanceof List<?> list) {
            if (!list.isEmpty() && list.get(0) instanceof Credentials) {
                try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
                    writer.println(HEADER);
                    for (Object obj : list) {
                        Credentials credentials = (Credentials) obj;
                        writer.println(credentials.getName() + "," +
                                credentials.getSurname() + "," +
                                credentials.getUsername() + "," +
                                credentials.getPassword() + "," +
                                credentials.getEmail() + "," +
                                credentials.getUniqueID());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public <E> E load(String filePath) {
        List<Credentials> credentialsList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            // Skip the header line
            String headerLine = reader.readLine(); // Read the first line
            // Process the rest of the lines as data
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 6) {
                    String name = parts[0];
                    String surname = parts[1];
                    String username = parts[2];
                    String password = parts[3];
                    String email = parts[4];
                    String uniqueID = parts[5];
                    Credentials credentials = new Credentials(name, surname, uniqueID) {
                        // Implement any necessary methods or leave them abstract
                    };
                    credentials.setUsername(username);
                    credentials.setPassword(password);
                    credentials.setEmail(email);
                    credentialsList.add(credentials);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (E) credentialsList;
    }
}
