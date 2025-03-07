package sedesYdepartamentos;

// Importación de librerías.
import java.sql.*;

public class Test {

    // Declaración de variables estáticas.
    static String url = "jdbc:mysql://localhost:3306/empresa"; // Declaramos el URL de la base de datos a la que nos conectaremos en una variable.
    static String user = "root"; // Declararemos el usuario de la base de datos en una variable.
    static String pwd = ""; // Declararemos la contraseña de la base de datos en una variable.

    public static void main(String[] args) {
        // Estructura 'try-resources'.
        // Se conectará a la base de datos y en caso de que haya una excepción la capturará.
        try (Connection conexion = DriverManager.getConnection(url, user, pwd)) {
            conexion.setAutoCommit(false); // Deshabilitamos el modo de autocommit.

            int sede_id = crearSede(conexion, "Sede Central"); // Creamos una sede y guardamos su ID.
            int departamento1_id = crearDepartamento(conexion, "Recursos Humanos", sede_id); // Creamos un departamento y guardamos su ID.
            int departamento2_id = crearDepartamento(conexion, "Tecnología", sede_id); // Creamos un departamento y guardamos su ID.

            // Creamos empleados y los asignamos a los departamentos.
            crearEmpleado(conexion, "Juan Pérez", departamento1_id);
            crearEmpleado(conexion, "Ana Gómez", departamento1_id);
            crearEmpleado(conexion, "Carlos López", departamento2_id);
            crearEmpleado(conexion, "Marta Ruiz", departamento2_id);

            conexion.commit(); // Confirmamos la transacción.

            System.out.println("> Se ha creado la base de datos con sus datos especificados."); // Imprimimos un mensaje de confirmación en consola.
        } catch (SQLException e) {
            System.out.println("Se ha producido un error al intentar establecer conexión con la base de datos: " + e.getMessage());
        }
    }

    // Creamos un método para crear una sede en la base de datos.
    private static int crearSede(Connection conexion, String nombre) throws SQLException {
        String sql = "INSERT INTO Sede (nombre) VALUES (?)"; // Declaramos la consulta SQL en una variable.
        // Estructura 'try-resources'.
        // Ejecutaremos la consulta en un PreparedStatement y en caso de que haya una excepción la capturará y avisará.
        try (PreparedStatement stmt = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, nombre); // Establecemos el nombre de la sede.
            stmt.executeUpdate(); // Ejecutamos la consulta.
            ResultSet rs = stmt.getGeneratedKeys(); // Guardamos el ID de la sede.
            return rs.next() ? rs.getInt(1) : -1; // Retornamos el ID de la sede usando un ternario. Devolvemos el valor de la primera columna si hay resultados en el `ResultSet`, o `-1` si no hay filas.
        } catch (SQLException e) {
            System.out.println("Se ha producido un error al ejecutar la consulta: " + e.getMessage());
            return -1;
        }
    }

    // Creamos un método para crear un departamento en la base de datos.
    private static int crearDepartamento(Connection conexion, String nombre, int sede_id) throws SQLException {
        String sql = "INSERT INTO Departamento (nombre, sede_id) VALUES (?, ?)"; // Declaramos la consulta SQL en una variable.
        // Estructura 'try-resources'.
        // Ejecutaremos la consulta en un PreparedStatement y en caso de que haya una excepción la capturará y avisará.
        try (PreparedStatement stmt = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, nombre); // Establecemos el nombre del departamento.
            stmt.setInt(2, sede_id); // Establecemos el ID de la sede.
            stmt.executeUpdate(); // Ejecutamos la consulta.
            ResultSet rs = stmt.getGeneratedKeys(); // Guardamos el ID del departamento.
            return rs.next() ? rs.getInt(1) : -1; // Retornamos el ID de la sede usando un ternario. Devolvemos el valor de la primera columna si hay resultados en el `ResultSet`, o `-1` si no hay filas.
        } catch (SQLException e) {
            System.out.println("Se ha producido un error al ejecutar la consulta: " + e.getMessage());
            return -1;
        }
    }

    // Creamos un método para crear un empleado en la base de datos.
    private static void crearEmpleado(Connection conexion, String nombre, int departamento_id) throws SQLException {
        String sql = "INSERT INTO Empleado (nombre, departamento_id) VALUES (?, ?)"; // Declaramos la consulta SQL en una variable.
        // Estructura 'try-resources'.
        // Ejecutaremos la consulta en un PreparedStatement y en caso de que haya una excepción la capturará y avisará.
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, nombre); // Establecemos el nombre del empleado.
            stmt.setInt(2, departamento_id); // Establecemos el ID del departamento.
            stmt.executeUpdate(); // Ejecutamos la consulta.
        } catch (SQLException e) {
            System.out.println("Se ha producido un error al ejecutar la consulta: " + e.getMessage());
        }
    }
}