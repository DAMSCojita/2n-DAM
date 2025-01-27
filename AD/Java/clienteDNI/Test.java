package clienteDNI; 

// Importación de librerías.
import java.sql.*;
import java.util.Scanner; 

public class Test { 

    public static void main(String[] args) {

        // Declaración de variables.
        String url = "jdbc:mysql://localhost:3306/activitat_3_1"; // Declaramos la variable que representa el path de la base de datos.
        String user = "root"; // Declaramos la variable que representa el usuario.
        String pwd = ""; // Declaramos la variable que representa la contraseña.

        Scanner sc = new Scanner(System.in); // Creamos un objeto Scanner para capturar la entrada del usuario.

        // Solicitamos al usuario que ingrese los DNIs o escriba 'TODOS'.
        System.out.println("Ingrese el DNI de los clientes separados por comas (o escriba 'TODOS' para mostrar todos): ");
        String entrada = sc.nextLine(); // Capturamos la entrada del usuario.

        // Bloque 'try-with-resources'.
        // Este bloque tratará de establecer la conexión con la base de datos en base a los parámetros proporcionados.
        // Dentro de este bloque realizaremos todas las operaciones necesarias con la base de datos.
        // En caso de que ocurra una excepción, será capturada y se liberarán los recursos automáticamente.
        try (Connection connection = DriverManager.getConnection(url, user, pwd)) {
            Statement stmt = connection.createStatement(); // Creamos un objeto Statement para ejecutar consultas SQL.

            // Declaramos una variable para crear la tabla CLIENTES si no existe.
            String crearTabla = """
                CREATE TABLE IF NOT EXISTS CLIENTES (
                    DNI CHAR(9) PRIMARY KEY,       
                    APELLIDOS VARCHAR(50) NOT NULL, 
                    CP CHAR(5)                     
                )
            """;
            stmt.execute(crearTabla); // Ejecutamos la sentencia SQL para crear la tabla si no existe.

            // Verificamos si la tabla está vacía para insertar datos iniciales.
            String verificarDatos = "SELECT COUNT(*) AS total FROM CLIENTES"; // Consulta para contar los registros en la tabla.
            ResultSet rsVerificar = stmt.executeQuery(verificarDatos); // Ejecutamos la consulta.
            rsVerificar.next(); // Movemos el cursor al primer resultado.
            if (rsVerificar.getInt("total") == 0) { // Verificamos si el total de registros es cero.
                // Insertamos datos iniciales en la tabla CLIENTES.
                String insertarDatos = """
                    INSERT INTO CLIENTES (DNI, APELLIDOS, CP) VALUES
                    ('12345678A', 'LOPEZ', '28001'),   
                    ('23456789B', 'GOMEZ', '35001'),  
                    ('34567890C', 'PEREZ', '41001')   
                """;
                stmt.execute(insertarDatos); // Ejecutamos la consulta para insertar los datos.
            }

            // Validamos si el usuario ingresó 'TODOS' o una lista de DNIs.
            if (entrada.equalsIgnoreCase("TODOS")) { // Si el usuario ingresó 'TODOS'.
                ResultSet resultado = stmt.executeQuery("SELECT * FROM CLIENTES"); // Consultamos todos los registros de la tabla CLIENTES.
                while (resultado.next()) { // Iteramos sobre los resultados.
                    // Mostramos los datos de cada cliente.
                    System.out.println("> DNI: " + resultado.getString("DNI") + ", Apellidos: " + resultado.getString("APELLIDOS") + ", CP: " + resultado.getString("CP"));
                }
                resultado.close(); // Cerramos el ResultSet.
            } else {
                String[] dnis = entrada.split(","); // Dividimos los DNIs ingresados por comas.
                for (String dni : dnis) { // Iteramos sobre cada DNI ingresado.
                    dni = dni.trim(); // Eliminamos espacios extra del DNI.
                    // Preparamos una consulta para buscar un cliente por su DNI.
                    try (PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM CLIENTES WHERE DNI = ?")) {
                        pstmt.setString(1, dni); // Asignamos el valor del DNI a la consulta.
                        ResultSet resultado = pstmt.executeQuery(); // Ejecutamos la consulta.
                        if (resultado.next()) { // Si encontramos un resultado.
                            // Mostramos los datos del cliente.
                            System.out.println("> DNI: " + resultado.getString("DNI") + ", Apellidos: " + resultado.getString("APELLIDOS") + ", CP: " + resultado.getString("CP"));
                        } else {
                            // Indicamos que no se encontró el cliente con ese DNI.
                            System.out.println("No se encontró el cliente con DNI: " + dni);
                        }
                        resultado.close(); // Cerramos el ResultSet.
                    }
                }
            }
            stmt.close(); // Cerramos el Statement.
        } catch (SQLException e) {
            // Capturamos y mostramos cualquier error que ocurra durante la ejecución del programa.
            System.err.println("Error al consultar los clientes: " + e.getMessage());
        } finally {
            sc.close(); // Cerramos el Scanner.
        }
    }
}
