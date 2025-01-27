package extra.repaso_UDP;

// Importación de librerías.
import java.net.*;
import java.util.*;

public class Cliente {
    public static void main(String[] args) {
        
        // Declaración de variables.
        String host = "localhost";
        int puerto = 9090;
        
        // Estructura 'try-catch'.
        // Intentará crear el DatagramSocket.
        try (DatagramSocket cliente = new DatagramSocket()) {
            
            Scanner sc = new Scanner(System.in); // Creamos un escáner.

            // Mostramos los comandos disponibles para el cliente.
            System.out.println("---- COMANDOS DISPONIBLES: ----");
            System.out.println("AGREGAR <tarea>.");
            System.out.println("ELIMINAR <tarea>.");
            System.out.println("LISTAR.");
            System.out.println("------------------------------");

            // Bucle infinito 'while'.
            // Recibirá y procesará las operaciones del cliente.
            while (true) {
                System.out.println("Introduce un comando ['salir' para terminar]:");
                String comando = sc.nextLine(); // Leemos la operación introducida por el cliente.

                // Enviamos el comando al servidor creando el buffer.
                byte[] bufferEnvio = comando.getBytes(); // Convertimos el comando a bytes.

                // Creamos un paquete de envío pasándole por parámetro el buffer de envío y el puerto y dirección.
                DatagramPacket paqueteEnvio = new DatagramPacket(bufferEnvio, bufferEnvio.length, InetAddress.getByName(host), puerto);
                
                cliente.send(paqueteEnvio); // Enviamos el paquete al servidor.

                // Estructura de control 'if'.
                // Si el usuario introduce "salir", la conexión del servidor terminará.
                if (comando.equals("salir")) {
                    System.out.println("Terminando conexión con el servidor...");
                    break;
                }

                // Declaramos un array de bytes que representa el buffer recibido por el servidor.
                byte[] bufferRecepcion = new byte[1024];

                // Al igual que con el paquete de envío, declaramos un DatagramPacket que será este paquete recibido, dentro poniéndole el buffer recibido con su longitud.
                DatagramPacket paqueteRecepcion = new DatagramPacket(bufferRecepcion, bufferRecepcion.length);

                cliente.receive(paqueteRecepcion); // Recibimos el paquete.

                // Declaramos una variable 'respuesta' donde dentro crearemos un String pasándole por parámetro los datos y longitud del paquete.
                String respuesta = new String(paqueteRecepcion.getData(), 0, paqueteRecepcion.getLength());
                System.out.println("> Respuesta del servidor: " + respuesta);
            }
            // Cerramos el escáner.
            sc.close();
        } catch (Exception e) {
            System.out.println("Se ha producido un error inesperado: "+ e.getMessage());
        }
    }
}
