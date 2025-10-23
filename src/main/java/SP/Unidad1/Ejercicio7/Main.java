package SP.Unidad1.Ejercicio7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] numeros = getResultadosCalculadora();
        System.out.println("Resultados calculadora: " + Arrays.toString(numeros));
    }

    static int[] getResultadosCalculadora() {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        String[] operadores = {"aá", "eé", "ií", "oó", "uú"};
        String[] ruta = System.getProperty("java.class.path").split(";");
        try {
            for (int i = 0; i < operadores.length; i++) {
                int suma = 0;
                Process pHijo = new ProcessBuilder("java", "-cp", ruta[0], "SP.Unidad1.Ejercicio7.Calculadora", operadores[i]).start();
                BufferedReader br = new BufferedReader(new InputStreamReader(pHijo.getInputStream()));
                String linea;
                while ((linea = br.readLine()) != null) {
                    suma += Integer.parseInt(linea);
                }
                suma += suma;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new int[]{0, 0};
    }
}
