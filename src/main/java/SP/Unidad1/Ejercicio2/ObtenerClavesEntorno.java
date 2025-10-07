package SP.Unidad1.Ejercicio2;

import java.util.Map;

public class ObtenerClavesEntorno {
    static ProcessBuilder processBuilder = new ProcessBuilder("explorer");
    public static void main(String[] args) {
        Map<String, String> env = processBuilder.environment();
        env.forEach((key, value) -> System.out.println(key + " : " + value));
    }
}
