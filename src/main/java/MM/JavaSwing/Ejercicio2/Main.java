package MM.JavaSwing.Ejercicio2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.concurrent.TimeUnit;

public class Main extends JFrame {
    /*
    Vamos a crear un marco JFrame, al que le
    vamos a establecer primero un tamaño de
    400 x 300.

    Añadiendole un ComponentListener a este
    JFrame controlaremos cuando cambia de
    tamaño, escribiendo algun mensaje y
    hallando el tamaño actual
     */

    Main() {
        initGUI();
    }

    void initGUI() {
        setSize(400, 300);
        JLabel titulo = new JLabel(getSize().getWidth() + "x" + getSize().getHeight());
        titulo.setFont(new Font("Arial", Font.BOLD, 48));
        add(titulo, BorderLayout.NORTH);
        addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                titulo.setText(e.getComponent().getWidth()+"x"+e.getComponent().getHeight());
            }
        });
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Main();
    }
}
