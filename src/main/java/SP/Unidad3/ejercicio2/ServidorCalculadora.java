package SP.Unidad3.ejercicio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.util.*;

public class ServidorCalculadora {
    public static final int PUERTO = 9797;

    private static int[] calcularCuadrados(int... numeros) {
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] *= numeros[i];
        }
        return numeros;
    }

    public static void main(String[] args) throws IOException {
        ServerSocket servidor = new ServerSocket(PUERTO);
        System.out.println("Servidor iniciado.");
        while (true) {
            Socket socket = servidor.accept();
            System.out.println("Se ha conectado un cliente.");
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            String linea;

            while ((linea = br.readLine()) != null) {
                if (linea.equalsIgnoreCase("fin")) break;
                out.println(Arrays.toString(calcularCuadrados(Integer.parseInt(linea))));
            }

            out.println();
            out.close();
            socket.close();
        }
    }
}
