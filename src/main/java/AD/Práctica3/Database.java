package AD.Práctica3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Database {

    static String c_ruta_padre = "src/main/java/AD/Práctica3";
    static String c_log_file = "log_data_base";
    static String c_tipo_info = "I";
    static String c_tipo_error = "E";
    static String c_tipo_aviso = "W";

    public static void main(String[] args) throws Exception {
        String v_ruta_log = c_ruta_padre + "/Logs";

        Date v_fecha = new Date();
        DateFormat v_fecha_hora = new SimpleDateFormat("yyyyMMdd_HHmmss");
        FileWriter v_file_log = new FileWriter(v_ruta_log+"/"+c_log_file+v_fecha_hora.format(v_fecha) + ".log");
        BufferedWriter v_log_writter = new BufferedWriter(v_file_log);



        try {
            System.out.println("Comienza la ejecución");
            escribe_log(v_log_writter, c_tipo_info, "Comienza la ejecución");

            Connection v_con_db = conecta_db(v_log_writter);
            lanzaConsulta(v_con_db, "Select Code, Name, Continent from world.country CO limit 5", v_log_writter);

            lanzaConsulta(v_con_db,
                    "SELECT " +
                            "world.country.Name AS Pais, " +
                            "world.city.Name AS Capital " +
                            "FROM world.country " +
                            "JOIN world.city ON world.country.Capital = world.city.ID " +
                            "JOIN world.countrylanguage ON world.country.Code = world.countrylanguage.CountryCode " +
                            "WHERE world.countrylanguage.Language = 'Spanish' " +
                            "AND world.countrylanguage.IsOfficial = 'T';",
                    v_log_writter
            );

            lanzaConsulta(v_con_db,
                    "SELECT " +
                            "world.country.Name AS Pais, " +
                            "COUNT(world.countrylanguage.Language) AS NumeroIdiomas " +
                            "FROM world.country " +
                            "JOIN world.countrylanguage ON world.country.Code = world.countrylanguage.CountryCode " +
                            "GROUP BY world.country.Code " +
                            "ORDER BY NumeroIdiomas DESC " +
                            "LIMIT 5;",
                    v_log_writter
            );

            lanzaConsulta(v_con_db,
                    "SELECT " +
                            "world.country.Name AS Pais, " +
                            "world.country.Population AS Poblacion " +
                            "FROM world.country " +
                            "ORDER BY world.country.Population DESC " +
                            "LIMIT 1;",
                    v_log_writter
            );



            System.out.println("Fin de la ejecución");
            escribe_log(v_log_writter, c_tipo_info, "Fin de la ejecución");
        } catch (Exception e) {
            System.out.println("Error");
        } finally {
            if (v_file_log != null) {
                v_file_log.close();
            }
        }
    }

    private static void escribe_log(BufferedWriter v_log_buf, String v_tipo, String v_traza) {
        // Fecha y formato de la fecha para el mensaje de log
        Date v_fecha_actual = new Date();
        DateFormat v_fecha_hora_actual = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        try {
            // Escribimos el mensaje directamente en el log con la fecha y el texto
            v_log_buf.write(v_fecha_hora_actual.format(v_fecha_actual) + " - " + v_tipo + " - " + v_traza + "\n");
            v_log_buf.flush();
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Error mientras se intentaba escribir en el log: " + ex.getMessage());
            System.exit(1);
        }
    }

    private static Connection conecta_db(BufferedWriter v_log_buf) {
        Connection v_conexion = null; // Comentar
        escribe_log(v_log_buf, c_tipo_info, "Estableciendo conexión");
        try {

        } catch (Exception e) {
            System.out.println("Error estableciendo la conexión.");
            escribe_log(v_log_buf, c_tipo_error, "Error estableciendo la conexión.");
        }
        try {
            v_conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306", "Desarrollador", "usuario");
            escribe_log(v_log_buf, c_tipo_info, "Conexión establecida");
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
            escribe_log(v_log_buf, c_tipo_error, "Error estableciendo conexión " + e.getMessage());
        }
        return v_conexion; // Comentar
    }

    private static void imprimeInforme(ResultSet i_datos, BufferedWriter v_log_buf) throws SQLException {
        ResultSetMetaData v_rs_metadatos = i_datos.getMetaData();
        int v_num_cols = v_rs_metadatos.getColumnCount();
        escribe_log(v_log_buf, c_tipo_info, "Imprimiendo informe");

        // He cambiado esta parte respecto a tu código para poder visualizar mejor la información que obtengo de la BBDD

        // Uso un string builder para meter el texto que voy a imprimir porque me parece más cómodo
        // Creamos un encabezado simple, el %-25s es que dejo 25 espacios hacia la derecha
        StringBuilder v_encabezado = new StringBuilder();
        for (int i = 1; i <= v_num_cols; i++) {
            v_encabezado.append(String.format("%-25s", v_rs_metadatos.getColumnLabel(i)));
        }
        System.out.println(v_encabezado);
        // Uso el repeat para hacer una barrera entre el encabezado y los textos
        System.out.println("=".repeat(v_encabezado.length()));

        // Aquí obtengo los datos y gracias al string builder los voy agregando poco a poco
        // Si es null he preferido no dejarlo en blanco y para que no de un NullPointerException he puesto que
        // Si el siguiente valor es null que lo indique en la tabla
        while (i_datos.next()) {
            StringBuilder v_fila = new StringBuilder();
            for (int i = 1; i <= v_num_cols; i++) {
                String v_valor = i_datos.getString(i);
                if (v_valor == null) v_valor = "NULL";
                v_fila.append(String.format("%-25s", v_valor));
            }
            System.out.println(v_fila);
        }

        System.out.println("-".repeat(v_encabezado.length()));
        escribe_log(v_log_buf, c_tipo_info, "Informe impreso");
    }


    private static void lanzaConsulta(Connection i_conexion, String i_consulta, BufferedWriter v_log_buf) {
        Statement v_sentencia = null;
        ResultSet v_resultado = null;

        escribe_log(v_log_buf, c_tipo_info, "Lanzando consulta: " + i_consulta);

        try {
            v_sentencia = i_conexion.createStatement();
            v_resultado = v_sentencia.executeQuery(i_consulta);
            escribe_log(v_log_buf, c_tipo_info, "Consulta ejecutada");
            imprimeInforme(v_resultado, v_log_buf);
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
    }
}
