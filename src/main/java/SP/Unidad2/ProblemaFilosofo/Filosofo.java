package SP.Unidad2.ProblemaFilosofo;

import java.util.concurrent.TimeUnit;

public class Filosofo implements Runnable {
    GestorPalillos gestorPalillos;
    int[] palillos;
    int nFilosofo;

    Filosofo(GestorPalillos arg, int nFilosofo) {
        this.nFilosofo = nFilosofo;
        this.gestorPalillos = arg;
        this.palillos = asignarPalillosFilosofo(nFilosofo);
    }

    int[] asignarPalillosFilosofo(int nFilosofo) {
        switch (nFilosofo) {
            case 1 -> {return new int[] {0, 1};}
            case 2 -> {return new int[] {1, 2};}
            case 3 -> {return new int[] {2, 3};}
            case 4 -> {return new int[] {3, 4};}
            case 5 -> {return new int[] {4, 0};}
            default -> {return new int[] {0, 0};}
        }

    }

    @Override
    public void run() {
        for (;;) {
            boolean palillosCogidos = false;
            palillosCogidos = gestorPalillos.intentarCogerPalillos(palillos[0], palillos[1]);
            if (palillosCogidos) {
                System.out.println("["+ nFilosofo + "]Comiendo");
                try {
                    TimeUnit.SECONDS.sleep((int)(Math.random()*10)+1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                palillosCogidos = false;
                gestorPalillos.liberarPalillos(palillos[0],  palillos[1]);
            }
            return;
        }
    }
}
