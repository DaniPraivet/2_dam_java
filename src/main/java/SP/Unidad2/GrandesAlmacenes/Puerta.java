package SP.Unidad2.GrandesAlmacenes;

public class Puerta {
    private boolean ocupada;

    public Puerta() {
        this.ocupada = false;
    }

    public synchronized boolean ocupar() {
        if (!ocupada) {
            ocupada = true;
            return true;
        }
        return false;
    }

    public synchronized void liberar() {
        ocupada = false;
    }
}
