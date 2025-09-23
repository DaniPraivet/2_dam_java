package SP.Unidad0;

import java.io.*;

public class Ejercicio3 {
    /*
     * Leer 2 ficheros de texto y se unirá en un nuevo fichero
     */
    public static void main(String[] args) {
        String filePath1 = "src/main/java/SP/Unidad0/Archivos/archivo1.txt";
        String filePath2 = "src/main/java/SP/Unidad0/Archivos/archivo2.txt";
        String filePath3 = "src/main/java/SP/Unidad0/Archivos/archivo3.txt";
        String texto = "";
        StringBuilder textoFusionado = new StringBuilder();

        try (BufferedReader br1 = new BufferedReader(new FileReader(filePath1));
             BufferedReader br2 = new BufferedReader(new FileReader(filePath2));
             BufferedWriter bw = new BufferedWriter(new FileWriter(filePath3))) {
            while (br1.readLine() == null && br2.readLine() == null) {
                if ((texto = br1.readLine()) != null) {
                    textoFusionado.append(texto);
                }
                if ((texto = br2.readLine()) != null) {
                    textoFusionado.append(texto);
                }
            }
            bw.write(String.valueOf(textoFusionado));
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
