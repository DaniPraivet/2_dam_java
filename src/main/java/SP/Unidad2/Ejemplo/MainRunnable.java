package SP.Unidad2.Ejemplo;

public class MainRunnable {
    public static void main(String[] args) {
        HebraRunnable hrun = new HebraRunnable("Hola");
        Thread t = new Thread(hrun);
        t.start();
    }
}