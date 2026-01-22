package SP.Unidad3.ejercicio4;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Cliente {
    public static void main(String[] args) throws IOException {
        MulticastSocket s = new MulticastSocket(10000);
        InetAddress group = InetAddress.getByName("231.0.0.5");
        s.joinGroup(group);

        String salida = "";
        while (!salida.equals("salir")) {
            byte[] buf = new byte[256];
            DatagramPacket dgp = new DatagramPacket(buf, buf.length);
            s.receive(dgp);
            byte[] buf2 = new byte[dgp.getLength()];
            System.arraycopy(dgp.getData(), 0, buf2, 0, dgp.getLength());
            salida = new String(buf2);
            System.out.println(salida);
        }
        s.leaveGroup(group);
        s.close();
    }
}
