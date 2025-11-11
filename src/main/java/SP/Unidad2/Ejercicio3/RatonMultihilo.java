package SP.Unidad2.Ejercicio3;

import java.util.concurrent.TimeUnit;

public class RatonMultihilo implements Runnable{
    String nombre;
    int tiempoAlimentacion;

    RatonMultihilo(String nombre, int tiempoAlimentacion) {
        this.nombre = nombre;
        this.tiempoAlimentacion = tiempoAlimentacion;
    }

    public void comer() {
        try {
            System.out.println("El ratón " + this.nombre + " ha empezado a comer.");
            TimeUnit.SECONDS.sleep(tiempoAlimentacion);
            System.out.println("El ratón " + this.nombre + " ha terminado de comer.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        comer();
    }
    public static void main(String[] args) {
        for (int i = 0; i <= 10; i++) {
            new Thread(new RatonMultihilo(String.valueOf(i), ((int) Math.random() * 10)+1)).start();
        }
    }
}
