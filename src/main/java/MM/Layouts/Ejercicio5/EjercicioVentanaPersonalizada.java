package MM.Layouts.Ejercicio5;

import javax.swing.*;
import java.awt.*;

public class EjercicioVentanaPersonalizada extends JFrame {
    JPanel panelContenedor;
    JTextArea textArea = new JTextArea();
    JButton btn1 = new JButton("Boton 1"), btn2 = new JButton("Boton 2"), btn3 = new JButton("Boton 3"), btn4 = new JButton("Boton 4");
    JTextField jtf = new JTextField();

    BorderLayout bLayout;
    FlowLayout fLayout;
    BoxLayout bxLayout;

    JPanel pnEste = new JPanel(), pnSur = new JPanel(), pnCentro = new JPanel();


    public EjercicioVentanaPersonalizada() {
        initGUI();
    }
    public void initGUI() {
        panelContenedor = (JPanel) getContentPane();
        bLayout = new BorderLayout();
        panelContenedor.setLayout(bLayout);

        bxLayout = new BoxLayout(pnEste, BoxLayout.Y_AXIS);
        pnEste.setLayout(bxLayout);
        pnEste.add(btn1);
        pnEste.add(btn2);
        pnEste.add(btn3);
        pnSur.setLayout(fLayout);
        pnSur.add(btn4);
        pnSur.add(jtf);
        pnCentro.add(textArea);

        panelContenedor.add(pnEste, BorderLayout.EAST);
        panelContenedor.add(pnSur, BorderLayout.SOUTH);
        panelContenedor.add(pnCentro, BorderLayout.NORTH);
    }
    public static void main(String[] args) {
        EjercicioVentanaPersonalizada w = new EjercicioVentanaPersonalizada();
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        w.setVisible(true);
        w.setSize(800, 600);
        w.setLocationRelativeTo(null);
    }
}
