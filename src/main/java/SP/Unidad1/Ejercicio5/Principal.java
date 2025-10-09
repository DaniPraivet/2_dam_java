package SP.Unidad1.Ejercicio5;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Principal {
    public static void main(String[] args) {
        int suma = getSuma();
        System.out.println("Suma: " + suma);
    }

    public static int getSuma() {
        int suma = 0;
        try {
            String[] ficheros = {"informatica.txt", "gerencia.txt", "contabilidad.txt", "comercio.txt", "rrhh.txt"};
            String[] ruta = System.getProperty("java.class.path").split(";");
            for (int i = 0; i < 5; i++) {
                Process pHijo1 = new ProcessBuilder("java", "-cp", ruta[0], "SP.Unidad1.Ejercicio5.ProgramaContabilidad", ficheros[i]).start();
                BufferedReader br = new BufferedReader(new InputStreamReader(pHijo1.getInputStream()));
                String linea = br.readLine();
                suma += Integer.parseInt(linea);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return suma;
    }
}
