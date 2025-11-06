package MM.JavaSwing.Ejercicio6;

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
    MenuItem mi1 = new MenuItem("Generar Documentacion");
    MenuItem mi2 = new MenuItem("Construir automáticamente");
}
