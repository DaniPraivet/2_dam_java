package SP.Test;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class CuentaAtras extends JFrame {

    private JTextArea area;

    private final LocalDateTime objetivo = LocalDateTime.of(2025, 12, 19, 11, 19);

    public CuentaAtras() {
        setTitle("Tiempo para q mi corason llegue a Córdoba");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        area = new JTextArea();
        area.setEditable(false);
        area.setFont(new Font("Monospaced", Font.PLAIN, 16));

        add(new JScrollPane(area));

        Timer timer = new Timer(1000, e -> actualizarCuentaAtras());
        timer.start();
    }

    private void actualizarCuentaAtras() {
        LocalDateTime ahora = LocalDateTime.now();

        if (ahora.isAfter(objetivo)) {
            area.setText("La fecha objetivo ya ha pasado.");
            return;
        }

        long segundos = ChronoUnit.SECONDS.between(ahora, objetivo);
        long minutos = ChronoUnit.MINUTES.between(ahora, objetivo);
        long horas   = ChronoUnit.HOURS.between(ahora, objetivo);
        long dias    = ChronoUnit.DAYS.between(ahora, objetivo);
        long semanas = dias / 7;
        long meses   = ChronoUnit.MONTHS.between(ahora, objetivo);

        area.setText(
                "Tiempo restante:\n\n" +
                        "Meses:     " + meses + "\n" +
                        "Semanas:   " + semanas + "\n" +
                        "Días:      " + dias + "\n" +
                        "Horas:     " + horas + "\n" +
                        "Minutos:   " + minutos + "\n" +
                        "Segundos:  " + segundos + "\n"
        );
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CuentaAtras app = new CuentaAtras();
            app.setVisible(true);
        });
    }
}
