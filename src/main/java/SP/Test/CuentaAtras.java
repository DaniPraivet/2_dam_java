package SP.Test;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class CuentaAtras extends JFrame {

    private JTextArea area;
    private ImageIcon meme;
    private JLabel contenedorImagen;
    private final LocalDateTime objetivo = LocalDateTime.of(2025, 12, 19, 11, 19);

    public CuentaAtras() {
        setTitle("Tiempo para q Marta llegue a Córdoba");
        setSize(450, 500); // Increased height to fit both
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Use BorderLayout for the frame
        setLayout(new BorderLayout());

        // 1. FIX IMAGE LOADING:
        // Ensure the path is correct or use ClassLoader for resources
        meme = new ImageIcon("src/main/java/SP/Test/images.png");
        contenedorImagen = new JLabel(meme);
        // Place image at the TOP
        add(contenedorImagen, BorderLayout.NORTH);

        area = new JTextArea();
        area.setEditable(false);
        area.setFont(new Font("Monospaced", Font.BOLD, 16));
        area.setBackground(new Color(240, 240, 240));

        // 2. FIX OVERLAP: Place text area in the CENTER
        add(new JScrollPane(area), BorderLayout.CENTER);

        Timer timer = new Timer(1000, e -> actualizarCuentaAtras());
        timer.start();

        // Run update immediately so it doesn't start empty
        actualizarCuentaAtras();
    }

    private void actualizarCuentaAtras() {
        LocalDateTime ahora = LocalDateTime.now();

        if (ahora.isAfter(objetivo)) {
            area.setText("\n\n   ¡MARTA YA DEBERÍA ESTAR AQUÍ! ❤️");
            return;
        }

        // Logic for breakdown (Days, Hours, Minutes, Seconds remaining)
        long temp = ahora.until(objetivo, ChronoUnit.SECONDS);
        long dias = temp / 86400;
        temp %= 86400;
        long horas = temp / 3600;
        temp %= 3600;
        long minutos = temp / 60;
        long segundos = temp % 60;

        area.setText(
                "\n  TIEMPO RESTANTE:\n" +
                        "  ------------------------------\n" +
                        "  Días:      " + dias + "\n" +
                        "  Horas:     " + horas + "\n" +
                        "  Minutos:   " + minutos + "\n" +
                        "  Segundos:  " + segundos + "\n"
        );
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CuentaAtras app = new CuentaAtras();
            app.setVisible(true);
        });
    }
}
