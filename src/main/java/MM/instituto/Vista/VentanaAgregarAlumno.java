// VentanaAgregarAlumno.java
package MM.instituto.Vista;

import javax.swing.*;
import java.awt.*;

public class VentanaAgregarAlumno extends JFrame {
    private VentanaPrincipal ventanaPrincipal;
    private JTextField txtNombre, txtCarnet;
    private JButton btnGuardar, btnCancelar;

    public VentanaAgregarAlumno(VentanaPrincipal ventanaPrincipal) {
        this(ventanaPrincipal, null);
    }

    public VentanaAgregarAlumno(VentanaPrincipal ventanaPrincipal, String id) {
        this.ventanaPrincipal = ventanaPrincipal;
        setTitle("Agregar Alumno");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(ventanaPrincipal);

        // Componentes
        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panel.add(txtNombre);

        panel.add(new JLabel("Carnet de Conducir:"));
        txtCarnet = new JTextField();
        panel.add(txtCarnet);

        btnGuardar = new JButton("Guardar");
        btnCancelar = new JButton("Cancelar");

        panel.add(btnGuardar);
        panel.add(btnCancelar);

        add(panel);

        // Acciones
        btnGuardar.addActionListener(e -> guardarAlumno());
        btnCancelar.addActionListener(e -> dispose());
    }

    private void guardarAlumno() {
        String nombre = txtNombre.getText();
        String carnet = txtCarnet.getText();

        if (nombre.isEmpty() || carnet.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Completa todos los campos.");
            return;
        }

        // Simular guardado (en una app real, aquí iría la conexión a BD)
        JOptionPane.showMessageDialog(this, "Alumno guardado exitosamente.");

        dispose();

        // Simular datos actualizados
        Object[][] nuevosDatos = {
                {1, nombre, "Apellido Ejemplo", carnet, "01/01/2000"},
                {2, "María", "García", "87654321B", "22/07/2001"}
        };

        // Actualizar tabla principal
        ventanaPrincipal.refrescarTablaAlumnos(nuevosDatos);
    }

}
