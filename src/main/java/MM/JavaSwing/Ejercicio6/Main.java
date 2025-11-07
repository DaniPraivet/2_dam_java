package MM.JavaSwing.Ejercicio6;

import javax.swing.*;
import java.awt.*;

/*
Vamos a hacer un JFrame que tenga algunos
menús del Eclipse: Proyecto y Ventana.

En Proyecto:

Un item de menu: Generar Documentacion

Un item de menú CheckBox: Construir automaticamente

En Ventana:

Un submenu: Abrir ventana, que se despliegue en

Consola, errores y variables

Y 2 items de menu RadioButton: Opcion1 y Opcion2.

Capturar sus eventos y cada vez que
seleccionemos un menú decir cual ha sido
seleccionado.
 */

public class Main extends javax.swing.JFrame {
    JMenu menuProyecto = new JMenu("Proyecto");
    JMenu menuVentana, menuAbrirVentana;
    JMenuItem menuAbrirConsola, menuAbrirErrores, menuAbrirVariables;
    JRadioButtonMenuItem menuOpcion1, menuOpcion2;
    CheckboxMenuItem menuConstruirDoc = new CheckboxMenuItem("Construir Documento");
    JMenuBar menubar = new JMenuBar();

    JPanel contenedor;
    JSplitPane pnDivisor = new JSplitPane();
    JPanel pnConsulta;
    JPanel panelConsola = new JPanel();

    public void initGUI() {
        this.setTitle("Ventanas con menus");
        contenedor = (JPanel) this.getContentPane();
        contenedor.setLayout(new BorderLayout());
        contenedor.add(pnDivisor, BorderLayout.NORTH);
        pnDivisor.setDividerLocation(JSplitPane.HORIZONTAL_SPLIT);
        pnDivisor.setBottomComponent(panelConsola);
        initMenu();
    }

    public void initMenu() {
        menuProyecto.add(menuConstruirDoc);
        menuVentana.setFont(new Font("Arial", Font.BOLD, 18));
        menuAbrirVentana = new JMenu("Abrir Ventanas");
        menuAbrirConsola = new JMenuItem("Abrir Consola");
        menuAbrirErrores = new JMenuItem("Abrir Errores");
        menuAbrirVariables = new JMenuItem("Abrir Variables");
        menuAbrirVentana.add(menuAbrirConsola);
        menuAbrirVentana.add(menuAbrirErrores);
        menuAbrirVentana.add(menuAbrirVariables);
        menuVentana.add(menuAbrirVentana);
        menuOpcion1 = new JRadioButtonMenuItem("Opcion 1");
        menuOpcion2 = new JRadioButtonMenuItem("Opcion 2");
        menuVentana.add(menuOpcion1);
        menuVentana.add(menuOpcion2);
        menubar.add(menuProyecto);
        menubar.add(menuVentana);

    }

    public static void main(String[] args) {

    }
}
