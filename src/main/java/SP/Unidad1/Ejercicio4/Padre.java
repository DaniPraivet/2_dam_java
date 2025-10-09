package SP.Unidad1.Ejercicio4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Padre {
    public static void main(String[] args) {
        try {
            String[] ruta = System.getProperty("java.class.path").split(";");

            for (int i = 0; i < 3; i++) {
                Process pHijo1 = new ProcessBuilder("java", "-cp", ruta[0], "SP.Unidad1.Ejercicio4.Hijo", String.valueOf(i+1)).start();
                BufferedReader br = new BufferedReader(new InputStreamReader(pHijo1.getInputStream()));
                String linea = br.readLine();
                System.out.println(linea);
            }
        } catch (Exception e) {}
    }
}
