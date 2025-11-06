package MM.JavaSwing.Ejercicio5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

public class Main extends JFrame {
    ButtonGroup grupo;
    JRadioButton jrb1;
    JRadioButton jrb2;
    JRadioButton jrb3;
    JRadioButton jrb4;
    JLabel jlb1;
    JPanel panel = (JPanel) this.getContentPane();

    Main() {
     initGUI();
     initEvent();
    }

    private void initGUI() {
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.setFont(new Font("Arial", Font.BOLD, 18));
        grupo = new ButtonGroup();
        jrb1 = new JRadioButton("Gato");
        jrb2 = new JRadioButton("Perro");
        jrb3 = new JRadioButton("Conejo");
        jrb4 = new JRadioButton("Pato");
        jlb1 = new JLabel("Texto");

        grupo.add(jrb1);
        grupo.add(jrb2);
        grupo.add(jrb3);
        grupo.add(jrb4);

        panel.add(jrb1);
        panel.add(jrb2);
        panel.add(jrb3);
        panel.add(jrb4);
        panel.add(jlb1);
    }

    private void initEvent() {
        obtenerTextoDelBotonSeleccionado();
    }

    private void obtenerTextoDelBotonSeleccionado() {
        jrb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jrb1.isSelected()) {
                    jlb1.setText("Has seleccionado la opción: " + jrb1.getText());
                }
            }
        });
        jrb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jrb2.isSelected()) {
                    jlb1.setText("Has seleccionado la opción: " + jrb2.getText());
                }
            }
        });
        jrb3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jrb3.isSelected()) {
                    jlb1.setText("Has seleccionado la opción: " + jrb3.getText());
                }
            }
        });
        jrb4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jrb4.isSelected()) {
                    jlb1.setText("Has seleccionado la opción: " + jrb4.getText());
                }
            }
        });
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        m.setContentPane(m.panel);
        m.setVisible(true);
        m.setSize(600, 400);
    }
}
