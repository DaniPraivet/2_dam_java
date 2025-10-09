package SP.Unidad1.Ejercicio1;

import com.sun.security.jgss.GSSUtil;

public class ProcesoPrincipal {
    public static void main(String[] args) {
        // Mi método
        /*
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                ProcesoSecundario.main(args);
            }
        });
         */

        // Método profesora
        try {
            String[] ruta = System.getProperty("java.class.path").split(";");
            String[] infoProceso = {"java", "-cp", ruta[0], "SP\\Unidad1\\Ejercicio1\\ProcesoSecundario.java"};
            Process proceso = Runtime.getRuntime().exec(infoProceso);
            int valorRetorno = proceso.waitFor();
            if (valorRetorno == 0) {
                System.out.println("Proceso finalizado");
            } else  {
                System.out.println("Error al finalizar proceso, error: " + valorRetorno);
                System.out.println(ruta[0]);
            }
        } catch (Exception e) {
            throw new Error(e);
        }
    }
}
