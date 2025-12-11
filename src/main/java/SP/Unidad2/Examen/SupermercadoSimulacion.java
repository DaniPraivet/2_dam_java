package SP.Unidad2.Examen;

public class SupermercadoSimulacion {
    public static void main(String[] args) {
        // Agregamos los arrays que usará el supermercado
        Caja[] cajas = new Caja[2];
        Cliente[] clientes = new Cliente[5];
        // Creamos los productos
        Producto[] productos = {
                new Producto("Carne", 10.99),
                new Producto("Huevos", 3.99),
                new Producto("Agua", 0.50),
                new Producto("Natillas", 2.99),
                new Producto("Galletas", 2.08),
                new Producto("Pan", 0.99),
                new Producto("Roscon de reyes", 7.99),
                new Producto("Pack Polvorones", 4.57),
        };
        // Creamos las cajas
        for (int i = 0; i < cajas.length; i++) {
            cajas[i] = new Caja();
        }
        // Creamos los clientes
        for (int i = 0; i < clientes.length; i++) {
            clientes[i] = new Cliente(i, cajas, productos);
        }
        System.out.println("-".repeat(5)+"Supermercado Abierto"+"-".repeat(5));
        // Iniciamos los clientes
        for (Cliente c : clientes) {
            c.start();
        }
        try {
            for (Cliente c : clientes) {
                c.join();
            }
        } catch (InterruptedException e) {
            System.out.println("Error durante la simulacion.");
        }
        System.out.println("-".repeat(5)+"Supermercado Cerrado"+"-".repeat(5));
        System.out.println("Total recaudado: " + String.format("%.2f", Cliente.obtenerRecaudacionTotal()));
        System.out.println("Clientes atendidos: " + clientes.length);
    }
}
