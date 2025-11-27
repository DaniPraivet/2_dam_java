package SP.Unidad2.ProductorConsumidor;

public class Main {
    public static void main(String[] args) {
        ListaCompartida listaCompartida = new ListaCompartida();
        Consumidor consumidor = new Consumidor(listaCompartida);
        Productor productor = new Productor(listaCompartida);
        Thread thread1 = new Thread(consumidor);
        Thread thread2 = new Thread(productor);
        thread1.start();
        thread2.start();
    }
}
