package AD.Práctica4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static final String RUTA_PADRE = "src/main/java/AD/Práctica4";
    public static final String NOMBRE_ARCHIVO_LOG = "log_BBDD";
    public static final String TIPO_INFO = "I";
    public static final String TIPO_ERROR = "E";
    public static final String TIPO_AVISO = "W";

    public static void main(String[] args) {
        String ruta_log = RUTA_PADRE+"/log/";
        Date fecha = new Date();
        DateFormat formatoFecha = new SimpleDateFormat("yyyyMMdd_HHmmss");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta_log+NOMBRE_ARCHIVO_LOG+formatoFecha.format(fecha)))) {
            escribirLog(bw, TIPO_INFO, "Iniciando programa");
            Connection conexion = conectaDb(bw);
            inicarBBDD(conexion, bw);
            lanzaConsulta(conexion, "SELECT * FROM escuela.alumno;", bw);
            lanzaConsulta(conexion, "SELECT * FROM escuela.profesor;", bw);
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void escribirLog(BufferedWriter bw, String tipo, String mensaje) {
        Date fecha = new Date();
        DateFormat formatoFecha = new SimpleDateFormat("yyyyMMdd_HHmmss");
        try {
            bw.write(formatoFecha.format(fecha) + " | " + tipo + " | " + mensaje);
            bw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Connection conectaDb(BufferedWriter bw) {
        Connection conexion = null; // Comentar
        escribirLog(bw, TIPO_INFO, "Estableciendo conexión");
        try {

        } catch (Exception e) {
            System.out.println("Error estableciendo la conexión.");
            escribirLog(bw, TIPO_ERROR, "Error estableciendo la conexión.");
        }
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306", "Desarrollador", "usuario");
            escribirLog(bw, TIPO_INFO, "Conexión establecida");
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
            escribirLog(bw, TIPO_ERROR, "Error estableciendo conexión " + e.getMessage());
        }
        return conexion;
    }

    private static void imprimirConsulta(ResultSet datos, BufferedWriter bw) throws SQLException {
        ResultSetMetaData metadatos = datos.getMetaData();
        int numColumnas = metadatos.getColumnCount();
        escribirLog(bw, TIPO_INFO, "Imprimiendo informe");

        StringBuilder encabezado = new StringBuilder();
        for (int i = 1; i <= numColumnas; i++) {
            encabezado.append(String.format("%-25s", metadatos.getColumnLabel(i)));
        }
        System.out.println(encabezado);
        System.out.println("=".repeat(encabezado.length()));

        while (datos.next()) {
            StringBuilder fila = new StringBuilder();
            for (int i = 1; i <= numColumnas; i++) {
                String valor = datos.getString(i);
                if (valor == null) valor = "NULL";
                fila.append(String.format("%-25s", valor));
            }
            System.out.println(fila);
        }

        System.out.println("-".repeat(encabezado.length()));
        escribirLog(bw, TIPO_INFO, "Informe impreso");
    }


    private static void lanzaConsulta(Connection conexion, String consulta, BufferedWriter bw) {
        Statement sentencia = null;
        ResultSet resultado = null;

        escribirLog(bw, TIPO_INFO, "Lanzando consulta: " + consulta);

        try {
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(consulta);
            escribirLog(bw, TIPO_INFO, "Consulta ejecutada");
            imprimirConsulta(resultado, bw);
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
    }

    private static void inicarBBDD(Connection conexion, BufferedWriter bw) throws SQLException {
        Statement sentencia = null;
        List<Alumno> alumnos = new ArrayList<>();
        List<Profesor> profesores = new ArrayList<>();
        alumnos.add(new Alumno("99999999Z", "Roberto", "Bolero", "Plaza", true, "1DAM"));
        alumnos.add(new Alumno("88888888Y", "Clara", "Jiménez", "Burón", false, "1DAM"));
        alumnos.add(new Alumno("77777777X", "Fernando", "Pérez", "Alcalá", true, "2DAM"));
        alumnos.add(new Alumno("66666666W", "Oscar", "Luque", "Sanchez", true, "1SMR"));
        profesores.add(new Profesor("55555555V", "Marta", "Sanchez", "Gallardo", false, "1DAM"));
        profesores.add(new Profesor("44444444T", "Rafa", "Villalba", "Cruz", true, "2DAM"));
        profesores.add(new Profesor("33333333S", "Antonia", "Cabrera", "Quesada", false, "1SMR"));

        for (int i = 0; i < alumnos.size(); i++) {

            StringBuilder consulta = new StringBuilder();
            consulta.append("INSERT INTO `escuela`.`alumno`\n" +
                    "(`dni`,\n" +
                    "`nombre`,\n" +
                    "`apellido1`,\n" +
                    "`apellido2`,\n" +
                    "`sexo`,\n" +
                    "`curso`)\n" +
                    "VALUES\n" +
                    "('" + alumnos.get(i).getDni() + "',\n" +
                    "'" + alumnos.get(i).getNombre() + "',\n" +
                    "'" + alumnos.get(i).getApellido1() +  "',\n" +
                    "'" + alumnos.get(i).getApellido2() + "',\n" +
                    "'" + alumnos.get(i).getSexo() + "',\n" +
                    "'" +  alumnos.get(i).getCurso() + "'\n" + ");");
            sentencia =  conexion.prepareStatement(consulta.toString());
            sentencia.executeUpdate(consulta.toString());
        }

        for (int i = 0; i < profesores.size(); i++) {
            StringBuilder consulta = new StringBuilder();
            consulta.append("INSERT INTO `escuela`.`profesor`\n" +
                    "(`dni`,\n" +
                    "`nombre`,\n" +
                    "`apellido1`,\n" +
                    "`apellido2`,\n" +
                    "`sexo`,\n" +
                    "`curso`)\n" +
                    "VALUES\n" +
                    "('" + profesores.get(i).getDni() + "',\n" +
                    "'" + profesores.get(i).getNombre() + "',\n" +
                    "'" + profesores.get(i).getApellido1() +  "',\n" +
                    "'" + profesores.get(i).getApellido2() + "',\n" +
                    "'" + profesores.get(i).getSexo() + "',\n" +
                    "'" +  profesores.get(i).getCurso() + "'\n" + ");");
            sentencia =  conexion.prepareStatement(consulta.toString());
            sentencia.executeUpdate(consulta.toString());
        }
    }
}
