package SP.Unidad3.ejercicio2;

import java.io.*;
import java.net.Socket;
import java.text.DateFormat;
import java.util.*;

public class ClienteCalculadora {
    public static final int PUERTO = 9797;

    public static int[] generarNumeros() {
        List<Integer> lista = new ArrayList<>();
        for (int i = 0; i < ((int) (Math.random()*10)+1); i++) {
            lista.add((int) ((Math.random()*10)+1));
        }
        int[] numeros = new int[lista.size()];
        for (int i = 0; i < lista.size(); i++) {
            numeros[i] = lista.get(i);
        }
        return numeros;
    }


    public static void main(String[] args) throws IOException {
        Socket s = new Socket("127.0.0.1", PUERTO);
        InputStream is = s.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        System.out.println("Iniciando conexion. ");
        int[] numeros = generarNumeros();
        System.out.println(Arrays.toString(numeros));
        for (int n : numeros) {
            out.println(n);
        }
        out.println("fin");
        String linea;
        while ((linea = br.readLine()) != null) {
            System.out.println(linea);
        }
        br.close();
        s.close();
    }
}
