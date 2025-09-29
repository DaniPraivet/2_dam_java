package AD.Practica1;

import java.io.*;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class App {
    // Constantes
    final static String C_RUTA_PADRE = "src/main/java/AD/Practica1";
    final static String C_LOG_FILE = "src/main/java/AD/Practica1/Logs/log.log";
    final static String C_TIPO_INFO = "I";
    final static String C_TIPO_ERROR = "E";
    final static String C_TIPO_AVISO = "W";
    public static void main(String[] args) throws Exception {
        // Fecha para guardarla en el log
        Date v_fecha = new Date();
        // Buffers de entrada para escribir en el log
        FileWriter v_file_log = new FileWriter(C_LOG_FILE, true);
        BufferedWriter v_log_writer = new BufferedWriter(v_file_log);
        // Ruta origen
        String v_ruta_origen = C_RUTA_PADRE + "/Origen";
        // Ruta Destino
        String v_ruta_destino = C_RUTA_PADRE + "/Destino";

        // Mensaje por consola que inicia el programa
        System.out.printf("Comienza ejecución");
        escribe_log(v_log_writer, C_TIPO_INFO, "Comienza ejecución.");

        // Creamos un objeto file en el que guardamos el archivo origen
        File v_file_origFile = new File(v_ruta_origen);

        // Lista de ficheros origen
        File[] v_file_list = v_file_origFile.listFiles();

        // Si la carpeta está vacía o no existe, muestra un mensaje por consola
        if (v_file_list == null || v_file_list.length == 0) {
            System.out.println("La ruta origen está vacía");
        } else {
            // Sino, muestra los archivos
            System.out.println("La carpeta contiene " +  v_file_list.length);
            for (File v_file : v_file_list) {
                // Los procesa uno a uno
                System.out.println("Procesando archivo " + v_file);
                if (v_file.isDirectory()) {
                    System.out.println("El archivo es un directorio.");
                } else {
                    // Manda mensaje por terminal
                    System.out.println("Es un fichero.");
                    System.out.println("Copiando fichero.");
                    try {
                        // Se copia el fichero
                        Files.copy(v_file.toPath(), (new File(v_ruta_destino + "/" + v_file.getName())).toPath(), StandardCopyOption.REPLACE_EXISTING);
                        Thread.sleep(2000);
                        // Muestra la ruta de donde se copió por terminal
                        System.out.println("Fichero copiado a " + v_file.getName());
                        escribe_log(v_log_writer, C_TIPO_INFO, "Fichero copiado a " + v_ruta_destino);

                        // Aqui controlamos las excepciones
                    } catch (UnsupportedOperationException e) {
                        escribe_log(v_log_writer, C_TIPO_ERROR, e.toString());
                    } catch (FileAlreadyExistsException e) {
                        escribe_log(v_log_writer, C_TIPO_ERROR, e.toString());
                    } catch (FileNotFoundException e) {
                        escribe_log(v_log_writer, C_TIPO_ERROR, e.toString());
                    }catch (DirectoryNotEmptyException e) {
                        escribe_log(v_log_writer, C_TIPO_ERROR, e.toString());
                    } catch (IOException e) {
                        escribe_log(v_log_writer, C_TIPO_ERROR, e.toString());
                    } catch (Exception e) {
                        escribe_log(v_log_writer, C_TIPO_ERROR, e.toString());
                    } finally {
                        // Cerramos el buffer de entrada del archivo log porque ya ha finalizado el programa
                        v_log_writer.close();
                    }
                }
            }
            // Fin del programa
            System.out.println("Fin de la ejecución");
        }


    }
    private static void escribe_log(BufferedWriter v_log_buf, String v_tipo, String v_traza) {
        // Fecha y formato de la fecha para el mensaje de log
        Date v_fecha_actual = new Date();
        DateFormat v_fecha_hora_actual = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        try {
            // Escribimos el mensaje directamente en el log con la fecha y el texto
            v_log_buf.write(v_fecha_hora_actual.format(v_fecha_actual) + " - " + v_tipo + " - " + v_traza + "\n");
            v_log_buf.flush();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
