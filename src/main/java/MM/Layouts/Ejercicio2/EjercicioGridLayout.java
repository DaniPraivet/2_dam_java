package MM.Layouts.Ejercicio2;

import javax.swing.*;
import java.awt.*;

public class EjercicioGridLayout extends JFrame {
    static JButton[] botones = new JButton[96];

    EjercicioGridLayout(int[] parameters) {
        loadGUI(parameters);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setResizable(false);
        setVisible(true);
    }

    void loadGUI(int[] args) {
        JPanel panelPrincipal = new JPanel();
        GridLayout grid = new GridLayout(args[0], args[1]);
        for (int i = 0; i < botones.length; i++) {
            botones[i] = new JButton(String.valueOf(i));
            panelPrincipal.add(botones[i]);

            add(panelPrincipal);
            panelPrincipal.setLayout(grid);
        }
    }



    public static void main(String[] args) {
        int[] params = {Integer.parseInt(args[0]), Integer.parseInt(args[1])};

        EjercicioGridLayout window = new EjercicioGridLayout(params);
    }
}
