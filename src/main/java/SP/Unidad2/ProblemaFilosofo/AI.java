package SP.Unidad2.ProblemaFilosofo;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.locks.ReentrantLock;

class TenedorIA {
    private final ReentrantLock lock = new ReentrantLock();
    public int usuario = -1; // id del filósofo que lo está usando

    public boolean coger(int filosofoId) {
        if (lock.tryLock()) {
            usuario = filosofoId;
            return true;
        }
        return false;
    }

    public void soltar() {
        usuario = -1;
        lock.unlock();
    }
}

class FilosofoIA implements Runnable {
    private final int id;
    private final TenedorIA izq;
    private final TenedorIA der;
    private final MesaIA mesa;
    private final int primeroIndice;
    private final int segundoIndice;

    public FilosofoIA(int id, TenedorIA izq, TenedorIA der, MesaIA mesa) {
        this.id = id;
        this.izq = izq;
        this.der = der;
        this.mesa = mesa;

        // Para evitar deadlock: siempre tomar primero el tenedor de menor índice
        if (System.identityHashCode(izq) < System.identityHashCode(der)) {
            primeroIndice = 0;
            segundoIndice = 1;
        } else {
            primeroIndice = 1;
            segundoIndice = 0;
        }
    }

    @Override
    public void run() {
        while (true) {
            pensar();
            TenedorIA[] palillos = {izq, der};
            boolean comiendo = false;
            while (!comiendo) {
                if (palillos[primeroIndice].coger(id)) {
                    mesa.repaint();
                    if (palillos[segundoIndice].coger(id)) {
                        mesa.repaint();
                        comiendo = true;
                    } else {
                        palillos[primeroIndice].soltar();
                        mesa.repaint();
                        setEstado("Esperando");
                        sleep(500);
                    }
                } else {
                    setEstado("Esperando");
                    sleep(500);
                }
            }
            comer();
            palillos[1].soltar();
            palillos[0].soltar();
            mesa.repaint();
        }
    }

    private void pensar() {
        setEstado("Pensando");
        sleep(1000 + (int)(Math.random()*1000));
    }

    private void comer() {
        setEstado("COMIENDO");
        sleep(1000 + (int)(Math.random()*1000));
        setEstado("Terminó de comer");
    }

    private void setEstado(String estado) {
        mesa.setEstado(id, estado);
        mesa.repaint();
    }

    private void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ignored) {}
    }
}

class MesaIA extends JPanel {
    private final int numFilosofos = 7;
    private final TenedorIA[] tenedores;
    private final String[] estados = new String[7];

    public MesaIA(TenedorIA[] tenedores) {
        this.tenedores = tenedores;
        for (int i = 0; i < numFilosofos; i++) estados[i] = "Pensando";
        setPreferredSize(new Dimension(600, 600));
        setBackground(new Color(245, 245, 220));
    }

    public void setEstado(int id, String estado) {
        estados[id] = estado;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int centerX = getWidth()/2;
        int centerY = getHeight()/2;
        int radio = 200;

        // Dibujar filósofos
        for (int i = 0; i < numFilosofos; i++) {
            double angle = 2*Math.PI*i/numFilosofos;
            int x = centerX + (int)(radio*Math.cos(angle));
            int y = centerY + (int)(radio*Math.sin(angle));

            // Color según estado
            Color color;
            switch(estados[i]){
                case "Pensando": color = new Color(135,206,250); break;
                case "Esperando": color = new Color(255,215,0); break;
                case "COMIENDO": color = new Color(50,205,50); break;
                default: color = new Color(135,206,250);
            }
            g.setColor(color);
            g.fillOval(x-30, y-30, 60, 60);
            g.setColor(Color.BLACK);
            g.drawOval(x-30, y-30, 60, 60);
            g.drawString(""+i, x-5, y+5);
            g.drawString(estados[i], x-30, y-40);
        }

        // Dibujar tenedores como líneas
        for (int i = 0; i < numFilosofos; i++) {
            double angle1 = 2*Math.PI*i/numFilosofos;
            double angle2 = 2*Math.PI*((i+1)%numFilosofos)/numFilosofos;
            int x1 = centerX + (int)(radio*Math.cos(angle1));
            int y1 = centerY + (int)(radio*Math.sin(angle1));
            int x2 = centerX + (int)(radio*Math.cos(angle2));
            int y2 = centerY + (int)(radio*Math.sin(angle2));

            // Color rojo si está ocupado
            if (tenedores[i].usuario != -1) g.setColor(Color.RED);
            else g.setColor(Color.GRAY);

            g.fillRect((x1+x2)/2-5, (y1+y2)/2-5, 10, 10);
            g.drawLine(x1, y1, x2, y2);
        }
    }
}

public class AI {
    private static final int NUM_FILOSOFOS = 7;
    public static void main(String[] args) {
        TenedorIA[] tenedores = new TenedorIA[NUM_FILOSOFOS];
        for (int i = 0; i < NUM_FILOSOFOS; i++) tenedores[i] = new TenedorIA();

        MesaIA mesa = new MesaIA(tenedores);
        JFrame frame = new JFrame("Filósofos Comensales - Mesa Circular");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(mesa);
        frame.pack();
        frame.setVisible(true);

        for (int i = 0; i < NUM_FILOSOFOS; i++) {
            TenedorIA izq = tenedores[i];
            TenedorIA der = tenedores[(i+1)%NUM_FILOSOFOS];
            Thread f = new Thread(new FilosofoIA(i, izq, der, mesa));
            f.start();
        }
    }
}
