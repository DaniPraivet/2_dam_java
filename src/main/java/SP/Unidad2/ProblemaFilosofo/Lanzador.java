package SP.Unidad2.ProblemaFilosofo;

public class Lanzador {
    private static final int NUM_FILOSOFOS = 5;
    private static final int NUM_TENEDORES = 5;
    public static void main(String[] args) {
        Filosofo[] filosofos = new Filosofo[NUM_FILOSOFOS];
        GestorPalillos gestorPalillos = new GestorPalillos(NUM_TENEDORES);
        for (int i = 0; i < NUM_FILOSOFOS; i++) {
            filosofos[i] = new Filosofo(gestorPalillos, i);
        }
    }
}
