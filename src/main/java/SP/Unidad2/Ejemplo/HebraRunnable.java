package SP.Unidad2.Ejemplo;

public class HebraRunnable implements Runnable {
    String nombre;
    public HebraRunnable(String str) {
        this.nombre = str;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(this.nombre);
        }
    }
}
