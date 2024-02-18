package data_handling;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.util.ArrayList;

public class DataHandler {

    private JFileChooser jFileChooser;
    private FileNameExtensionFilter csvFilter;
    private SaveLoadStrategy saveLoadStrategy;

    public DataHandler() {
        this.jFileChooser = new JFileChooser();
        this.csvFilter = new FileNameExtensionFilter("CSV files", "csv");
    }

    public <E> void saveData(ArrayList<E> data) {
        jFileChooser.setFileFilter(csvFilter);

        int result = jFileChooser.showSaveDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jFileChooser.getSelectedFile();
            FileNameExtensionFilter selectedFilter = (FileNameExtensionFilter) jFileChooser.getFileFilter();
            String[] extensions = selectedFilter.getExtensions();

            //checks for proper file initialization
            if (!selectedFile.getName().endsWith("." + extensions[0])) {
                selectedFile = new File(selectedFile.getAbsolutePath() + "." + extensions[0]);
            }

            //Checks if the file with that name already exists
            if (selectedFile.exists()) {
                int overwriteResult = JOptionPane.showConfirmDialog(null,
                        "File already exists. Do you want to overwrite?",
                        "Confirm Overwrite", JOptionPane.YES_NO_OPTION);

                if (overwriteResult != JOptionPane.YES_OPTION) {
                    return;
                }
            }

            // Set the correct save strategy
            if (selectedFile.getName().endsWith(".csv")) {
                saveLoadStrategy = new CSVStrategy();
                saveLoadStrategy.save(data, selectedFile.getAbsolutePath());
            } else {
                JOptionPane.showMessageDialog(null,
                        "Unsupported file format.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public <E> ArrayList<E> loadData() {
        jFileChooser.setFileFilter(csvFilter);

        int result = jFileChooser.showOpenDialog(null);
        ArrayList<E> loadedData = new ArrayList<>();

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jFileChooser.getSelectedFile();

            // Set the correct load strategy
            if (selectedFile.getName().endsWith(".csv")) {
                saveLoadStrategy = new CSVStrategy();
                loadedData = saveLoadStrategy.load(selectedFile.getAbsolutePath());
                return loadedData;
            } else {
                JOptionPane.showMessageDialog(null,
                        "Unsupported file format.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }  else {
            JOptionPane.showMessageDialog(null,
                    "No file selected. Please select a file to load data.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return  loadedData;
    }
}
