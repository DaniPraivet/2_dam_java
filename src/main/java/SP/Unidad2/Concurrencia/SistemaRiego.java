package SP.Unidad2.Concurrencia;

import java.util.Timer;
import java.util.TimerTask;

public class SistemaRiego extends TimerTask {
    @Override
    public void run() {
        System.out.println("Regando");
    }

    public static void main(String[] args) {
        SistemaRiego aspersor = new SistemaRiego();
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(aspersor, 0, 1000);
        timer.schedule(aspersor, 0, 1000);
    }
}
