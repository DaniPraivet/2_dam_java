package AD.Practica1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class App {
    final static String C_RUTA_PADRE = "src/main/java/AD/Practica1";
    final static String C_LOG_FILE = "src/main/java/AD/Practica1/Logs/log.log";
    final static String C_TIPO_INFO = "I";
    final static String C_TIPO_ERROR = "E";
    final static String C_TIPO_AVISO = "W";
    public static void main(String[] args) throws Exception {
        Date v_fecha = new Date();
        FileWriter v_file_log = new FileWriter(C_LOG_FILE, true);
        BufferedWriter v_log_writer = new BufferedWriter(v_file_log);
        // Ruta origen
        String v_ruta_origen = C_RUTA_PADRE + "/Origen";

        String v_ruta_destino = C_RUTA_PADRE + "/Destino";

        System.out.printf("Comienza ejecución");
        escribe_log(v_log_writer, C_TIPO_INFO, "Comienza ejecución.");

        File v_file_origFile = new File(v_ruta_origen);

        // Lista de ficheros origen
        File[] v_file_list = v_file_origFile.listFiles();

        if (v_file_list == null || v_file_list.length == 0) {
            System.out.println("La ruta origen está vacía");
        } else {
            System.out.println("La carpeta contiene " +  v_file_list.length);
            for (File v_file : v_file_list) {
                System.out.println("Procesando archivo " + v_file);
                if (v_file.isDirectory()) {
                    System.out.println("El archivo es un directorio.");
                } else {
                    System.out.println("Es un fichero.");
                    System.out.println("Copiando fichero.");
                    // Se copia el fichero
                    try {
                        Files.copy(v_file.toPath(), (new File(v_ruta_destino + "/" + v_file.getName())).toPath(), StandardCopyOption.REPLACE_EXISTING);
                        Thread.sleep(2000);
                        System.out.println("Fichero copiado a " + v_file.getName());
                        escribe_log(v_log_writer, C_TIPO_INFO, "Fichero copiado a " + v_ruta_destino);
                    } catch (UnsupportedOperationException e) {
                        escribe_log(v_log_writer, C_TIPO_ERROR, e.getMessage());
                    } catch (FileAlreadyExistsException e) {
                        escribe_log(v_log_writer, C_TIPO_ERROR, e.getMessage());
                    } catch (DirectoryNotEmptyException e) {
                        escribe_log(v_log_writer, C_TIPO_ERROR, e.getMessage());
                    } catch (IOException e) {
                        escribe_log(v_log_writer, C_TIPO_ERROR, e.getMessage());
                    } catch (Exception e) {
                        escribe_log(v_log_writer, C_TIPO_ERROR, e.getMessage());
                    }
                }
            }
            System.out.println("Fin de la ejecución");
            v_log_writer.close();
        }


    }
    private static void escribe_log(BufferedWriter v_log_buf, String v_tipo, String v_traza) {
        Date v_fecha_actual = new Date();
        DateFormat v_fecha_hora_actual = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        try {
            v_log_buf.write(v_fecha_hora_actual.format(v_fecha_actual) + " - " + v_tipo + " - " + v_traza + "\n");
            v_log_buf.flush();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
