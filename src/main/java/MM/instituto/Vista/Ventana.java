package MM.instituto.Vista;

import MM.instituto.Modelo.TablaAlumnosModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Ventana extends JFrame {
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
    JPanel panelTablaAlumnos;


    public Ventana() {
        initGUI();
    }

    public void initGUI() {
        // Creamos el primer panel con pestañas
        alumnos = new JPanel();
        asignatura = new JPanel();
        matricula = new JPanel();
        menuInterior = new JTabbedPane();
        panelTablaAlumnos = new JPanel();
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
        menuInterior.add("Asignatura", asignatura);
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
    }

    private void iniciarTablaAlumnos() {

        TablaAlumnosModel modeloAlumnos = new TablaAlumnosModel();
        JTable tablaAlumnos = new JTable(modeloAlumnos);
        JScrollPane scrollTablaAlumnos = new JScrollPane(tablaAlumnos);
        panelTablaAlumnos.add(scrollTablaAlumnos, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        Ventana ventana = new Ventana();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
        ventana.setSize(800, 600);
        ventana.setContentPane(ventana.panelPrincipal);
    }
}
