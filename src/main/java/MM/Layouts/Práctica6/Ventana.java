package MM.Layouts.Práctica6;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
    JPanel panelPrincipal;
    JButton botonPapel;
    JPanel panelConBoton;
    JTabbedPane menu;
    JPanel alumnos;
    JPanel asignatura;
    JPanel matricula;
    JTabbedPane menuInterior;
    ImageIcon iconPapel;
    ImageIcon iconAlumno;
    ImageIcon iconMatricula;
    ImageIcon iconAsignatura;


    public Ventana() {
        initGUI();
    }

    public void initGUI() {
        // Creamos el primer panel con pestañas
        alumnos = new JPanel();
        asignatura = new JPanel();
        matricula = new JPanel();
        menuInterior = new JTabbedPane();
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
        menuInterior.add("Alumnos", alumnos);
        menuInterior.add("Asignatura", asignatura);
        menuInterior.add("Matricula", matricula);
        menuInterior.setIconAt(0, iconAlumno);
        menuInterior.setIconAt(1, iconAsignatura);
        menuInterior.setIconAt(2, iconMatricula);

        // Menu superior
        panelConBoton = new JPanel();
        botonPapel = new JButton(iconPapel);
        panelConBoton.add(botonPapel);
        menu = new JTabbedPane();
        menu.add("Alumnos", panelConBoton);
        menu.add("Asignatura", panelConBoton);
        menu.add("Matricula", panelConBoton);


        // Añadir menú a la parte inferior del panel
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.add(menuInterior, BorderLayout.CENTER);
        panelPrincipal.add(menu, BorderLayout.NORTH);
    }

    public static void main(String[] args) {
        Ventana ventana = new Ventana();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
        ventana.setSize(800, 600);
        ventana.setContentPane(ventana.panelPrincipal);
    }
}
