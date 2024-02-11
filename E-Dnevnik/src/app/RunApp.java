package app;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import view.loginPanel.LoginFrame;

import javax.swing.*;

public class RunApp {
    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(new FlatMacDarkLaf());

        SwingUtilities.invokeLater(() -> {
            LoginFrame loginFrame = new LoginFrame();
        });
    }
}
