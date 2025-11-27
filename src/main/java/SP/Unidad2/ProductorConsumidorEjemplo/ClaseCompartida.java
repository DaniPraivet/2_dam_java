package SP.Unidad2.ProductorConsumidorEjemplo;

public class ClaseCompartida {

    private int contador = 0;

    // Este método se declara synchronized
    public synchronized void incrementarContador() {
        // Código que accede al recurso compartido (contador)
        contador++;
        System.out.println(Thread.currentThread().getName() + " incrementó el contador a: " + contador);
    }

    public int getContador() {
        return contador;
    }
}
