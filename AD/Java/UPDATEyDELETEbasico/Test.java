package UPDATEyDELETEbasico;

import java.sql.*;

public class Test {

    public static void main(String[] args) {

        // Declaración de variables.
        String url = "jdbc:mysql://localhost:3306/activitat_3_1"; // Declaramos la variable que representa el path de la base de datos.
        String user = "root"; // Declaramos la variable que representa el usuario.
        String pwd = ""; // Declaramos la variable que representa la contraseña.

        // Bloque 'try-resources'.
        // Tratará de establecer la conexión con la base de datos en base a los parámetros correspondientes.
        // Dentro haremos todas las consultas necesarias.
        // En caso de que se produzca alguna excepción, el programa la capturará.
        try (Connection conexion = DriverManager.getConnection(url, user, pwd)) {
            Statement stmt = conexion.createStatement(); // Creamos una sentencia y la unimos a la conexión. 


            // Declaramos una variable para crear la tabla y dentro ponemos la consulta.
            String crearTabla = """
                CREATE TABLE IF NOT EXISTS CLIENTES (
                    DNI CHAR(9) PRIMARY KEY,       
                    APELLIDOS VARCHAR(50) NOT NULL, 
                    CP CHAR(5)                     
                )
            """;
            stmt.execute(crearTabla); // Ejecutamos la sentencia SQL para crear la tabla.

            // Declaramos una variable para insertar datos en la tabla y dentro ponemos la consulta.
            String insertarDatos = """
                INSERT INTO CLIENTES (DNI, APELLIDOS, CP) VALUES
                ('12345678A', 'LOPEZ', '28001'),   
                ('23456789B', 'GOMEZ', '35001'),  
                ('34567890C', 'PEREZ', '41001')   
            """;
            stmt.execute("DELETE FROM CLIENTES"); // Eliminamos todos los datos existentes en la tabla CLIENTES.
            stmt.execute(insertarDatos); // Insertamos los datos iniciales en la tabla.

            // Actualizamos los apellidos y el código postal del cliente con DNI '12345678A',
            // insertamos un nuevo cliente con DNI '56789012B',
            // actualizamos los apellidos y establecemos el CP a NULL para el cliente con DNI '23456789B',
            // y finalmente eliminamos todos los clientes que no están en la lista especificada ('12345678A', '56789012B', '23456789B').
            stmt.execute("UPDATE CLIENTES SET APELLIDOS = 'NADALES', CP = '44126' WHERE DNI = '12345678A'");
            stmt.execute("INSERT INTO CLIENTES (DNI, APELLIDOS, CP) VALUES ('56789012B', 'SAMPER', '29730')");
            stmt.execute("UPDATE CLIENTES SET APELLIDOS = 'ROJAS', CP = NULL WHERE DNI = '23456789B'");
            stmt.execute("DELETE FROM CLIENTES WHERE DNI NOT IN ('12345678A', '56789012B', '23456789B')");

            System.out.println("> Tabla creada y actualizada."); // Añadimos un mensaje de confirmación.
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
