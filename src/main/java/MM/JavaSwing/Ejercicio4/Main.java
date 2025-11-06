package MM.JavaSwing.Ejercicio4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/*
Crear un JFrame que contenga lo siguiente:

En el panel contenedor, le vamos a añadir:

Un botón con texto Prueba

Un JCheckBox

Y un JToggleButton

Se añadirán control de eventos ActionEvent e
ItemEvent a estos componentes que nos indicarán si
ha habido acción sobre ellos y cual es el valor del
componente en ese momento
 */
public class Main extends JFrame {
    JTextField jtf1;
    JCheckBox jcb1;
    JToggleButton jtb1;

    Main() {
        initGUI();
        initEvento();
    }

    void initGUI() {
        this.setLayout(new FlowLayout());
        jtf1 = new JTextField();
        jcb1 = new JCheckBox();
        jtb1 = new JToggleButton();
        this.add(jtb1);
        this.add(jcb1);
        this.add(jtf1);
    }

    private void initEvento() {
        jcb1.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED ||  e.getStateChange() == ItemEvent.DESELECTED) {
                jcb1.setText(jcb1.isSelected() ? "True" : "False");
            }
        });
        jtb1.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED ||  e.getStateChange() == ItemEvent.DESELECTED) {
                jtb1.setText(jtb1.isSelected() ? "True" : "False");
            }
        });
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.setVisible(true);
        m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        m.setSize(400, 400);
    }
}
