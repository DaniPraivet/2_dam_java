package SP.Unidad2.ProblemaFilosofo;

public class GestorPalillos {
    boolean[] palillosLibres;

    GestorPalillos(int nPalillos) {
        palillosLibres = new boolean[nPalillos];
        for (int i = 0; i < nPalillos; i++) {
            palillosLibres[i] = true;
        }
    }

    public synchronized boolean intentarCogerPalillos(int p1, int p2) {
        if ((palillosLibres[p1]) && (palillosLibres[p2])) {
            palillosLibres[p1] = false;
            palillosLibres[p2] = false;
            return true;
        }
        return false;
    }

    public synchronized void liberarPalillos(int p1, int p2) {
        palillosLibres[p1] = true;
        palillosLibres[p2] = false;
    }
}
