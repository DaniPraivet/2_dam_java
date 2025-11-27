package SP.Unidad2.GrandesAlmacenes;

public class Main {
    public static void main(String[] args) {
        final int NUM_CLIENTES = 300;
        final int NUM_PRODUCTOS = 100;

        Almacen almacen = new Almacen(NUM_PRODUCTOS);
        Puerta puerta = new Puerta();

        for (int i = 1; i <= NUM_CLIENTES; i++) {
            new Thread(new Cliente(i, puerta, almacen)).start();
        }
    }
}
