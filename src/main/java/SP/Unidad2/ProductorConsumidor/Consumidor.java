package SP.Unidad2.ProductorConsumidor;

import java.util.concurrent.TimeUnit;

public class Consumidor implements Runnable {
    ListaCompartida lista;
    Consumidor(ListaCompartida lista) {
        this.lista = lista;
    }
    @Override
    public void run() {
        for (int n = (int)(Math.random() * 100) + 1; n > 0; n--) {
            boolean continuar = lista.eliminar();
            if (!continuar) {
                try {
                    TimeUnit.MILLISECONDS.sleep(2800);
                    System.out.println("Consumidor esperando");
                    System.out.println(lista.cantidadElementos());
                } catch (InterruptedException e) {
                    System.out.println("Error durante la ejecución de la consumición");
                }
            }
        }
    }
}
