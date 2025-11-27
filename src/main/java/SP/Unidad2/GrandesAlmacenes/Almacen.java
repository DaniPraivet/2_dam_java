package SP.Unidad2.GrandesAlmacenes;

public class Almacen {
    private int productos;

    public Almacen(int productos) {
        this.productos = productos;
    }

    public synchronized boolean cogerProducto() {
        if (productos > 0) {
            productos--;
            return true;
        }
        return false;
    }
}
