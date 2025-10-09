package SP.Unidad1.Ejercicio3;

import java.io.IOException;
import java.util.Properties;

public class DirectorioTrabajo {
    /*
    - Escribe un programa que ejecute el domando dir
    - Modifica el valor de la propiedad user.dir
    - En la misma aplicación, cambiar el directorio de trabajo la carpeta c:/temp
    - Muestra el valor devuelto por el método directory
        - Después de crear la instancia de ProcessBuilder
        - Después de cambiar el valor de user.dir
        - Después de cambiar el directorio de trabajo al directorio temporal del sistema.
     */
    public static void main(String[] args) throws IOException {
        String command;
        ProcessBuilder pb = new ProcessBuilder();
        if (System.getProperty("os.name").toLowerCase().startsWith("windows")) {
            pb = new ProcessBuilder("cmd.exe", "/c", "start");
        } else {
            command = "sh -c ls";
            pb = new ProcessBuilder(command);
        }
        pb.start();
        Properties prop = System.getProperties();
        prop.entrySet().stream()
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
        System.setProperty("user.dir", "C:\\temp");
        System.getProperty("user.dir");
    }
}
