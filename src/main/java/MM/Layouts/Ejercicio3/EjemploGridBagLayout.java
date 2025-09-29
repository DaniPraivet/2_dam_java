package MM.Layouts.Ejercicio3;

import javax.swing.*;
import java.awt.*;


public class EjemploGridBagLayout extends JFrame {
    JPanel pnContenedor;

    EjemploGridBagLayout() {
        initGUI();
    }

    private void initGUI() {
        pnContenedor = (JPanel) this.getContentPane();
        GridBagLayout gbl = new GridBagLayout();
        pnContenedor.setLayout(gbl);
    }

    public static void main(String[] args) {
        EjemploGridBagLayout g = new EjemploGridBagLayout();
        g.setVisible(true);
        g.setSize(800, 600);
    }
}
