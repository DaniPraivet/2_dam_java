package SP.Unidad2.ejercicio4;



public class VariableCompartida extends Thread {
    static int contador;
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            incrementarContador();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            VariableCompartida v = new VariableCompartida();
            v.start();
        }
        System.out.println(contador);
    }

    public synchronized static void incrementarContador() {
        contador++;
    }
}

class HebraAumenta implements Runnable {
    String nombre;
    int var;
    HebraAumenta(String nombre, int var) {
        this.nombre = nombre;
        this.var = var;
    }
    @Override
    public void run() {
        var = var + 1000;
        System.out.println(nombre + ": " + var);
    }
}
