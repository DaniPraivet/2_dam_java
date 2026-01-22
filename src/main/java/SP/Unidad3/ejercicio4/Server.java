package SP.Unidad3.ejercicio4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Server {
    public static void main(String[] args) throws IOException {
        System.out.println("Iniciando conexion.");
        MulticastSocket s = new MulticastSocket();
        byte[] vacio = new byte[0];
        InetAddress group = InetAddress.getByName("231.0.0.5");
        DatagramPacket dgp = new DatagramPacket(vacio, 0 , group, 10000);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String linea;
        while (!(linea = br.readLine()).equals("salir")) {
            String mensaje = "Servidor:::"+linea;
            byte[] buffer = mensaje.getBytes();
            dgp.setData(buffer);
            dgp.setLength(buffer.length);
            s.send(dgp);
        }
        s.close();
    }
}
