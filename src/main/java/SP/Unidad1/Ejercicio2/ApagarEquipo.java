package SP.Unidad1.Ejercicio2;

public class ApagarEquipo {
    static final String COMMAND = "shutdown /s /t 30";
    static Process proceso;
    public static void main(String[] args) {
        ProcessBuilder processBuilder = new ProcessBuilder(COMMAND);
        try {
            proceso = processBuilder.start();
        } catch (Exception e) {
            System.out.println("Error al ejecutar el proceso");
        }
    }
}
