package SP.Unidad1.Ejercicio7;

import java.util.Arrays;

public class Calculadora {
    public static void main(String[] args) {
        String tipo = args[0];
        int[] numeros = obtenerNumerosDesdeParametro(args[1]);
        int resultado = 0;
        switch (tipo) {
            case "+" -> {
                resultado = numeros[0] + numeros[1];
                System.out.println(numeros[0] +  " + " + numeros[1] + " = " + resultado);
            }
            case "-" -> {
                resultado = numeros[0] - numeros[1];
                System.out.println(numeros[0] +  " - " + numeros[1] + " = " + resultado);
            }
            case "*" -> {
                resultado = numeros[0] * numeros[1];
                System.out.println(numeros[0] +  " * " + numeros[1] + " = " + resultado);
            }
            case "/" -> {
                resultado = numeros[0] / numeros[1];
                System.out.println(numeros[0] +  " / " + numeros[1] + " = " + resultado);
            }
            default -> System.out.println("No se ha pasado un parámetro válido.");
        }
    }

    private static int[] obtenerNumerosDesdeParametro(String parametro) {
        return new int[]{Integer.parseInt(Arrays.toString(parametro.split("-")))};
    }
}
