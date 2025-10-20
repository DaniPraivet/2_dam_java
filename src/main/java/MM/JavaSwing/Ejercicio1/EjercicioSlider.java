package MM.JavaSwing.Ejercicio1;

import javax.swing.*;
import java.awt.*;

public class EjercicioSlider extends JFrame {
    JPanel panelPrincipal;
    JSlider slider =  new JSlider();
    BorderLayout layoutPrincipal =  new BorderLayout();
    JPanel panelNorte = new JPanel();
    JLabel lblValor = new JLabel("50");

    public EjercicioSlider() {
        initGUI();
        initEventos();
    }

    public void initGUI() {
        panelPrincipal = (JPanel) this.getContentPane();
        panelPrincipal.setLayout(layoutPrincipal);
        panelNorte.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));
        panelNorte.add(slider);
        lblValor.setFont(new Font("Arial", Font.BOLD, 48));
        panelNorte.add(lblValor);
        panelPrincipal.add(panelNorte, BorderLayout.NORTH);
    }

    public void initEventos() {
        slider.addChangeListener(e -> lblValor.setText(String.valueOf(slider.getValue())));
    }

    public static void main(String[] args) {
        EjercicioSlider ventana = new EjercicioSlider();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
        ventana.setSize(400, 400);
    }
}
