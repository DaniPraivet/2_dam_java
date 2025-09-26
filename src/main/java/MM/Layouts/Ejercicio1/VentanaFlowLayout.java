package MM.Layouts.Ejercicio1;

import javax.swing.*;
import java.awt.*;

public class VentanaFlowLayout extends JFrame {
    JPanel panelCentral = (JPanel) getContentPane();
    JLabel lblEtiqueta = new JLabel("Etiqueta");
    JButton btnEtiqueta = new JButton("Click");
    JTextField txtTexto = new JTextField(30);
    JTextArea  txtArea = new JTextArea(10, 10);

    public VentanaFlowLayout() {
        initGUI();
    }

    private void initGUI() {
        panelCentral.add(lblEtiqueta);
        panelCentral.add(txtTexto);
        panelCentral.add(btnEtiqueta);
        panelCentral.add(txtArea);
        panelCentral.setLayout(new FlowLayout(FlowLayout.CENTER, 15,15));
        
    }

    public static void main(String[] args) {
        VentanaFlowLayout ventana = new VentanaFlowLayout();
        ventana.setSize(600, 600);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
    }
}
