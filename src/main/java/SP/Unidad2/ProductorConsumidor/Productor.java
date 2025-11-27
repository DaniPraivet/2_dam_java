package SP.Unidad2.ProductorConsumidor;

import java.util.concurrent.TimeUnit;

public class Productor implements Runnable {
    ListaCompartida lista;
    Productor(ListaCompartida lista) {
        this.lista = lista;
    }

    @Override
    public void run() {
        for (int n = (int)(Math.random() * 100) + 1; n > 0; n--) {
            boolean continuar = lista.insertar((int)(Math.random() * 100) + 1);
            if (!continuar) {
                try {
                    TimeUnit.MILLISECONDS.sleep(3000);
                    System.out.println("Productor esperando");
                    System.out.println(lista.cantidadElementos());
                } catch (InterruptedException e) {
                    System.out.println("Error durante la ejecución de la consumición");
                }
            }
        }
    }
}
