package SP.Unidad2.ejercicio4;



public class VariableCompartida extends Thread {
    static int variable = 0;
    int contador;
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            contador++;
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            VariableCompartida v = new VariableCompartida();
            v.start();
        }
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
