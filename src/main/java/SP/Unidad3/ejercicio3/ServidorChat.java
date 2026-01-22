package SP.Unidad3.ejercicio3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;

public class ServidorChat {
    public static final int PUERTO = 9797;

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
                if (linea.equalsIgnoreCase(".")) break;
                out.println(linea);
            }
            Scanner sc = new Scanner(System.in);
            if (sc.nextLine() != null) {
                out.println();
                out.close();
                socket.close();
                break;
            }
        }
    }
}
