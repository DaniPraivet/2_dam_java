package MM.instituto.Vista;

import MM.instituto.Modelo.TablaAlumnosModel;
import MM.instituto.Modelo.TablaAsignaturasModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.*;
// Repara esta clase

public class Ventana extends JFrame {
    private JTextField usuario;
    private JPasswordField contrasena;
    JPanel panelPrincipal;
    JButton botonPapel;
    JPanel panelConBoton;
    JSplitPane panelDivisorCentral;
    JMenuBar menuBar;
    JMenu menuAlumno, menuAsignatura, menuMatricula, menuVista;
    JCheckBoxMenuItem menuItemVista;
    JMenuItem menuItemAlumno;
    JPanel alumnos;
    JPanel asignatura;
    JPanel matricula;
    JTabbedPane menuInterior;
    ImageIcon iconPapel;
    ImageIcon iconAlumno;
    ImageIcon iconMatricula;
    ImageIcon iconAsignatura;
    JPanel panelTablaAlumnos, panelTablaAsignaturas;


    public Ventana() {
        initGUI();
        iniciarSesion();
    }

    private void iniciarSesion() {
        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));

        // Componentes
        panel.add(new JLabel("Usuario:"));
        usuario = new JTextField();
        panel.add(usuario);

        panel.add(new JLabel("Contraseña:"));
        contrasena = new JPasswordField();
        panel.add(contrasena);

        JButton loginButton = new JButton("Iniciar Sesión");
        loginButton.addActionListener(this::loginAction);
        panel.add(loginButton);
    }

    private void loginAction(ActionEvent e) {
        String username = usuario.getText();
        String password = new String(contrasena.getPassword());

        if (validarLogin(username, password)) {
            initGUI();
        } else {
            JOptionPane.showMessageDialog(this, "Credenciales incorrectas", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean validarLogin(String u, String password) {
        String url = "jdbc:mysql://localhost:3306/tu_basedatos";
        String dbUser = "root";
        String dbPass = "1234";

        String query = "SELECT * FROM usuarios WHERE usuario = ? AND contraseña = ?";

        try (Connection con = DriverManager.getConnection(url, dbUser, dbPass);
             PreparedStatement stmt = con.prepareStatement(query)) {

            ResultSet rs = stmt.executeQuery();
            return rs.next();

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al conectar con la BD", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public void initGUI() {
        // Creamos el primer panel con pestañas
        alumnos = new JPanel();
        asignatura = new JPanel();
        matricula = new JPanel();
        menuInterior = new JTabbedPane();
        panelTablaAlumnos = new JPanel();
        panelTablaAsignaturas = new JPanel();
        // Ajustamos ahora el panel de alumnos
        JTextField txtAlumno = new JTextField("Aquí irá la tabla de alumnos");
        txtAlumno.setEditable(false);
        txtAlumno.setBorder(null);
        txtAlumno.setCursor(null);
        alumnos.add(txtAlumno);

        // Añadimos los iconos que vamos a usar
        iconPapel = new ImageIcon("src/main/java/MM/Layouts/Práctica6/Imagenes/papellapiz.png");
        iconAsignatura = new ImageIcon("src/main/java/MM/Layouts/Práctica6/Imagenes/asignatura.png");
        iconAlumno = new ImageIcon("src/main/java/MM/Layouts/Práctica6/Imagenes/alumno.png");
        iconMatricula = new ImageIcon("src/main/java/MM/Layouts/Práctica6/Imagenes/matricula.png");
        // Ajustamos el tamaño de las imágenes
        Image cambioTamanio =  iconAlumno.getImage().getScaledInstance(48, 48, Image.SCALE_DEFAULT);
        iconAlumno = new ImageIcon(cambioTamanio);

        cambioTamanio = iconAsignatura.getImage().getScaledInstance(48, 48, Image.SCALE_DEFAULT);
        iconAsignatura = new ImageIcon(cambioTamanio);

        cambioTamanio = iconMatricula.getImage().getScaledInstance(48, 48, Image.SCALE_DEFAULT);
        iconMatricula = new ImageIcon(cambioTamanio);

        cambioTamanio = iconPapel.getImage().getScaledInstance(48, 48, Image.SCALE_DEFAULT);
        iconPapel = new ImageIcon(cambioTamanio);
        // Creamos las pestañas
        menuInterior.add("Alumnos", panelTablaAlumnos);
        menuInterior.add("Asignatura", panelTablaAsignaturas);
        menuInterior.add("Matricula", matricula);
        menuInterior.setIconAt(0, iconAlumno);
        menuInterior.setIconAt(1, iconAsignatura);
        menuInterior.setIconAt(2, iconMatricula);
        panelDivisorCentral = new JSplitPane();
        panelDivisorCentral.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        panelDivisorCentral.setDividerSize(1);
        panelDivisorCentral.setDividerLocation(30);
        panelDivisorCentral.setResizeWeight(0.5);
        panelDivisorCentral.setRightComponent(menuInterior);
        panelDivisorCentral.setLeftComponent(new JPanel());

        // Menu superior
        panelConBoton = new JPanel();
        botonPapel = new JButton(iconPapel);
        panelConBoton.add(botonPapel);
        menuBar = new JMenuBar();
        menuAlumno = new JMenu("Alumnos");
        menuAsignatura = new JMenu("Asignatura");
        menuMatricula = new JMenu("Matricula");
        menuVista = new JMenu("Vista");
        menuItemAlumno = new JMenuItem("Añadir alumno");
        menuItemVista = new JCheckBoxMenuItem("Vista alumno");
        menuAlumno.add(menuItemAlumno);
        menuVista.add(menuItemVista);
        menuBar.add(menuAlumno);
        menuBar.add(menuAsignatura);
        menuBar.add(menuMatricula);
        menuBar.add(menuVista);

        // Añadir menú a la parte inferior del panel
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.add(panelDivisorCentral, BorderLayout.CENTER);
        panelPrincipal.add(menuBar, BorderLayout.NORTH);

        iniciarTablaAlumnos();
        iniciarTablaAsignatura();
    }

    private void iniciarTablaAlumnos() {

        TablaAlumnosModel modeloAlumnos = new TablaAlumnosModel();
        JTable tablaAlumnos = new JTable(modeloAlumnos);
        JScrollPane scrollTablaAlumnos = new JScrollPane(tablaAlumnos);
        panelTablaAlumnos.add(scrollTablaAlumnos, BorderLayout.CENTER);
    }

    private void iniciarTablaAsignatura() {
        TablaAsignaturasModel modeloAsignatura = new TablaAsignaturasModel();
        JTable tablaAsignatura = new JTable(modeloAsignatura);
        JScrollPane scrollTablaAsignatura = new JScrollPane(tablaAsignatura);
        panelTablaAsignaturas.add(scrollTablaAsignatura, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        Ventana ventana = new Ventana();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
        ventana.setSize(800, 600);
        ventana.setContentPane(ventana.panelPrincipal);
    }
}
