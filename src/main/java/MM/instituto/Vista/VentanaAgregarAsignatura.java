package MM.instituto.Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaAgregarAsignatura extends JFrame {
    private JTextField txtNombre;
    private JTextField txtCodigo;
    private JButton btnGuardar;
    private JButton btnCancelar;
    private Ventana ventanaPrincipal;

    public VentanaAgregarAsignatura(Ventana ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;

        initComponentes();
        configurarVentana();
    }

    private void initComponentes() {
        setTitle("Agregar Asignatura");
        setLayout(new BorderLayout());

        // Panel de formulario
        JPanel panelForm = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        // Nombre
        gbc.gridx = 0; gbc.gridy = 0;
        panelForm.add(new JLabel("Nombre:"), gbc);
        gbc.gridx = 1;
        txtNombre = new JTextField(20);
        panelForm.add(txtNombre, gbc);

        // Código
        gbc.gridx = 0; gbc.gridy = 1;
        panelForm.add(new JLabel("Código:"), gbc);
        gbc.gridx = 1;
        txtCodigo = new JTextField(20);
        panelForm.add(txtCodigo, gbc);

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
                guardarAsignatura();
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

    private void guardarAsignatura() {
        String nombre = txtNombre.getText().trim();
        String codigo = txtCodigo.getText().trim();

        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El nombre es obligatorio", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Aquí iría la lógica para guardar en la BD
        JOptionPane.showMessageDialog(this, "Asignatura guardada correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        dispose();
    }
}
