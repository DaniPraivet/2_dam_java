package MM.Layouts.Ejercicio4;

import javax.swing.*;
import java.awt.*;

public class CardLayoutEjemplo extends JFrame {
    JPanel panelContenedor;
    CardLayout layout;
    JPanel panel1 = new JPanel();
    JPanel panel2  = new JPanel();
    JPanel panel3 = new JPanel();

    public CardLayoutEjemplo() {
        initGUI();
    }

    private void initGUI() {
        panelContenedor = (JPanel) this.getContentPane();

        layout = new CardLayout();

        panel1.setBackground(Color.CYAN);
        panel2.setBackground(new Color(0x131313));
        panel3.setBackground(Color.GREEN);

        panelContenedor.setLayout(layout);

        panelContenedor.add(panel1, "Color azul clarito");
        panelContenedor.add(panel2, "Color gris muy oscuro");
        panelContenedor.add(panel3, "Color verde");
    }

    public static void main(String[] args) {
        CardLayoutEjemplo w = new CardLayoutEjemplo();
        w.setVisible(true);
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        w.setSize(800, 600);
        w.setLocationRelativeTo(null);

        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        w.setLocation((d.width - w.getWidth()) / 2, (d.height - w.getHeight()) / 2);
    }
}
