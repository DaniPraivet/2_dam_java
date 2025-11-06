package SP.Unidad2.Ejercicio3;

public class RatonSecuencial {
    String nombre;
    int tiempoAlimentacion;

    RatonSecuencial(String nombre, int tiempoAlimentacion) {
        this.nombre = nombre;
        this.tiempoAlimentacion = tiempoAlimentacion;
    }

    public void comer() {
        try {
            System.out.println("El ratón " + this.nombre + " ha empezado a comer.");
            Thread.sleep(tiempoAlimentacion);
            System.out.println("El ratón " + this.nombre + " ha terminado de comer.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new RatonSecuencial(String.valueOf(i), ((int) Math.random() * 10000)+1).comer();
        }
    }
}
