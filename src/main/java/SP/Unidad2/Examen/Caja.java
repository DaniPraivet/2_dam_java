package SP.Unidad2.Examen;

public class Caja {
    private boolean ocupada;

    public Caja() {
        this.ocupada = false;
    }

    public synchronized boolean ocupar() {
        if (!this.ocupada) {
            ocupada = true;
            return true;
        }
        return false;
    }

    public synchronized void desocupar() {
        this.ocupada = false;
    }
}
