package SP.Unidad1.Ejercicio2;

public class ApagarEquipo {
    static final String COMMAND = "C:\\Windows\\System32\\shutdown.exe /s /t 30";
    static Process proceso;
    public static void main(String[] args) {
        ProcessBuilder processBuilder = new ProcessBuilder(COMMAND);
        try {
            proceso = processBuilder.start();
        } catch (Exception e) {
            System.out.println(e.getMessage() + "\n" + e.getStackTrace() + "\n" + e.getCause());
        }
    }
}
