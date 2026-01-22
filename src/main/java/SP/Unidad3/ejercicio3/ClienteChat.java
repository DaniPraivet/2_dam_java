package SP.Unidad3.ejercicio3;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClienteChat {
    public static final int PUERTO = 9797;


    public static void main(String[] args) throws IOException {
        Socket s = new Socket("127.0.0.1", PUERTO);
        InputStream is = s.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        System.out.println("Iniciando conexion. ");
        out.println(br.readLine());
        out.println("fin");
        String linea;
        while ((linea = br.readLine()) != null) {
            System.out.println(linea);
        }
        br.close();
        s.close();
    }
}
