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
        /*for (int i = 0; i <= 10; i++) {
            new Thread(new RatonMultihilo(String.valueOf(i), ((int) Math.random() * 10)+1)).start();
        }
        */

        Thread th1 = new Thread(new RatonMultihilo(String.valueOf(1), 10));
        System.out.println(th1.getState());


        try {
            th1.start();
            TimeUnit.SECONDS.sleep(4);
            System.out.println(th1.getState());
        } catch (InterruptedException e) {
            System.out.println("Error");
        }


    }
}
