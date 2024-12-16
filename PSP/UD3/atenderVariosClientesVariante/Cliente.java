package atenderVariosClientesVariante;

// Importación de librerías.
import java.io.*;
import java.net.*;

public class Cliente {
    public static void main(String[] args) {
        try {
            // Declaración de variables.
            String host = "localhost"; // Declaramos una variable con el host.
            int puerto = 1234; // Declaramos una variable con el puerto.

            Socket cliente = new Socket(host, puerto); // Creamos un cliente y le pasamos por parámetro el host y el puerto.

            ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream()); // Declaramos el flujo para leer el mensaje del servidor.
            String mensaje = (String)ois.readObject(); // Leemos el mensaje mandado por el servidor.

            System.out.println("Mensaje recibido por el servidor: " + mensaje);

            // Cerramos el flujo y el cliente.
            ois.close();
            cliente.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
