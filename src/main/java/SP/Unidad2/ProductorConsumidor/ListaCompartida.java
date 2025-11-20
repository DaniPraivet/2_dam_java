package SP.Unidad2.ProductorConsumidor;

import java.util.LinkedList;

public class ListaCompartida {
    LinkedList<Integer> lista = new LinkedList<>();
    private static final int CANTIDAD_ELEMENTOS = 100;

    public synchronized boolean insertar(int valor) {
        if (lista.size() < CANTIDAD_ELEMENTOS) {
            lista.push(valor);
            return true;
        }
        return false;
    }

    public synchronized boolean eliminar() {
        if (!lista.isEmpty()) {
            lista.removeFirst();
            return true;
        }
        return false;
    }

    public synchronized int cantidadElementos() {
        return lista.size();
    }
}
