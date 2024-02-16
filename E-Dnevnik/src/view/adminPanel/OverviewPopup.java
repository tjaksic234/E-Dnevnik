package view.adminPanel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OverviewPopup {

    // Define the fields you want to display in the overview
    private static final List<String> DISPLAYED_FIELDS = Arrays.asList("name", "surname", "username", "password", "email", "uniqueID");

    public void showOverview(ArrayList<?> dataList, String title) {
        if (dataList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No data available.", title, JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // Get the class type of the first object in the list
        Class<?> classType = dataList.get(0).getClass();

        // Collect declared fields of the class and its superclass (Credentials)
        ArrayList<Field> fields = new ArrayList<>();
        while (classType != null) {
            Field[] declaredFields = classType.getDeclaredFields();
            for (Field field : declaredFields) {
                field.setAccessible(true); // Ensure private fields are accessible
                // Check if the field should be displayed
                if (DISPLAYED_FIELDS.contains(field.getName())) {
                    fields.add(field);
                }
            }
            classType = classType.getSuperclass();
        }

        // Create a two-dimensional array to hold the data for the table
        Object[][] data = new Object[dataList.size()][fields.size()];

        // Populate the data array with object properties
        for (int i = 0; i < dataList.size(); i++) {
            Object obj = dataList.get(i);
            for (int j = 0; j < fields.size(); j++) {
                Field field = fields.get(j);
                try {
                    data[i][j] = field.get(obj);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        // Create column names array
        String[] columnNames = fields.stream().map(Field::getName).toArray(String[]::new);

        // Create a table model with the data
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make all cells non-editable
            }
        };

        // Create the JTable with the table model
        JTable table = new JTable(tableModel);

        // Auto-resize columns to fit content
        for (int i = 0; i < table.getColumnCount(); i++) {
            int maxWidth = 0;

            // Calculate the width of the header cell
            TableCellRenderer headerRenderer = table.getTableHeader().getDefaultRenderer();
            Component headerComp = table.getTableHeader().getTable().prepareRenderer(headerRenderer, 0, i);
            maxWidth = Math.max(headerComp.getPreferredSize().width, maxWidth);

            // Calculate the width of the data cells
            for (int j = 0; j < table.getRowCount(); j++) {
                TableCellRenderer renderer = table.getCellRenderer(j, i);
                Component comp = table.prepareRenderer(renderer, j, i);
                maxWidth = Math.max(comp.getPreferredSize().width, maxWidth);
            }
            table.getColumnModel().getColumn(i).setPreferredWidth(maxWidth + 5); // Add padding
        }

        // Create a JScrollPane to add the table to
        JScrollPane scrollPane = new JScrollPane(table);

        // Create a Remove button
        JButton removeButton = new JButton("Remove");
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the selected row index
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    // Remove row from the table
                    tableModel.removeRow(selectedRow);
                    // Remove corresponding object from the dataList
                    dataList.remove(selectedRow);
                    System.out.println("Removed row " + selectedRow + " from the table.");
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a row to remove.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Add the components to a panel
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(removeButton, BorderLayout.SOUTH);

        // Show the table in a JOptionPane
        JOptionPane.showMessageDialog(null, panel, title, JOptionPane.PLAIN_MESSAGE);
    }
}
