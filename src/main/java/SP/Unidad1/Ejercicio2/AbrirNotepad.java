package SP.Unidad1.Ejercicio2;

public class AbrirNotepad {
    public static void main(String[] args) {
        ProcessBuilder processBuilder = new ProcessBuilder("calc.exe");
        for (int i = 0; i < 200; i++) {
            try {
                Process proceso = processBuilder.start();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
