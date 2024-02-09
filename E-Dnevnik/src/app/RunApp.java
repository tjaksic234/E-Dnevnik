package app;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import view.MainFrame;

import javax.swing.*;

public class RunApp {
    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(new FlatMacLightLaf());

        SwingUtilities.invokeLater(() -> {
            MainFrame mainFrame = new MainFrame();
        });
    }
}
