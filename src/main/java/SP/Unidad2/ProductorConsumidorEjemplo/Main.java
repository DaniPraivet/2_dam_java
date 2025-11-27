package SP.Unidad2.ProductorConsumidorEjemplo;

public class Main {
    public static void main(String[] args) {
        ClaseCompartida objetoCompartido = new ClaseCompartida();

        // Creamos dos hilos que ejecutan el método synchronized
        Thread hilo1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    objetoCompartido.incrementarContador();
                }
            }
        }, "Hilo 1");

        Thread hilo2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    objetoCompartido.incrementarContador();
                }
            }
        }, "Hilo 2");

        hilo1.start();
        hilo2.start();
    }
}

