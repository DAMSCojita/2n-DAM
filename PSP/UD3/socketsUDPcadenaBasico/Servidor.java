package socketsUDPcadenaBasico;

// Importación de librerías.
import java.net.*;

public class Servidor {
    public static void main(String[] args) {
        try {
            String mensajeRecibido = ""; // Declaramos una variable para representar el mensaje recibido.
            byte[] mensaje_en_bytes = new byte[1024]; // Declaramos una variable para representar el mensaje en bytes.
            DatagramSocket socket = new DatagramSocket(12345); // Declaramos un socket con su respectivo puerto.
            System.out.println("Esperando mensaje del cliente...");

            // Bucle 'while'.
            // Mientras el mensaje recibido no sea un astrisco, el programa iterará leeyendo el mensaje.
            while (!mensajeRecibido.equalsIgnoreCase("*")) {
                DatagramPacket recibo = new DatagramPacket(mensaje_en_bytes, mensaje_en_bytes.length); // Declaramos un datagrama y obtenemos el mensaje en bytes.
                socket.receive(recibo); // Recibimos el mensaje.

                mensajeRecibido = new String(recibo.getData(), 0, recibo.getLength()); // Declaramos una variable para obtener el mensaje con su longitud.
                System.out.println("Mensaje recibido: " + mensajeRecibido);

                String mensaje_en_mayusculas = mensajeRecibido.toUpperCase(); // Transformamos el mensaje en mayúsculas y lo guardamos en una variable.
                byte[] mensaje = mensaje_en_mayusculas.getBytes(); // Tomamos los bytes del mensaje en otra variable.

                DatagramPacket envio = new DatagramPacket(mensaje, mensaje.length, recibo.getAddress(), recibo.getPort()); // Declaramos un datagrama de envio con el mensaje.
                socket.send(envio); // Enviamos el mensaje.
            }
            socket.close(); // Cerramos el socket.
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
