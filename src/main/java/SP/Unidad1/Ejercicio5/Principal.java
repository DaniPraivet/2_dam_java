package SP.Unidad1.Ejercicio5;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Principal {
    public static void main(String[] args) {
        generarDatos(10);
        int suma = getSuma();
        System.out.println("Suma: " + suma);
    }

    public static int getSuma() {
        int suma = 0;
        try {
            String[] ficheros = {"informatica.txt", "gerencia.txt", "contabilidad.txt", "comercio.txt", "rrhh.txt"};
            String[] ruta = System.getProperty("java.class.path").split(";");
            for (int i = 0; i < 5; i++) {
                Process pHijo = new ProcessBuilder("java", "-cp", ruta[0], "SP.Unidad1.Ejercicio5.ProgramaContabilidad", ficheros[i], "r").start();
                BufferedReader br = new BufferedReader(new InputStreamReader(pHijo.getInputStream()));
                String linea;
                while ((linea = br.readLine()) != null) {
                    suma += Integer.parseInt(linea);
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return suma;
    }

    public static void generarDatos(int numerosAGenerar) {
        try {
            String[] ficheros = {"informatica.txt", "gerencia.txt", "contabilidad.txt", "comercio.txt", "rrhh.txt"};
            String[] ruta = System.getProperty("java.class.path").split(";");
            for (int i = 0; i < 5; i++) {
                Process pHijo = new ProcessBuilder("java", "-cp", ruta[0], "SP.Unidad1.Ejercicio5.ProgramaContabilidad", ficheros[i], "w", String.valueOf(numerosAGenerar)).start();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
