package SP.Unidad1.Ejercicio6;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CuentaVocales {
    public static void main(String[] args) {
        int suma = getSuma();
        System.out.println("Suma total: " + suma);
    }

    public static int getSuma() {
        int suma = 0;
        try {
            String[] vocales = {"aá", "eé", "ií", "oó", "uú"};
            String[] ruta = System.getProperty("java.class.path").split(";");
            for (int i = 0; i < vocales.length; i++) {
                int sumaLetra = 0;
                Process pHijo = new ProcessBuilder("java", "-cp", ruta[0], "SP.Unidad1.Ejercicio6.SubCuentaVocales", vocales[i]).start();
                BufferedReader br = new BufferedReader(new InputStreamReader(pHijo.getInputStream()));
                String linea;
                while ((linea = br.readLine()) != null) {
                    sumaLetra += Integer.parseInt(linea);
                }
                System.out.println(vocales[i].charAt(0) + " -> " + sumaLetra);
                suma += sumaLetra;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return suma;
    }
}
