package MM.JavaSwing.Ejercicio3;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main extends JFrame {

    /*
    Crear un marco JFrame, que en su constructor,
    el componente de este JFrame note los eventos
    de ratón sobre él

    Eventos de MouseListener y
    MouseMotionListener

    En el método de mouseClicked detectar si se ha
    producido un doble click con el ratón.

    Cada vez que se haga algún evento de ratón
    sobre él, mostrará lo que ha pasado.
     */

    Main() {
        initGUI();
    }

    void initGUI() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2 && e.getButton() == MouseEvent.BUTTON1) {
                    System.out.println("Doble click");
                } else {
                    System.out.println("Botón presionado: " + e.getButton());
                    System.out.println("Posición: " + e.getX() + "," + e.getY());
                }
            }
        });

        setSize(800, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Main();
    }
}
