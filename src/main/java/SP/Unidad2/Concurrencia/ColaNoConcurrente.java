package SP.Unidad2.Concurrencia;

import java.util.LinkedList;
import java.util.Queue;

public class ColaNoConcurrente implements Runnable{
    static Queue<Integer> cola = new LinkedList<>();
    @Override
    public void run() {
        cola.add(10);
        for (Integer i : cola) {
            System.out.println(i+":");
        }
        System.out.println("Tamaño cola: " + cola.size());
    }
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(new ColaNoConcurrente());
            t.start();
            try {
                t.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
