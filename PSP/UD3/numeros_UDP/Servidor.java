package numeros_UDP;

// Importación de librerías.
import java.io.*;
import java.net.*;

public class Servidor {
    public static void main(String[] args) {

        int puerto = 12345; // Declaramos una única variable que representa el puerto.

        // Bloque 'try-resources'.
        // Intentará crear y iniciar el DatagramSocket con el socket del servidor, en caso de que no sea posible debido a una excepción, el programa la capturará.
        try (DatagramSocket socket = new DatagramSocket(puerto)) {
            System.out.println("Servidor UDP en espera de clientes...");

            // Bucle infinito.
            // Creará los DatagramPacket tanto de recepción como de envío. En caso de que haya alguna excepción, se capturará igual.
            while (true) {
                try {
                    
                    byte[] bufferRecepcion = new byte[1024]; // Declaramos un array de bytes que representa el buffer recibido por el cliente, le asignamos simplemente un tamaño específico.
                    DatagramPacket paqueteRecepcion = new DatagramPacket(bufferRecepcion, bufferRecepcion.length); // Declaramos el paquete de recepción al igual que con el cliente.
                    socket.receive(paqueteRecepcion); // Recibimos el paquete.

                    // Deserializar el objeto.
                    ByteArrayInputStream bais = new ByteArrayInputStream(paqueteRecepcion.getData(), 0, paqueteRecepcion.getLength());
                    ObjectInputStream ois = new ObjectInputStream(bais);
                    Numeros numeros = (Numeros)ois.readObject();

                    // Estructura de control 'if'.
                    // Como se ha explicado, en caso de que el número sea 0 o menor. El programa saldrá del bucle significando el cierre.
                    if (numeros.getNumero() <= 0) {
                        System.out.println("El cliente ha terminado la conexión.");
                        break;
                    }

                    // Calcular cuadrado y cubo.
                    int numero = numeros.getNumero();
                    numeros.setCuadrado((long) numero * numero);
                    numeros.setCubo((long) numero * numero * numero);

                    // Serializar el objeto actualizado.
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    ObjectOutputStream oos = new ObjectOutputStream(baos);
                    oos.writeObject(numeros);
                    byte[] bufferEnvio = baos.toByteArray();

                    // Enviar respuesta al cliente.
                    DatagramPacket paqueteEnvio = new DatagramPacket(bufferEnvio, bufferEnvio.length, paqueteRecepcion.getAddress(), paqueteRecepcion.getPort());
                    socket.send(paqueteEnvio);

                } catch (IOException | ClassNotFoundException e) {
                    System.err.println("Error al procesar el cliente: " + e.getMessage());
                }
            }

        } catch (IOException e) {
            System.err.println("Error en el servidor UDP: " + e.getMessage());
        }
    }
}

