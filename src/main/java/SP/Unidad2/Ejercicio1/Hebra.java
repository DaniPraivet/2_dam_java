package SP.Unidad2.Ejercicio1;

public class Hebra extends Thread {

    Hebra(String nombre) {
        super(nombre);
    }

    @Override
    public void run() {
        for (int i = 1; i < 101; i++) {
            System.out.println(getName() + " : " + i);
        }
    }

    public static void main(String[] args) {
        Hebra hebra = new Hebra("1");
        Hebra hebra2 = new Hebra("2");
        hebra2.start();
        hebra.start();
    }
}
