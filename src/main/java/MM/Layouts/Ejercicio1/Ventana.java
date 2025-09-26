package MM.Layouts.Ejercicio1;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {

    JPanel pnNorte = new JPanel();
    JPanel pnSur = new JPanel();
    JPanel pnEste = new JPanel();
    JPanel pnOeste = new JPanel();
    JPanel pnCentro = new JPanel();
    JLabel lblNorte = new JLabel("Norte");
    JLabel lblSur = new JLabel("Sur");
    JLabel lblEste = new JLabel("Este");
    JLabel lblOeste = new JLabel("Oeste");
    JLabel lblCentro = new JLabel("Centro");
    JButton btnNorte1 = new JButton("Norte");
    JButton btnNorte2 = new JButton("Norte");
    JButton btnNorte3 = new JButton("Norte");



    Ventana() {
        initGUI();
    }

    private void initGUI() {
        pnNorte.add(lblNorte, BorderLayout.CENTER);
        pnNorte.add(btnNorte1);
        pnNorte.add(btnNorte2);
        pnNorte.add(btnNorte3);
        pnNorte.setLayout(new FlowLayout(FlowLayout.CENTER, 15,15));
        this.add(pnNorte, BorderLayout.NORTH);

        pnSur.add(lblSur, BorderLayout.CENTER);
        this.add(pnSur, BorderLayout.SOUTH);

        pnEste.add(lblEste, BorderLayout.CENTER);
        this.add(pnEste, BorderLayout.EAST);

        pnOeste.add(lblOeste, BorderLayout.CENTER);
        this.add(pnOeste, BorderLayout.WEST);

        pnCentro.add(lblCentro, BorderLayout.CENTER);
        this.add(pnCentro, BorderLayout.CENTER);
        pnCentro.setBorder(BorderFactory.createBevelBorder(8));
    }

    public static void main(String[] args) {
        Ventana window = new Ventana();
        // Config ventana
        window.setTitle("Prueba 1");
        window.setSize(600, 600);
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
