package SP.Unidad2.Concurrencia;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ColaConcurrente implements Runnable {
    static Queue<Integer> cola = new ConcurrentLinkedQueue<>();

    @Override
    public void run() {
        int numeroAleatorio = (int) (Math.random()*100);
        cola.add(numeroAleatorio);
        for(Integer numero : cola) {
            System.out.println(numero+":");
        }
        System.out.println("Tamaño cola: " + cola.size());
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(new ColaConcurrente());
            t.start();
            try {
                t.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
