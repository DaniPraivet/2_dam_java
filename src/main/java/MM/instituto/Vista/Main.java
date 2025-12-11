package MM.instituto.Vista;

import com.formdev.flatlaf.FlatDarculaLaf;

import javax.swing.*;

/**
 * Clase principal
 */
public class Main {
    /**
     * Aplicamos un nuevo look and feel y abrimos la pestaña de login
     * @param args argumentos adicionales
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatDarculaLaf());
        } catch (Exception e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> {
            new VentanaLogin().setVisible(true);
        });
    }
}
