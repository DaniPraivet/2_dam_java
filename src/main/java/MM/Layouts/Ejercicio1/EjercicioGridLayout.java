package MM.Layouts.Ejercicio1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class EjercicioGridLayout extends JFrame {
    GridLayout grid = new GridLayout(2,2);
    static JButton btnUno = new JButton("Uno");
    JButton btnDos = new JButton("Dos");
    JLabel lblUno = new JLabel("Uno");
    JTextField txtUno = new JTextField(50);
    JPanel panelPrincipal = new JPanel();
    private int contador = 0;

    public EjercicioGridLayout() {
        initConfig();
    }

    void initConfig() {
        btnDos.addActionListener(e -> System.exit(0));
        btnUno.addActionListener(this::clickBtnUno);
        btnUno.setFont(new Font("Arial", Font.BOLD, 40));
        panelPrincipal.setLayout(grid);
        panelPrincipal.add(lblUno);
        panelPrincipal.add(txtUno);
        panelPrincipal.add(btnUno);
        panelPrincipal.add(btnDos);
        this.add(panelPrincipal, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        EjercicioGridLayout window = new EjercicioGridLayout();
        window.setTitle("Prueba 1");
        window.setSize(200, 200);
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    void clickBtnUno(ActionEvent e) {
        contador++;
        btnUno.setText(Integer.toString(contador));
    }

}
