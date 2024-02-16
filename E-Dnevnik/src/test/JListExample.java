package test;

import javax.swing.*;

public class JListExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Create some sample data
            String[] data = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};

            // Create a JList with the sample data
            JList<String> list = new JList<>(data);

            // Add the JList to a JFrame and display it
            JFrame frame = new JFrame("JList Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(new JScrollPane(list)); // Add a scroll pane for large lists
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}

