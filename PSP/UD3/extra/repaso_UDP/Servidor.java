package extra.repaso_UDP;

// Importación de librerías.
import java.net.*;
import java.util.*;

public class Servidor {
    public static void main(String[] args) {
        
        // Declaración de variables.
        int puerto = 9090;
        ArrayList<String> listaTareas = new ArrayList<>(); // Declaramos un ArrayList que representa la lista de tareas.

        // Bloque 'try-resources'.
        // Intentará crear el socket, en caso de que se produzca una excepción (por ejemplo que se inicie mientras el servidor no lo está), la capturará.
        try (DatagramSocket servidor = new DatagramSocket(puerto)) {
            System.out.println("Servidor UDP en espera de clientes...");

            // Bucle infinito 'while'.
            // Creará los DatagramPacket tanto de recepción como de envío.
            while (true) {

                // Declaramos un array de bytes que representa el buffer recibido por el cliente.
                byte[] bufferRecepcion = new byte[1024];

                // Declaramos un DatagramPacket que será este paquete recibido, dentro poniéndole el buffer recibido con su longitud.
                DatagramPacket paqueteRecepcion = new DatagramPacket(bufferRecepcion, bufferRecepcion.length);

                servidor.receive(paqueteRecepcion); // Recibimos el paquete.

                // Declaramos una variable para representar el comando donde dentro creamos un String pasándole por parámetro los datos y longitud.
                String comandoCompleto = new String(paqueteRecepcion.getData(), 0, paqueteRecepcion.getLength());
                System.out.println("Comando recibido por el cliente: " + comandoCompleto);

                // Separamos el comando del argumento (si lo hay).
                String[] partes = comandoCompleto.split(" ", 2); // Dividimos el comando y argumento.
                String comando = partes[0].toUpperCase(); // Obtenemos el comando principal.
                String argumento = (partes.length > 1) ? partes[1].trim() : ""; // Obtenemos el argumento usando ternarios.

                String respuesta; // Declaramos una variable que se encarga de escribir las respuestas del servidor a partir de este punto.

                // Estructura de control 'switch'.
                // Irá intercalando entre los comandos posibles y realizará las acciones que correspondan.
                switch (comando) {
                    // Caso del comando "AGREGAR".
                    case "AGREGAR":
                        // Estructura de control 'if'.
                        // En caso de que haya un argumento, añaadirá la tarea a la lista de tareas y responderá con éxito.
                        if (!argumento.isEmpty()) {
                            // Otra estructura de control 'if'.
                            // Verificará de que efectivamente, si contiene el argumento.
                            if (!listaTareas.contains(argumento)) {
                                listaTareas.add(argumento); // Añadimos la tarea a la lista.
                                respuesta = "Tarea '" + argumento + "' añadida con éxito.";
                            } else { // En caso de que esa tarea ya exista, lo indicamos.
                                respuesta = "La tarea '" + argumento + "' ya existe.";
                            }
                        } else { // En caso de que no se proporcione una tarea correspondiente.
                            respuesta = "Error: Debes proporcionar una tarea para agregar.";
                        }
                        break;
                    // Caso del comando "ELIMINAR".
                    case "ELIMINAR":
                        // Estructura de control 'if'.
                        // En caso de que haya un argumento, eliminará la tarea de la lista de tareas y responderá con éxito.
                        if (!argumento.isEmpty()) {
                            // Otra estructura de control 'if'.
                            // Eliminará la tarea con el argumento.
                            if (listaTareas.remove(argumento)) {
                                respuesta = "Tarea '" + argumento + "' eliminada con éxito.";
                            } else { // En caso de que la tarea no exista.
                                respuesta = "La tarea '" + argumento + "' no existe.";
                            }
                        } else {
                            respuesta = "Error: Debes proporcionar una tarea para eliminar.";
                        }
                        break;
                    // Caso del comando "LISTAR".
                    case "LISTAR":
                        // Estructura de control 'if'.
                        // En caso de que la lista de tareas esté vacía, responderá con que no hay tareas pendientes.
                        // En caso contrario, responderá con la lista de tareas pendientes.
                        if (listaTareas.isEmpty()) {
                            respuesta = "No hay tareas pendientes.";
                        } else {
                            // Usamos de la función 'join' para unir todas las tareas en una cadena separadas por comas.
                            respuesta = "Tareas pendientes: " + String.join(", ", listaTareas); 
                        }
                        break;
                    // Caso del comando "SALIR".
                    case "SALIR":
                        respuesta = "Finalizando conexión...";
                        break;
                    // Caso por defecto.
                    default:
                        respuesta = "Comando desconocido. Usa AGREGAR, ELIMINAR o LISTAR.";
                }

                // Enviamos el comando al cliente creando el buffer.
                byte[] bufferEnvio = respuesta.getBytes();

                // Creamos un paquete de envío pasándole por parámetro el buffer de envío y el puerto y dirección.
                DatagramPacket paqueteEnvio = new DatagramPacket(bufferEnvio, bufferEnvio.length, paqueteRecepcion.getAddress(), paqueteRecepcion.getPort());

                servidor.send(paqueteEnvio); // Enviamos el paquete al cliente.

                System.out.println("Respuesta enviada al cliente: " + respuesta);

                // Estructura de control 'if'.
                // Si el comando es 'salir', finalizaremos la conexión.
                if (comando.equalsIgnoreCase("SALIR")) {
                    System.out.println("El cliente ha terminado la conexión...");
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Se ha producido un error inesperado: " + e.getMessage());
        }
    }
}
