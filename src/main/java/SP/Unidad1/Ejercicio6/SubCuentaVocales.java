package SP.Unidad1.Ejercicio6;

import java.io.*;

public class SubCuentaVocales {
    public static void main(String[] args) {
        leerArchivo(args[0]);
    }

    private static void leerArchivo(String letras) {
        File archivo = new File("src/main/java/SP/Unidad1/Ejercicio6/quijote.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            int contador = 0;
            while ((linea = br.readLine()) != null) {
                for (int i = 0; i < linea.length(); i++) {
                    if (linea.toLowerCase().charAt(i) == letras.charAt(0) || linea.toLowerCase().charAt(i) == letras.charAt(1)) {
                        contador++;
                    }
                }
            }
            System.out.println(contador);
        } catch (FileNotFoundException e) {
            System.out.println("No se encontro el archivo " + archivo);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo " + archivo);
        }
    }
}
