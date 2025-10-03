package MM.Layouts.Ejercicio4;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

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

        panel1.setBackground(new Color(19,19,19));
        panel2.setBackground(new Color(13, 13, 13));
        panel3.setBackground(new Color(0,120,0));

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
        while (true) {
            w.hacerCiclo(w);
        }
    }

    private void hacerCiclo(CardLayoutEjemplo w) {
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
            w.setContentPane(panel1);
            TimeUnit.MILLISECONDS.sleep(1000);
            w.setContentPane(panel2);
            System.out.println(panel2.getBackground().toString());
            TimeUnit.MILLISECONDS.sleep(1000);
            w.setContentPane(panel3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
