package SP.Unidad3.ejercicio1;

import java.io.*;
import java.net.Socket;
import java.text.DateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class ClienteHora {
    public static final int PUERTO = 9797;

    private static String darHora() {
        GregorianCalendar cal = new GregorianCalendar();
        Date date = cal.getTime();
        DateFormat sdf = DateFormat.getDateInstance(DateFormat.SHORT);
        return sdf.format(date);
    }

    public static void main(String[] args) throws IOException {
        Socket s = new Socket("172.26.11.77", PUERTO);
        InputStream is = s.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        System.out.println("Iniciando conexion: " + br.readLine());
        br.close();
        s.close();
    }
}
