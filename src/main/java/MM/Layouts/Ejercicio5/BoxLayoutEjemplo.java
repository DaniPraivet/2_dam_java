package MM.Layouts.Ejercicio5;

import javax.swing.*;
import java.awt.*;

public class BoxLayoutEjemplo extends JFrame{
    JPanel panelContenedor;
    BoxLayout layout;
    public BoxLayoutEjemplo() {
        initGUI();
    }

    private void initGUI() {
        panelContenedor = (JPanel) getContentPane();
        JButton[] botones = new JButton[5];
        layout = new BoxLayout(panelContenedor, BoxLayout.Y_AXIS);
        panelContenedor.setLayout(layout);
        for (int i = 0; i < botones.length; i++) {
            botones[i] = new JButton("Boton " + i);
            botones[i].setAlignmentX(RIGHT_ALIGNMENT);
            panelContenedor.add(botones[i]);
        }
    }

    public static void main(String[] args) {
        BoxLayoutEjemplo box = new BoxLayoutEjemplo();
        box.setVisible(true);
        box.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        box.setSize(400,400);
    }
}
