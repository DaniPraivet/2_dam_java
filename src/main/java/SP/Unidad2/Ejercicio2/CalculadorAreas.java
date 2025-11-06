package SP.Unidad2.Ejercicio2;

public class CalculadorAreas implements Runnable {
    double b;
    double h;

    CalculadorAreas(double base, double altura) {
        this.b = base;
        this.h = altura;
    }

    @Override
    public void run() {
        double resultado = (b * h)/2;
        System.out.printf("%.2f\n", resultado);
    }
}
