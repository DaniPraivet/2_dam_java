package SP.Unidad2.Ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class AreasTriangulos {
    public static void main(String[] args) {
        List<CalculadorAreas> areas = new ArrayList<CalculadorAreas>();
        for (int i = 0; i < 100; i++) {
            double base = (Math.random() * 100) + 1;
            double altura = (Math.random() * 100) + 1;
            areas.add(new CalculadorAreas(base, altura));
        }
        for (CalculadorAreas c : areas) {
            Thread hilo = new Thread(c);
            hilo.start();
        }
    }
}
