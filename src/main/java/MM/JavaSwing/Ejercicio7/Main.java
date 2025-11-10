package MM.JavaSwing.Ejercicio7;

import javax.swing.*;
import java.awt.event.*;
public class Main extends JFrame implements ItemListener{
    private JComboBox<String> combo1;
    public Main() {
        setLayout(null);
        combo1 = new JComboBox<String>();
        combo1.setBounds(10,10,80,20);
        add(combo1);
        combo1.addItem("rojo");
        combo1.addItem("verde");
        combo1.addItem("azul");
        combo1.addItem("amarillo");
        combo1.addItem("negro");
        combo1.addItemListener(this);
    }

    public void itemStateChanged(ItemEvent e) {
        if (e.getSource()==combo1) {
            String seleccionado=(String)combo1.getSelectedItem();
            setTitle(seleccionado);
        }
    }

    public static void main(String[] ar) {
        Main ventana = new Main();
        ventana.setBounds(0,0,200,150);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}