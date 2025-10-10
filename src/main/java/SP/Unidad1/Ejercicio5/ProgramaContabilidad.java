package SP.Unidad1.Ejercicio5;

import java.io.*;

public class ProgramaContabilidad {
    public static void main(String[] args) {
        if (args[1].equals("r")) {
            leerArchivo(args[0]);
        } else {
            escribirArchivo(args[0], Integer.parseInt(args[2]));
        }
    }

    private static void leerArchivo(String archivo) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/SP/Unidad1/Ejercicio5/"+archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se encontro el archivo " + archivo);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo " + archivo);
        }
    }

    private static void escribirArchivo(String archivo, int numerosAGenerar) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/java/SP/Unidad1/Ejercicio5/"+archivo))) {
            for (int i = 0; i < numerosAGenerar; i++) {
                int numeroGenerado = (int) (Math.random()*100+1);
                bw.write(String.valueOf(numeroGenerado));
                bw.newLine();
            }
            bw.flush();
        } catch (FileNotFoundException e) {
            System.out.println("No se encontro el archivo " + archivo);
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo " + archivo);
        }
    }
}
