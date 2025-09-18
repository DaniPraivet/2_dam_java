package Unidad0;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

public class Ejercicio2 {
    // Escribir en un fichero hasta que no quieras escribir nada más
    public static void main(String[] args) {
        String filePath = "src/main/java/Unidad0/Archivos/archivo1.txt";
        Scanner sc = new Scanner(System.in);
        String texto = "";

        while (true) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
                texto = sc.nextLine();
                if (!texto.isEmpty()) {
                    bw.write(texto);
                    bw.newLine();
                } else {
                    break;
                }
            } catch (Exception _) {
                System.out.println("Error");
            }
        }
    }
}
