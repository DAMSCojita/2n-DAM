package funcionAlmacenadaDNI;

import java.sql.*;

public class Test {
    public static void main(String[] args) {

        // Declaración de variables.
        String url = "jdbc:mysql://localhost:3306/activitat_3_1"; // Declaramos la variable que representa el path de la base de datos.
        String user = "root"; // Declaramos la variable que representa el usuario.
        String pwd = ""; // Declaramos la variable que representa la contraseña.
        String dni_cliente = "12345678A"; // Declaramos una variable que representa el DNI del cliente.

        // Estructura 'try-resources'.
        // Intentará establecer la conexión con la base de datos y en caso de que no pueda capturará la excepción y la mostrará por consola.
        try (Connection conexion = DriverManager.getConnection(url, user, pwd)) {

            String llamaFuncion = "{? = CALL ObtenerApellidos(?)}"; // Creamos una variable que representa el llamado a la función.
            // Otro 'try-resources'.
            // Intentará llamar y ejecutar la función y capturará cualquier excepción que se produzca.
            try (CallableStatement callableStatement = conexion.prepareCall(llamaFuncion)) {

                // Registramos el primer parámetro como parámetro de salida (el valor devuelto por la función).
                callableStatement.registerOutParameter(1, Types.VARCHAR);

                // Establecemos el valor del segundo parámetro (el DNI del cliente) como entrada.
                callableStatement.setString(2, dni_cliente);

                // Ejecutamos la llamada a la función almacenada.
                callableStatement.execute();

                // Recuperamos el valor del parámetro de salida en una nueva variable, que contiene los apellidos del cliente.
                String apellidos = callableStatement.getString(1);

                System.out.println("Apellidos del cliente con DNI " + dni_cliente + ": " + apellidos);
            }
        } catch (SQLException e) {
            System.err.println("Error en la conexión o consulta: " + e.getMessage());
        }
    }
}

