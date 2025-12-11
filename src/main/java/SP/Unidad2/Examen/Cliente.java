package SP.Unidad2.Examen;

import java.util.Random;

public class Cliente extends Thread{
    private int id;
    private Caja[] cajas;
    private Producto[] productos;
    private Random random = new Random();
    private static double recaudacionTotal = 0;

    Cliente(int id, Caja[] cajas, Producto[] productos) {
        this.id = id;
        this.cajas = cajas;
        this.productos = productos;
        this.random = new Random();
    }

    @Override
    public void run() {
        // Generar productos para el cliente
        int numProductos = random.nextInt(5) + 1;

        // Intentar ocupar la caja
        int cajaAsignada = -1;
        System.out.println("I - Cliente" + id + " llega con " +  numProductos + " productos esperando para una caja.");
        while (cajaAsignada == -1) {
            for (int i = 0; i < cajas.length; i++) {
                if (cajas[i].ocupar()) {
                    cajaAsignada = i+1;
                    break;
                }
            }
            if (cajaAsignada != -1) {
                try {
                    System.out.println("I - Cliente[" + id + "] en Caja[" + cajaAsignada + "].");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("E - Error mientras el cliente estaba esperando a una caja.");
                }
            }
        }

        System.out.println("I - El cliente " + id + " esta siendo atendido en la caja " + cajaAsignada);

        double totalGastado = 0;
        for (int i = 0; i < numProductos; i++) {
            Producto p = productos[random.nextInt(productos.length)];
            totalGastado += p.precio;
            System.out.println("I - Caja [" + cajaAsignada + "] - Cliente [" + id + "] con producto [" + p.nombre + "] con precio " + String.format("%.2f", p.precio));
            try {
                Thread.sleep(random.nextInt(500) + 300);
            } catch (InterruptedException e) {
                System.out.println("E - Error mientras el cliente está esperando mientras la caja escanea los productos.");
            }
        }
        // Pagar
        int tiempoPago = random.nextInt(1000) + 500;
        System.out.println("I - Caja [" + cajaAsignada + "] - Cliente [" + id + "] debe pagar " + String.format("%.2f", totalGastado));
        try {
            Thread.sleep(random.nextInt(tiempoPago));
        } catch (InterruptedException e) {
            System.out.println("E - Error durante la espera después del pago.");
        }
        // Guardamos lo que se ha gastado el cliente
        synchronized (Cliente.class) {
            recaudacionTotal += totalGastado;
        }
        System.out.println("I - Cliente [" + id + "] finaliza en Caja[" + cajaAsignada + "] pagando " + String.format("%.2f", totalGastado));
        cajas[cajaAsignada-1].desocupar();
    }

    public static synchronized double obtenerRecaudacionTotal() {
        return recaudacionTotal;
    }
}
