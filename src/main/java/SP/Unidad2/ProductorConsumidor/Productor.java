package SP.Unidad2.ProductorConsumidor;

import java.util.concurrent.TimeUnit;

public class Productor implements Runnable {
    ListaCompartida lista;
    Productor(ListaCompartida lista) {
        this.lista = lista;
    }

    @Override
    public void run() {
        for (;;) {
            boolean continuar = lista.insertar((int)(Math.random() + 1)*100);
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
