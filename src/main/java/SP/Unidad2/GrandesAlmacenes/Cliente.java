package SP.Unidad2.GrandesAlmacenes;

import java.util.Random;

public class Cliente implements Runnable {
    private int id;
    private Puerta puerta;
    private Almacen almacen;
    private int intentos = 0;
    private static final int MAX_INTENTOS = 10;
    private Random random = new Random();

    public Cliente(int id, Puerta puerta, Almacen almacen) {
        this.id = id;
        this.puerta = puerta;
        this.almacen = almacen;
    }

    @Override
    public void run() {
        while (intentos < MAX_INTENTOS) {
            intentos++;
            if (puerta.ocupar()) {
                try {
                    if (almacen.cogerProducto()) {
                        System.out.println("Cliente " + id + ": ha cogido un producto (Intento " + intentos + ")");
                    } else {
                        System.out.println("Cliente " + id + ": no quedan productos (Intento " + intentos + ")");
                    }
                    return;
                } finally {
                    puerta.liberar();
                }
            } else {
                try {
                    Thread.sleep(random.nextInt(100));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        }
        System.out.println("Cliente " + id + ": se marcha frustrado después de " + MAX_INTENTOS + " intentos");
    }
}
