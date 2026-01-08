package SP.Unidad3.ejercicio1;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class ServidorHora {
    public static final int PUERTO = 9797;

    private static String darHora() {
        GregorianCalendar cal = new GregorianCalendar();
        Date date = cal.getTime();
        DateFormat sdf = DateFormat.getDateInstance(DateFormat.SHORT);
        return sdf.format(date);
    }

    public static void main(String[] args) throws IOException {
        ServerSocket servidor = new ServerSocket(PUERTO);
        System.out.println("Servidor iniciado.");
        while (true) {
            Socket socket = servidor.accept();
            System.out.println("Se ha conectado un cliente.");
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println(darHora());
            out.close();
            socket.close();
        }
    }
}
