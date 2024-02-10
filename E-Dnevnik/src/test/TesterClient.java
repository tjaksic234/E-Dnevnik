package test;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import view.adminPanel.AdminFrame;

import javax.swing.*;

public class TesterClient {
    public static void main(String[] args) throws UnsupportedLookAndFeelException {

        UIManager.setLookAndFeel(new FlatMacDarkLaf());

        SwingUtilities.invokeLater(() -> {
            AdminFrame adminFrame = new AdminFrame();
        });
    }
}
