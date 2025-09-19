package SP.Unidad0;

import java.io.*;

public class Ejercicio1 {
    // Leer un fichero
    public static void main(String[] args) {
        String filePath = "src/main/java/SP/Unidad0/Archivos/archivo1.txt";
        String texto = "";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((texto = br.readLine()) != null) {
                System.out.println(texto);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
