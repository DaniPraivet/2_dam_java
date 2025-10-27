package MM.JavaSwing.Ejercicio3;

import javax.swing.*;
import java.awt.*;
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
                    System.out.println("Click");
                }

                if (e.getButton() == MouseEvent.BUTTON3) {
                    mostrarMenuEmergente(e.getLocationOnScreen());
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("Mouse pressed");
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("Mouse released");
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                System.out.println("Mouse entered");
            }
            @Override
            public void mouseExited(MouseEvent e) {
                System.out.println("Mouse exited");
            }
        });

        setSize(800, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void mostrarMenuEmergente(Point location) {
        JMenuItem menu1 = new JMenuItem("Abrir");
        JMenuItem menu2 = new JMenuItem("Nuevo");
        JMenuItem menu3 = new JMenuItem("Salir");
        JPopupMenu menu = new JPopupMenu("Menu");
        menu.add(menu1);
        menu.add(menu2);
        menu.add(menu3);
        menu.setLocation(location);
        menu.setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}
