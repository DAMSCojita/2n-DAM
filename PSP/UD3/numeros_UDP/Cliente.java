package numeros_UDP;

// Importación de librerías.
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {

        // Declaración de variables.
        String host = "localhost";
        int puerto = 12345;

        // Bloque 'try-resources'.
        // Intentará crear el DatagramSocket, en caso de que se produzca una excepción (por ejemplo que se inicie mientras el servidor no lo está), la capturará.
        try (DatagramSocket socket = new DatagramSocket()) {
            Scanner sc = new Scanner(System.in); // Creamos un escáner.
            int numero; // Declaramos una variable que representará el número del usuario.

            // Estructura de control 'do-while'.
            // Mientras el número que introduzca el usuario sea mayor a 0, el bucle se repetirá.
            do {
                System.out.print("Introduce un número (<= 0 para salir): ");
                numero = sc.nextInt(); // Leemos el número introducido por el usuario.

                Numeros numeros = new Numeros(); // Creamos un objeto de la clase 'Numeros'.
                numeros.setNumero(numero); // Usamos el setter y establecemos el número en el objeto.

                ByteArrayOutputStream baos = new ByteArrayOutputStream(); // Declaramos un ByteArrayOutputStream que será necesario para escribir los datos en bytes.
                ObjectOutputStream oos = new ObjectOutputStream(baos); // Declaramos un ObjectOutputStream y dentro la variable con los bytes.
                oos.writeObject(numeros); // Escribimos el objeto de numeros en el Stream.
                byte[] bufferEnvio = baos.toByteArray(); // Declaramos un array de bytes que representa el buffer de envio, dentro le añadimos la variable que contiene esos mismos bytes.

                // Declaramos un DatagramPacket que representará el envio del paquete, pero dentro le asignamos
                // el buffer de envio y su longitud, además del host y del puerto.
                DatagramPacket paqueteEnvio = new DatagramPacket(bufferEnvio, bufferEnvio.length, InetAddress.getByName(host), puerto); 
                socket.send(paqueteEnvio); // Enviamos el paquete al servidor.

                // Estructura de control 'if'.
                // Si el número introducido por el usuario es menor o igual a 0, salimos del bucle.
                // En caso contrario, leemos el objeto de numeros devolviendolo desde el Stream y mostramos sus propiedades.
                if (numero <= 0) {
                    break;
                }

                byte[] bufferRecepcion = new byte[1024]; // Declaramos un array de bytes que representa el buffer recibido por el servidor, esta vez le asignamos simplemente un tamaño específico.

                // Al igual que con el paquete de envío, declaramos un DatagramPacket que será este paquete recibido, dentro poniéndole el buffer recibido con su longitud.
                DatagramPacket paqueteRecepcion = new DatagramPacket(bufferRecepcion, bufferRecepcion.length);
                socket.receive(paqueteRecepcion); // Aquí agarramos el paquete.

                // Declaramos un ByteArrayInputStream con el paquete recibido y sus datos.
                ByteArrayInputStream bais = new ByteArrayInputStream(paqueteRecepcion.getData(), 0, paqueteRecepcion.getLength());
                ObjectInputStream ois = new ObjectInputStream(bais); // Creamos un ObjectInputStream.
                numeros = (Numeros)ois.readObject(); // Leemos el objeto de números.

                // Mostramos el resultado de los cálculos.
                System.out.println("> Cuadrado: " + numeros.getCuadrado());
                System.out.println("> Cubo: " + numeros.getCubo());

            } while (numero > 0);
            sc.close(); // Cerramos escáner.
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error en el cliente: " + e.getMessage());
        }
    }
}
