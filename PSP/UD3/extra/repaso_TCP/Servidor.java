package extra.repaso_TCP;

// Importación de librerías.
import java.io.*;
import java.net.*;

public class Servidor {
    public static void main(String[] args) {
        
        // Estructura 'try-catch'.
        // Intentará iniciar el servidor, gestionará las operaciones recibidas y realizará los cálculos. En caso de que se produzca una excepción el programa
        // la capturará.
        try {
            ServerSocket servidor = new ServerSocket(8080); // Declaramos el ServerSocket para el servidor.

            Socket cliente = servidor.accept(); // Declaramos un socket para el cliente y aceptamos la conexión con el servidor.

            // Declaramos los flujos de salida y de entrada.
            ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());

            // Bucle infinito 'while'.
            // En cada iteración, el servidor esperará una operación del cliente y calculará el resultado.
            while (true) {
                // Otra estructura 'try-catch'.
                try {
                    String operacionCliente = (String)ois.readObject(); // Creamos una variable que representa la operación del cliente y leemos el flujo.
                    System.out.println("Operación recibida: " + operacionCliente);

                    // Estructura de control 'if'.
                    // Si el cliente introdució "salir" previamente el servidor finalizará la conexión.
                    if (operacionCliente.equalsIgnoreCase("salir")) {
                        System.out.println("Finalizando conexión...");
                        break;
                    }

                    String respuesta = calcularOperacion(operacionCliente); // Declaramos una variable que representa la respuesta que se enviará al cliente y le pasamos el método de cálculo correspondiente.
                    oos.writeObject(respuesta); // Escribimos la respuesta en el flujo.
                    oos.flush(); // Limpiamos el flujo.

                } catch (Exception e) {
                    System.out.println("Error procesando la operación: " + e.getMessage());
                    break;
                }
            }
            // Cerramos los flujos, cliente y servidor.
            oos.close();
            ois.close();
            cliente.close();
            servidor.close();
        } catch (Exception e) {
            System.out.println("Error con el servidor: " + e.getMessage());
        }
    }

    // Creamos un método para calcular la operación.
    private static String calcularOperacion(String operacionCliente) {
        // Estructura 'try-catch'.
        // Intentará realizar los cálculos pertinentes y en caso de que haya alguna excepción la capturará.
        try {
            String[] partes = operacionCliente.split(" "); // Declaramos un array con las partes y las dividimos por espacios.
            // Estructura de control 'if'.
            // Si el número de partes es distinto de 3, el método devolverá un error.
            // En caso contrario, calcula el resultado de la operación y lo devuelve.
            if (partes.length != 3) {
                return "Error. Formato incorrecto.";
            }

            String operacion = partes[0].toLowerCase(); // Declaramos una variable para la operación y transformamos en minúsculas la primera entrada de la operación.
            // Declaramos las variables de la operación.
            double x = Double.parseDouble(partes[1]); // Asignamos el primer número en la segunda posición del array.
            double y = Double.parseDouble(partes[2]); // Asignamos el segundo número en la tercera posición del array.

            // Estructura de control 'switch'.
            // Irá intercalando entre las operaciones posibles y realizará los cálculos que correspondan.
            switch (operacion) {
                // Caso de que sea "suma".
                case "suma":
                    return "> Resultado: " + (x + y);
                // Caso de que sea "resta".
                case "resta":
                    return "> Resultado: " + (x - y);
                // Caso de que sea "multiplicacion".
                case "multiplicacion":
                    return "> Resultado: " + (x * y);
                // Caso de que sea "division".
                case "division":
                    // Estructura de control 'if'.
                    // En caso de que alguna división sea 0, devolverá un error.
                    if (x == 0 || y == 0) {
                        return "División por cero no permitida.";
                    }
                    return "> Resultado: " + (x / y);
                // Caso por defecto, si no coincide con ninguna de las anteriores, devolverá un error.
                default:
                    return "Operación no válida.";
            }
        } catch (NumberFormatException e) {
            return "Error. Los números deben de ser válidos: " + e.toString();
        }
    }
}
