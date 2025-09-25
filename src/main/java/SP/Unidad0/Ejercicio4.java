package SP.Unidad0;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio4 {
    /*
    Leer los números que se encuentran en un fichero de texto,
    colocados cada uno en una línea
    e imprimir la media por consola. El nombre del fichero se pasa como
    argumento en la línea de comandos.
     */
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
            String linea;
            List<Integer> numeros = new ArrayList<>();
            int suma = 0;
            while ((linea = br.readLine()) != null) {
              numeros.add(Integer.parseInt(linea));
              suma += numeros.getLast();
            }
            System.out.println(suma/numeros.size());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
