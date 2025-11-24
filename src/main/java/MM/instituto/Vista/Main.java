package MM.instituto.Vista;

import MM.instituto.Vista.VentanaLogin;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Establecer look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getLookAndFeel());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Mostrar ventana de login
        SwingUtilities.invokeLater(() -> {
            new VentanaLogin().setVisible(true);
        });
    }
}
