package socketsUDPcadenaBasico;

// Importación de librerías.
import java.io.*;
import java.net.*;
import java.util.*;

public class Cliente {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in); // Creamos un escáner.
            InetAddress destino = InetAddress.getLocalHost(); // Declaramos una variable que representa el destino de la dirección IP.
            int port = 12345; // Declaramos una variable para representar el puerto.
            String mensaje = ""; // Declaramos una variable para representar el mensaje y la inicializamos.
            byte[] mensaje_en_bytes = new byte[1024]; // Declaramos una variable para representar el mensaje en bytes.

            DatagramSocket socket = new DatagramSocket(); // Declaramos un socket.
            socket.setSoTimeout(5000); // Establecemos un tiempo para el socket.

            // Bucle 'while'.
            // Iterará hasta que el usuario ponga un asterisco en la consola.
            while (!mensaje.equalsIgnoreCase("*")) {
                System.out.println("Escribe un mensaje ('*' para terminar):");
                mensaje = sc.nextLine(); // Leemos el mensaje del usuario.

                // Estructura de control 'if'.
                // Si el mensaje es un asterisco, se enviará un paquete con el mensaje, la longitud, destino y puerto. 
                if (mensaje.equals("*")) {
                    socket.send(new DatagramPacket(mensaje.getBytes(), mensaje.length(), destino, port));
                    break; // Salimos del 'if' y del programa.
                }

                mensaje_en_bytes = mensaje.getBytes(); // Obtenemos los bytes del mensaje.
                DatagramPacket envio = new DatagramPacket(mensaje_en_bytes, mensaje_en_bytes.length, destino, port); // Creamos otro datagrama que representa el envio del mensaje anterior con su información.
                socket.send(envio); // Enviamos el mensaje.

                // Bloque 'try-catch'.
                // Intentará recibir el mensaje por el servidor. En caso de que no pueda por cualquier cosa el programa capturará la excepción.
                try {
                    DatagramPacket recibo = new DatagramPacket(new byte[1024], 1024); // Creamos un datagrama con el mensaje recibido del servidor.
                    socket.receive(recibo); // Recibimos el mensaje.

                    String mensajeMayusculas = new String(recibo.getData(), 0, recibo.getLength()); // Creamos una variable para recibir el mensaje en mayúsculas.
                    System.out.println("Respuesta recibida: " + mensajeMayusculas); // Mostramos la respuesta.
                } catch (SocketTimeoutException e) {
                    System.out.println("Error: El paquete se ha perdido.");
                }
            }
            // Cerramos el socket y el escáner.
            socket.close();
            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
