package MM.instituto.Vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame {
    private JTabbedPane tabbedPane;

    public VentanaPrincipal() {
        setTitle("Sistema Escolar - Ventana Principal");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear el tabbed pane
        tabbedPane = new JTabbedPane();

        // Crear los paneles para cada pestaña
        JPanel panelAlumnos = crearPanelAlumnos();
        JPanel panelAsignaturas = crearPanelAsignaturas();
        JPanel panelMatriculas = crearPanelMatriculas();

        // Agregar pestañas
        tabbedPane.addTab("Alumnos", panelAlumnos);
        tabbedPane.addTab("Asignaturas", panelAsignaturas);
        tabbedPane.addTab("Matrículas", panelMatriculas);

        add(tabbedPane);

        // Menú superior
        crearMenu();
    }

    private void crearMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menuSistema = new JMenu("Sistema");

        JMenuItem menuItemSalir = new JMenuItem("Salir");
        menuItemSalir.addActionListener(e -> System.exit(0));

        menuSistema.add(menuItemSalir);
        menuBar.add(menuSistema);

        setJMenuBar(menuBar);
    }

    private JPanel crearPanelAlumnos() {
        JPanel panel = new JPanel(new BorderLayout());

        // Panel de botones
        JPanel panelBotones = new JPanel(new FlowLayout());
        JButton btnAgregarAlumno = new JButton("Agregar Alumno");
        JButton btnEditarAlumno = new JButton("Editar Alumno");
        JButton btnEliminarAlumno = new JButton("Eliminar Alumno");

        panelBotones.add(btnAgregarAlumno);
        panelBotones.add(btnEditarAlumno);
        panelBotones.add(btnEliminarAlumno);

        // Tabla de alumnos
        String[] columnas = {"ID", "Nombre", "Apellido", "DNI", "Fecha Nacimiento"};
        Object[][] datos = {
                {1, "Juan", "Pérez", "12345678A", "15/03/2000"},
                {2, "María", "García", "87654321B", "22/07/2001"}
        };

        JTable tablaAlumnos = new JTable(datos, columnas);
        JScrollPane scrollPane = new JScrollPane(tablaAlumnos);

        panel.add(panelBotones, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    private JPanel crearPanelAsignaturas() {
        JPanel panel = new JPanel(new BorderLayout());

        // Panel de botones
        JPanel panelBotones = new JPanel(new FlowLayout());
        JButton btnAgregarAsignatura = new JButton("Agregar Asignatura");
        JButton btnEditarAsignatura = new JButton("Editar Asignatura");
        JButton btnEliminarAsignatura = new JButton("Eliminar Asignatura");

        panelBotones.add(btnAgregarAsignatura);
        panelBotones.add(btnEditarAsignatura);
        panelBotones.add(btnEliminarAsignatura);

        // Tabla de asignaturas
        String[] columnas = {"ID", "Nombre", "Créditos", "Profesor"};
        Object[][] datos = {
                {1, "Matemáticas", 6, "Dr. López"},
                {2, "Lengua", 5, "Dra. Martínez"}
        };

        JTable tablaAsignaturas = new JTable(datos, columnas);
        JScrollPane scrollPane = new JScrollPane(tablaAsignaturas);

        panel.add(panelBotones, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    private JPanel crearPanelMatriculas() {
        JPanel panel = new JPanel(new BorderLayout());

        // Panel de botones
        JPanel panelBotones = new JPanel(new FlowLayout());
        JButton btnNuevaMatricula = new JButton("Nueva Matrícula");
        JButton btnEditarMatricula = new JButton("Editar Matrícula");
        JButton btnEliminarMatricula = new JButton("Eliminar Matrícula");

        panelBotones.add(btnNuevaMatricula);
        panelBotones.add(btnEditarMatricula);
        panelBotones.add(btnEliminarMatricula);

        // Tabla de matrículas
        String[] columnas = {"ID", "Alumno", "Asignatura", "Nota", "Fecha"};
        Object[][] datos = {
                {1, "Juan Pérez", "Matemáticas", 8.5, "2023-09-15"},
                {2, "María García", "Lengua", 9.0, "2023-09-15"}
        };

        JTable tablaMatriculas = new JTable(datos, columnas);
        JScrollPane scrollPane = new JScrollPane(tablaMatriculas);

        panel.add(panelBotones, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    // Dentro de VentanaPrincipal.java
    void refrescarTablaAlumnos(Object[][] nuevosDatos) {
        // Buscar el panel de alumnos
        for (int i = 0; i < tabbedPane.getTabCount(); i++) {
            if ("Alumnos".equals(tabbedPane.getTitleAt(i))) {
                JPanel panelAlumnos = (JPanel) tabbedPane.getComponentAt(i);
                Component[] components = panelAlumnos.getComponents();

                // Eliminar la tabla existente
                for (Component comp : components) {
                    if (comp instanceof JScrollPane) {
                        JScrollPane scrollPane = (JScrollPane) comp;
                        JTable tablaExistente = (JTable) scrollPane.getViewport().getView();
                        String[] columnas = {"ID", "Nombre", "Apellido", "DNI", "Fecha Nacimiento"};
                        DefaultTableModel modelo = new DefaultTableModel(nuevosDatos, columnas);
                        tablaExistente.setModel(modelo);
                        break;
                    }
                }
                break;
            }
        }
    }

}
