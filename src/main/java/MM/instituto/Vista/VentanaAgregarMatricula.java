package MM.instituto.Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaAgregarMatricula extends JFrame {
    private JComboBox<String> cmbAlumno;
    private JComboBox<String> cmbAsignatura;
    private JButton btnGuardar;
    private JButton btnCancelar;
    private Ventana ventanaPrincipal;

    public VentanaAgregarMatricula(Ventana ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;

        initComponentes();
        configurarVentana();
        cargarDatos();
    }

    private void initComponentes() {
        setTitle("Agregar Matrícula");
        setLayout(new BorderLayout());

        // Panel de formulario
        JPanel panelForm = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        // Alumno
        gbc.gridx = 0; gbc.gridy = 0;
        panelForm.add(new JLabel("Alumno:"), gbc);
        gbc.gridx = 1;
        cmbAlumno = new JComboBox<>();
        panelForm.add(cmbAlumno, gbc);

        // Asignatura
        gbc.gridx = 0; gbc.gridy = 1;
        panelForm.add(new JLabel("Asignatura:"), gbc);
        gbc.gridx = 1;
        cmbAsignatura = new JComboBox<>();
        panelForm.add(cmbAsignatura, gbc);

        // Botones
        JPanel panelBotones = new JPanel();
        btnGuardar = new JButton("Guardar");
        btnCancelar = new JButton("Cancelar");

        panelBotones.add(btnGuardar);
        panelBotones.add(btnCancelar);

        add(panelForm, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        // Eventos
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarMatricula();
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    private void configurarVentana() {
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(ventanaPrincipal);
        setResizable(false);
    }

    private void cargarDatos() {
        // Aquí cargarías los datos desde la BD
        // cmbAlumno.addItem("Alumno 1");
        // cmbAlumno.addItem("Alumno 2");
        // cmbAsignatura.addItem("Asignatura 1");
        // cmbAsignatura.addItem("Asignatura 2");
    }

    private void guardarMatricula() {
        String alumno = (String) cmbAlumno.getSelectedItem();
        String asignatura = (String) cmbAsignatura.getSelectedItem();

        if (alumno == null || asignatura == null) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar alumno y asignatura", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Aquí iría la lógica para guardar en la BD
        JOptionPane.showMessageDialog(this, "Matrícula guardada correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        dispose();
    }
}
